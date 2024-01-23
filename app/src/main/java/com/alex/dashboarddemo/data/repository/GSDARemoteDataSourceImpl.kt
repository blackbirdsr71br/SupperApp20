package com.alex.dashboarddemo.data.repository

import com.alex.dashboarddemo.data.remote.GSDAApiService
import com.alex.dashboarddemo.data.remote.GSDAResult
import com.alex.dashboarddemo.domain.model.GSDADashboard
import com.alex.dashboarddemo.domain.repository.GSDARemoteDataSource
import com.alex.dashboarddemo.utils.GSDAFirebaseController
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GSDARemoteDataSourceImpl(
    private val dashboardApi: GSDAApiService,
    private val firebase: GSDAFirebaseController,
) : GSDARemoteDataSource {

    override fun getDashboardData(): Flow<GSDAResult<GSDADashboard>> = flow {
        emit(GSDAResult.Loading)
        try {
            emit(GSDAResult.Success(dashboardApi.getDashboard()))
        } catch (e: Exception) {
            emit(GSDAResult.Failure(e))
        }
    }

    override fun getRemoteConfig(key: String): Flow<GSDAResult<GSDADashboard>> = flow {
        emit(GSDAResult.Loading)
        val result = firebase.getRemoteInstance().getString(key)
        if (result.isNotEmpty()) {
            val data = try {
                Gson().fromJson(result, GSDADashboard::class.java)
            } catch (e: Exception) {
                GSDADashboard(data = emptyList())
            }
            emit(GSDAResult.Success(data))
        } else {
            firebase.getRemoteInstance().fetchAndActivate()
            emit(GSDAResult.Success(GSDADashboard(data = emptyList())))
        }
    }
}
