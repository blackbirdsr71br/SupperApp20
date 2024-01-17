package com.alex.dashboarddemo.presentation.screens.main

import androidx.lifecycle.viewModelScope
import com.alex.dashboarddemo.data.Result
import com.alex.dashboarddemo.domain.use_Case.GSDADashboardUseCase
import com.alex.dashboarddemo.mvi.BaseViewModel
import com.alex.dashboarddemo.mvi.HomeContract
import com.alex.dashboarddemo.mvi.HomeHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GSDADashboardViewModel @Inject constructor(
    private val dashUseCase: GSDADashboardUseCase,
) : BaseViewModel<HomeContract.Event, HomeContract.DashBoardState, HomeContract.Effect>() {

    private val _dashboardModelItems = MutableStateFlow(GSDADashboardState())
    val dashboardItems: StateFlow<GSDADashboardState> = _dashboardModelItems

    init {
        viewModelScope.launch {
            // Esto es opcional
            setState {
                copy(
                    getInfo = HomeContract.DashBoardApiState.Idle,
                )
            }
            //

            HomeHelper.routeMap.collect {
                it?.let {
                    println("Estoy recibiendo -> $it")
                    setNavigationExtern(it)
                }
            }
        }
    }

    private fun loadData() {
        viewModelScope.launch {
            dashUseCase().collect { dash ->
                when (dash) {
                    is Result.Loading -> {
                        _dashboardModelItems.value.copy(isLoading = true)
                    }

                    is Result.Success -> {
                        _dashboardModelItems.value.copy(
                            isLoading = false,
                            items = dash.data,
                        )
                    }

                    is Result.Failure -> {
                        _dashboardModelItems.value.copy(
                            isLoading = false,
                            errorMessage = dash.error.message,
                        )
                    }
                }
            }
        }
    }

    private fun navigation(route: String) {
        viewModelScope.launch {
            setState {
                copy(
                    getInfo = HomeContract.DashBoardApiState.OnNavigate(route),
                )
            }
        }
    }

    private fun setNavigationExtern(route: String) {
        viewModelScope.launch {
            setState {
                copy(
                    getInfo = HomeContract.DashBoardApiState.OnNavigate(route),
                )
            }
        }
    }

    override fun createInitialState(): HomeContract.DashBoardState {
        return HomeContract.DashBoardState(
            HomeContract.DashBoardApiState.Idle,
        )
    }

    override fun handleEvent(event: HomeContract.Event) {
        when (event) {
            is HomeContract.Event.OnInit -> {
                loadData()
            }

            is HomeContract.Event.OnUpdate -> {}

            is HomeContract.Event.OnNavigate -> {
                navigation(event.route)
            }
        }
    }
}
