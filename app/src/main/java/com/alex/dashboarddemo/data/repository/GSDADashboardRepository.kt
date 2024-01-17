package com.alex.dashboarddemo.data.repository

import com.alex.dashboarddemo.data.Result
import com.alex.dashboarddemo.domain.model.GSDADashboard
import com.alex.dashboarddemo.domain.repository.GSDARemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GSDADashboardRepository @Inject constructor(
    private val remote: GSDARemoteDataSource,
) {

    fun getDashboardData(): Flow<Result<GSDADashboard>> = flow {
        remote.getDashboardData()
    }
}
