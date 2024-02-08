package com.alex.dashboarddemo.presentation.screens.dashboard

import androidx.lifecycle.viewModelScope
import com.alex.dashboarddemo.data.remote.GSDAResult
import com.alex.dashboarddemo.domain.use_cases.GSDAUseCases
import com.alex.dashboarddemo.mvi.GSDABaseViewModel
import com.alex.dashboarddemo.mvi.GSDAHomeContract
import com.alex.dashboarddemo.mvi.GSDAHomeContract.DashBoardApiState.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
open class GSDADashboardViewModel @Inject constructor(
    private val useCase: GSDAUseCases,
) : GSDABaseViewModel<GSDAHomeContract.Event, GSDAHomeContract.DashBoardState, GSDAHomeContract.Effect>() {
    private fun getConfig(key: String) {
        viewModelScope.launch(Dispatchers.IO) {
            useCase.getRemoteConfigUseCase.invoke(key).collect {
                when (it) {
                    is GSDAResult.Loading -> {
                        setState { copy(getInfo = OnLoading) }
                    }

                    is GSDAResult.Success -> {
                        setState { copy(getInfo = OnSuccess(it.data)) }
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
                getConfig(event.key)
            }

            is GSDAHomeContract.Event.OnUpdate -> {}

            is GSDAHomeContract.Event.OnNavigate -> {
                setNavigationExtern(event.route)
            }
        }
    }
}
