package com.alex.dashboarddemo.data.repository

import com.alex.dashboarddemo.data.remote.GSDAResult
import com.alex.dashboarddemo.domain.model.GSDADashboard
import com.alex.dashboarddemo.domain.repository.GSDALocalDataSource
import com.alex.dashboarddemo.domain.repository.GSDARemoteDataSource
import com.alex.dashboarddemo.utils.GSDAFirebaseController
import com.alex.dashboarddemo.utils.toDashboardModel
import com.squareup.moshi.Moshi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GSDARemoteDataSourceImpl(
    private val firebase: GSDAFirebaseController,
    private val moshiInit: Moshi,
    private val localData: GSDALocalDataSource,
) : GSDARemoteDataSource {
    override fun getRemoteConfig(key: String): Flow<GSDAResult<GSDADashboard>> = flow {
        emit(GSDAResult.Loading)
        try {
            val result = firebase.getRemoteInstance().getString(key)
            if (result.isNotEmpty()) {
                val data = try {
                    localData.saveLocalData(key, result)
                    result.toDashboardModel(moshiInit)
                } catch (e: Exception) {
                    GSDADashboard(data = emptyList())
                }
                emit(GSDAResult.Success(data))
            } else {
                firebase.getRemoteInstance().fetchAndActivate()
                emit(GSDAResult.Success(GSDADashboard(data = emptyList())))
            }
        } catch (e: Exception) {
            firebase.getRemoteInstance().fetchAndActivate()
            emit(GSDAResult.Success(GSDADashboard(data = emptyList())))
        }
    }
}
