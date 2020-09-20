package com.example.piratehegemony.data.repository

import com.example.piratehegemony.data.api.PirateService
import com.example.piratehegemony.data.model.PirateInfo
import com.example.piratehegemony.utils.NetworkManager
import com.skydoves.sandwich.message
import com.skydoves.sandwich.onError
import com.skydoves.sandwich.onException
import com.skydoves.sandwich.suspendOnSuccess
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class PirateDetailRepository {
    private val pirateService: PirateService =
        NetworkManager.provideRetrofit(NetworkManager.provideOkHttpClient())
            .create(PirateService::class.java)

    suspend fun fetchPirateInfo(
        pirateId: Int,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) = flow<PirateInfo> {
        val response = pirateService.fetchPirateInfo(pirateId)
        response.suspendOnSuccess {
            if (data != null) {
                val pirateInfo: PirateInfo = data ?: PirateInfo(
                    id = 0,
                    name = "",
                    height = 0,
                    weight = 0,
                    attack = 0
                )
                emit(pirateInfo)
                onSuccess()
            }
        }.onError {
            onError(message())
        }.onException {
            onError(message())
        }
    }.flowOn(Dispatchers.IO)
}