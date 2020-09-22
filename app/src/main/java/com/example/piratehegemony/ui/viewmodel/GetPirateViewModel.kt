package com.example.piratehegemony.ui.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.piratehegemony.data.model.PirateInfo
import com.example.piratehegemony.data.repository.PirateDetailRepository
import kotlinx.coroutines.Dispatchers

class GetPirateViewModel(application: Application) :
    AndroidViewModel(application) {
    private val pirateDetailRepository: PirateDetailRepository by lazy { PirateDetailRepository() }

    fun pirateInfoLiveData(pirateId: Int): LiveData<PirateInfo> =
        liveData(viewModelScope.coroutineContext + Dispatchers.IO) {
            emitSource(
                pirateDetailRepository.fetchPirateInfo(
                    pirateId = pirateId,
                    onSuccess = { },
                    onError = { }
                ).asLiveData()
            )
        }
}