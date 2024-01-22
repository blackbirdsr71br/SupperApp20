package com.alex.dashboarddemo.mvi

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

object GSDAHomeHelper {

    private val _RouteMap = MutableSharedFlow<String?>()
    var routeMap = _RouteMap.asSharedFlow()

    suspend fun setRoute(route: String?) = _RouteMap.emit(route)
}
