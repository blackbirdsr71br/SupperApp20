package com.alex.dashboarddemo.domain.use_Case

import com.alex.dashboarddemo.data.remote.Result
import com.alex.dashboarddemo.data.repository.GSDADashboardRepository
import com.alex.dashboarddemo.domain.model.GSDADashboard
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GSDADashboardUseCase @Inject constructor(
    private val repository: GSDADashboardRepository,
) {

    operator fun invoke(): Flow<Result<GSDADashboard>> {
        return repository.getDashboardData()
    }
}
