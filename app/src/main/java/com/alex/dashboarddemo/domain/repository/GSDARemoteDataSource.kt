package com.alex.dashboarddemo.domain.repository

import com.alex.dashboarddemo.data.remote.GSDAResult
import com.alex.dashboarddemo.domain.model.GSDADashboard
import kotlinx.coroutines.flow.Flow

interface GSDARemoteDataSource {
    fun getRemoteConfig(key: String): Flow<GSDAResult<GSDADashboard>>
}
