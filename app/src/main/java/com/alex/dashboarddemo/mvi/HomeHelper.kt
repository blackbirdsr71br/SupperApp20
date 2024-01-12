package com.alex.dashboarddemo.mvi

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

object HomeHelper {

    private val _RouteMap = MutableSharedFlow<String?>()
    var routeMap = _RouteMap.asSharedFlow()

    suspend fun setRoute(route: String?) = _RouteMap.emit(route)
}
