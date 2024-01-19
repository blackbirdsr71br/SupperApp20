package com.alex.dashboarddemo.domain.use_Case

import com.alex.dashboarddemo.data.remote.Result
import com.alex.dashboarddemo.data.repository.GSDAFirebaseRepository
import com.alex.dashboarddemo.domain.model.GSDADashboard
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GSDAConfigUseCase @Inject constructor(
    private val repository: GSDAFirebaseRepository
) {
    operator fun invoke(key: String): Flow<Result<GSDADashboard>> {
        return repository.getConfig(key)
    }
}