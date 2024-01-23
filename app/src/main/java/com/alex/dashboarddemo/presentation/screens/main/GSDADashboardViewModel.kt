package com.alex.dashboarddemo.presentation.screens.main

import androidx.lifecycle.viewModelScope
import com.alex.dashboarddemo.data.remote.GSDAResult
import com.alex.dashboarddemo.domain.use_cases.GSDAUseCases
import com.alex.dashboarddemo.mvi.GSDABaseViewModel
import com.alex.dashboarddemo.mvi.GSDAHomeContract
import com.alex.dashboarddemo.mvi.GSDAHomeHelper
import com.alex.dashboarddemo.presentation.screens.main.state.GSDADashboardState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GSDADashboardViewModel @Inject constructor(
    private val useCase: GSDAUseCases,
) : GSDABaseViewModel<GSDAHomeContract.Event, GSDAHomeContract.DashBoardState, GSDAHomeContract.Effect>() {

    private val _dashboardItems: MutableStateFlow<GSDADashboardState> =
        MutableStateFlow(GSDADashboardState())
    val dashboardItems: StateFlow<GSDADashboardState> = _dashboardItems

    private val _remoteItems: MutableStateFlow<GSDADashboardState> =
        MutableStateFlow(GSDADashboardState())

    init {
        viewModelScope.launch(Dispatchers.IO) {
            // Esto es opcional
            setState {
                copy(
                    getInfo = GSDAHomeContract.DashBoardApiState.Idle,
                )
            } //

            GSDAHomeHelper.routeMap.collect {
                it?.let {
                    println("Estoy recibiendo -> $it")
                    setNavigationExtern(it)
                }
            }
        }
    }

    private fun loadData() {
        viewModelScope.launch(Dispatchers.IO) {
            useCase.getDashConfigUseCase().collect { dash ->
                when (dash) {
                    is GSDAResult.Loading -> {
                        _dashboardItems.value = GSDADashboardState(isLoading = true)
                    }

                    is GSDAResult.Success -> {
                        _dashboardItems.value = GSDADashboardState(
                            isLoading = false,
                            items = dash.data,
                        )
                    }

                    is GSDAResult.Failure -> {
                        _dashboardItems.value = GSDADashboardState(
                            isLoading = false,
                            errorMessage = dash.error.message,
                        )
                    }
                }
            }
        }
    }

    private fun getConfig() {
        viewModelScope.launch(Dispatchers.IO) {
            useCase.getRemoteConfigUseCase.invoke("SA_Explore").collect {
                when (it) {
                    is GSDAResult.Loading -> {}

                    is GSDAResult.Success -> {
                        _remoteItems.value = GSDADashboardState(
                            isLoading = false,
                            items = it.data,
                        )
                    }

                    is GSDAResult.Failure -> {
                        _remoteItems.value = GSDADashboardState(
                            isLoading = false,
                            errorMessage = it.error.message,
                        )
                    }
                }
            }
        }
    }

    private fun navigation(route: String) {
        viewModelScope.launch(Dispatchers.IO) {
            setState {
                copy(
                    getInfo = GSDAHomeContract.DashBoardApiState.OnNavigate(route),
                )
            }
        }
    }

    private fun setNavigationExtern(route: String) {
        viewModelScope.launch(Dispatchers.IO) {
            setState {
                copy(
                    getInfo = GSDAHomeContract.DashBoardApiState.OnNavigate(route),
                )
            }
        }
    }

    override fun createInitialState(): GSDAHomeContract.DashBoardState {
        return GSDAHomeContract.DashBoardState(
            GSDAHomeContract.DashBoardApiState.Idle,
        )
    }

    override fun handleEvent(event: GSDAHomeContract.Event) {
        when (event) {
            is GSDAHomeContract.Event.OnInit -> {
                loadData()
                getConfig()
            }

            is GSDAHomeContract.Event.OnUpdate -> {}

            is GSDAHomeContract.Event.OnNavigate -> {
                navigation(event.route)
            }
        }
    }
}
