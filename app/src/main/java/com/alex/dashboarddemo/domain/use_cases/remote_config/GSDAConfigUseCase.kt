package com.alex.dashboarddemo.domain.use_cases.remote_config

import com.alex.dashboarddemo.data.remote.GSDAResult
import com.alex.dashboarddemo.data.repository.GSDADashboardRepository
import com.alex.dashboarddemo.domain.model.GSDADashboard
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GSDAConfigUseCase @Inject constructor(
    private val repository: GSDADashboardRepository,
) {
    operator fun invoke(key: String): Flow<GSDAResult<GSDADashboard>> {
        return repository.getConfig(key)
    }
}
