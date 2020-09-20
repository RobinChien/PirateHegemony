package com.example.piratehegemony.ui.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.piratehegemony.data.model.Pirate
import com.example.piratehegemony.data.repository.PirateListRepository
import kotlinx.coroutines.Dispatchers

class PirateListViewModel(application: Application) :
    AndroidViewModel(application) {
    private val pirateListRepository: PirateListRepository by lazy { PirateListRepository() }

    fun pirateListLiveData(): LiveData<List<Pirate>> =
        liveData(viewModelScope.coroutineContext + Dispatchers.IO) {
            emitSource(
                pirateListRepository.fetchPirateList(
                    onSuccess = { },
                    onError = { }
                ).asLiveData()
            )
        }
}