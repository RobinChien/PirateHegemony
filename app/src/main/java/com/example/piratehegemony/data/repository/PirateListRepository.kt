package com.example.piratehegemony.data.repository

import android.util.Log
import com.example.piratehegemony.data.api.PirateService
import com.example.piratehegemony.data.model.Pirate
import com.example.piratehegemony.utils.NetworkManager
import com.skydoves.sandwich.message
import com.skydoves.sandwich.onError
import com.skydoves.sandwich.onException
import com.skydoves.sandwich.suspendOnSuccess
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class PirateListRepository {
    private val TAG: String = this.javaClass.name
    private val pirateService: PirateService =
        NetworkManager.provideRetrofit(NetworkManager.provideOkHttpClient()).create(PirateService::class.java)

    suspend fun fetchPirateList(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) = flow {
        val response = pirateService.fetchPirateList()
        response.suspendOnSuccess {
            if (data != null) {
                Log.d(TAG, "Data: $data")
                val pirates: List<Pirate> = data?.results ?: listOf()
                emit(pirates)
                onSuccess()
            }
        }.onError {
            onError(message())
        }.onException {
            onError(message())
        }
    }.flowOn(Dispatchers.IO)
}