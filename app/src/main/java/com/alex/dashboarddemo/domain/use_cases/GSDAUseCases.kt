package com.alex.dashboarddemo.domain.use_cases

import com.alex.dashboarddemo.domain.use_cases.remote_config.GSDAConfigUseCase

data class GSDAUseCases(
    val getRemoteConfigUseCase: GSDAConfigUseCase,
)
