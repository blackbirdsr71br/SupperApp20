package com.alex.dashboarddemo.data.repository

import com.alex.dashboarddemo.data.remote.GSDAApiService
import com.alex.dashboarddemo.data.remote.GSDAResult
import com.alex.dashboarddemo.domain.model.GSDADashboard
import com.alex.dashboarddemo.domain.repository.GSDARemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GSDARemoteDataSourceImpl(
    private val dashboardApi: GSDAApiService,
) : GSDARemoteDataSource {

    override fun getDashboardData(): Flow<GSDAResult<GSDADashboard>> = flow {
        emit(GSDAResult.Loading)
        try {
            emit(GSDAResult.Success(dashboardApi.getDashboard()))
        } catch (e: Exception) {
            emit(GSDAResult.Failure(e))
        }
    }
}
