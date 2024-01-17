package com.alex.dashboarddemo.domain.repository

import com.alex.dashboarddemo.data.remote.Result
import com.alex.dashboarddemo.domain.model.GSDADashboard
import kotlinx.coroutines.flow.Flow

interface GSDARemoteDataSource {
    fun getDashboardData(): Flow<Result<GSDADashboard>>
}
