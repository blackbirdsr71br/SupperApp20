package com.alex.dashboarddemo.presentation.main

import androidx.lifecycle.viewModelScope
import com.alex.dashboarddemo.data.Repository
import com.alex.dashboarddemo.data.Result
import com.alex.dashboarddemo.domain.model.Dashboard
import com.alex.dashboarddemo.mvi.BaseViewModel
import com.alex.dashboarddemo.mvi.HomeContract
import com.alex.dashboarddemo.mvi.HomeHelper
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel :
    BaseViewModel<HomeContract.Event, HomeContract.DashBoardState, HomeContract.Effect>() {
    private val _dashboardItems = MutableStateFlow<Result<List<Dashboard.Item>>>(Result.Loading)
    val dashboardItems: StateFlow<Result<List<Dashboard.Item>>> = _dashboardItems

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

    private fun loadData(showRandom: Boolean = false) {
        _dashboardItems.value = Result.Loading
        viewModelScope.launch {
            delay(1000) // delay added to slow-down API request
            Repository.getDashboardData(showRandom)
                .collect {
                    _dashboardItems.value = it
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

    private fun setNavigationExtern(Route: String) {
        viewModelScope.launch {
            setState {
                copy(
                    getInfo = HomeContract.DashBoardApiState.OnNavigate(Route),
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
