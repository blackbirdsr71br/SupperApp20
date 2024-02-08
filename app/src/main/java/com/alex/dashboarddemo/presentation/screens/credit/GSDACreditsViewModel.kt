package com.alex.dashboarddemo.presentation.screens.credit

import androidx.lifecycle.viewModelScope
import com.alex.dashboarddemo.data.remote.GSDAResult
import com.alex.dashboarddemo.domain.use_cases.GSDAUseCases
import com.alex.dashboarddemo.mvi.GSDABaseViewModel
import com.alex.dashboarddemo.mvi.GSDAHomeContract
import com.alex.dashboarddemo.mvi.GSDAHomeContract.DashBoardApiState.*
import com.alex.dashboarddemo.presentation.screens.dashboard.GSDADashboardViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GSDACreditsViewModel @Inject constructor(
    private val useCases: GSDAUseCases,
) : GSDADashboardViewModel(useCases) {
    /*private fun getConfig(key: String) {
        viewModelScope.launch(Dispatchers.IO) {
            useCases.getRemoteConfigUseCase.invoke(key).collect { creditData ->
                when (creditData) {
                    is GSDAResult.Loading -> {
                        setState { copy(getInfo = OnLoading) }
                    }

                    is GSDAResult.Success -> {
                        setState { copy(getInfo = OnSuccess(creditData.data)) }
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
    }*/

    override fun createInitialState(): GSDAHomeContract.DashBoardState {
        return super.createInitialState()
    }

    override fun handleEvent(event: GSDAHomeContract.Event) {
        super.handleEvent(event)
    }
}
