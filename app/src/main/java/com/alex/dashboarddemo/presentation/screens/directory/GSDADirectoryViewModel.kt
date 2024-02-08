package com.alex.dashboarddemo.presentation.screens.directory

import com.alex.dashboarddemo.domain.use_cases.GSDAUseCases
import com.alex.dashboarddemo.mvi.GSDAHomeContract
import com.alex.dashboarddemo.mvi.GSDAHomeContract.DashBoardApiState.*
import com.alex.dashboarddemo.presentation.screens.dashboard.GSDADashboardViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GSDADirectoryViewModel @Inject constructor(
    private val useCases: GSDAUseCases,
) : GSDADashboardViewModel(useCases) {
    /*private fun getInfo(key: String) {
        viewModelScope.launch(Dispatchers.IO) {
            useCases.getRemoteConfigUseCase.invoke(key).collect { directoryData ->
                when (directoryData) {
                    is GSDAResult.Loading -> {
                        setState { copy(getInfo = OnLoading) }
                    }

                    is GSDAResult.Success -> {
                        setState { copy(getInfo = OnSuccess(directoryData.data)) }
                    }

                    is GSDAResult.Failure -> {
                        setEffect { GSDAHomeContract.Effect.ShowToast }
                    }
                }
            }
        }
    }

    private fun setNavigationExtern(route: String) {
        viewModelScope.launch(Dispatchers.IO) {
            setState { copy(getInfo = OnNavigate(route)) }
        }
    }

    override fun createInitialState(): GSDAHomeContract.DashBoardState {
        return GSDAHomeContract.DashBoardState(
            Idle,
        )
    }

    override fun handleEvent(event: GSDAHomeContract.Event) {
        when (event) {
            is GSDAHomeContract.Event.OnInit -> {
                getInfo(event.key)
            }

            is GSDAHomeContract.Event.OnUpdate -> {}

            is GSDAHomeContract.Event.OnNavigate -> {
                setNavigationExtern(event.route)
            }
        }
    }*/

    override fun createInitialState(): GSDAHomeContract.DashBoardState {
        return super.createInitialState()
    }

    override fun handleEvent(event: GSDAHomeContract.Event) {
        super.handleEvent(event)
    }
}
