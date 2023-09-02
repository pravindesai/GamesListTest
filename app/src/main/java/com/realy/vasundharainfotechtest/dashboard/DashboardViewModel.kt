package com.realy.vasundharainfotechtest.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.realy.vasundharainfotechtest.data.model.ObjNetworkResponse
import com.realy.vasundharainfotechtest.data.repository.AppDetailsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

sealed interface AppState{

    object Empty: AppState
    object Loading: AppState
    data class Error(val msg:String): AppState
    data class Failure(var msg:String): AppState
    data class Sucess(val response: ObjNetworkResponse): AppState
}

class DashboardViewModel:ViewModel() {

    var appDetailsRepository:AppDetailsRepository
    private val appsStateFlow: MutableStateFlow<AppState> = MutableStateFlow(AppState.Empty)
    val _appsStateFlow: StateFlow<AppState> = appsStateFlow


    init {
        appDetailsRepository = AppDetailsRepository()
        getAllApps()
    }

    fun getAllApps() = viewModelScope.launch(Dispatchers.IO) {
        appsStateFlow.value = AppState.Loading
        appDetailsRepository.getAllAppsData().catch {e->
            appsStateFlow.value = AppState.Failure(e.message.toString())
        }.collect {response->
            response?.let {
                appsStateFlow.value = AppState.Sucess(response)

            }?: run {
                appsStateFlow.value = AppState.Empty
            }

        }
    }

}