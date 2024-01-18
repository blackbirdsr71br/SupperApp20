package com.alex.dashboarddemo.domain.usecases

import com.alex.dashboarddemo.data.remote.Result
import com.alex.dashboarddemo.data.repository.GSDADashboardRepository
import com.alex.dashboarddemo.domain.model.GSDADashboard
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class GSDADashboardUseCase @Inject constructor(
    private val repository: GSDADashboardRepository
) {
    operator fun invoke(): Flow<Result<GSDADashboard>> {
        return repository.getDashboardData()
    }
}
