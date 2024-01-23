package com.alex.dashboarddemo.domain.use_cases

import com.alex.dashboarddemo.domain.use_cases.remote_config.GSDAConfigUseCase
import com.alex.dashboarddemo.domain.use_cases.remote_config.GSDADashboardUseCase

data class GSDAUseCases(
    val getRemoteConfigUseCase: GSDAConfigUseCase,
    val getDashConfigUseCase: GSDADashboardUseCase,
)
