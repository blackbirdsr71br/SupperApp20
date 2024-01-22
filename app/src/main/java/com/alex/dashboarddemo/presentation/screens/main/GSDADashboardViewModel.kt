package com.alex.dashboarddemo.presentation.screens.main

import androidx.lifecycle.viewModelScope
import com.alex.dashboarddemo.data.remote.GSDAResult
import com.alex.dashboarddemo.data.remote.Result
import com.alex.dashboarddemo.domain.use_Case.GSDAConfigUseCase
import com.alex.dashboarddemo.domain.use_Case.GSDADashboardUseCase
import com.alex.dashboarddemo.mvi.GSDABaseViewModel
import com.alex.dashboarddemo.mvi.GSDAHomeContract
import com.alex.dashboarddemo.mvi.GSDAHomeHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GSDADashboardViewModel @Inject constructor(
    private val dashUseCase: GSDADashboardUseCase,
    private val configUseCase: GSDAConfigUseCase
) : BaseViewModel<HomeContract.Event, HomeContract.DashBoardState, HomeContract.Effect>() {

    private val _dashboardModelItems: MutableStateFlow<GSDADashboardState> =
        MutableStateFlow(GSDADashboardState())
    val dashboardItems: StateFlow<GSDADashboardState> = _dashboardModelItems

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
            dashUseCase().collect { dash ->
                when (dash) {
                    is GSDAResult.Loading -> {
                        _dashboardModelItems.value = GSDADashboardState(isLoading = true)
                    }

                    is GSDAResult.Success -> {
                        _dashboardModelItems.value = GSDADashboardState(
                            isLoading = false,
                            items = dash.data,
                        )
                    }

                    is GSDAResult.Failure -> {
                        _dashboardModelItems.value = GSDADashboardState(
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
            configUseCase.invoke("BottomBar").collect {
                when (it) {
                    is Result.Failure -> {}
                    Result.Loading -> {}
                    is Result.Success -> {}
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
