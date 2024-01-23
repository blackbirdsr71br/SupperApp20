package com.alex.dashboarddemo.presentation.screens.main.state

import com.alex.dashboarddemo.domain.model.GSDADashboard

data class GSDADashboardState(
    val isLoading: Boolean = false,
    val items: GSDADashboard? = null,
    val errorMessage: String? = null,
)
