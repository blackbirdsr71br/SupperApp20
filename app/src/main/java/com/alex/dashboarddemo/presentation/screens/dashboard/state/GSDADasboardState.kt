package com.alex.dashboarddemo.presentation.screens.dashboard.state

import com.alex.dashboarddemo.domain.model.GSDADashboard

sealed class GSDADashboardState {
    object Loading : GSDADashboardState()

    object Failure : GSDADashboardState()

    data class Success(val items: GSDADashboard? = null)
}
