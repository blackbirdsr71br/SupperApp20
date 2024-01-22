package com.alex.dashboarddemo.domain.use_Case

import com.alex.dashboarddemo.data.remote.GSDAResult
import com.alex.dashboarddemo.data.repository.GSDADashboardRepository
import com.alex.dashboarddemo.domain.model.GSDADashboard
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class GSDADashboardUseCase @Inject constructor(
    private val repository: GSDADashboardRepository,
) {

    operator fun invoke(): Flow<GSDAResult<GSDADashboard>> {
        return repository.getDashboardData()
    }
}
