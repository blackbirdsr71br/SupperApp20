package com.alex.dashboarddemo.data.repository

import android.util.Log
import com.alex.dashboarddemo.data.remote.GSDAApiService
import com.alex.dashboarddemo.data.remote.GSDAResult
import com.alex.dashboarddemo.domain.model.GSDADashboard
import com.alex.dashboarddemo.domain.repository.GSDARemoteDataSource
import com.alex.dashboarddemo.utils.GSDAFirebaseController
import com.squareup.moshi.Moshi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GSDARemoteDataSourceImpl(
    private val dashboardApi: GSDAApiService,
    private val firebase: GSDAFirebaseController,
) : GSDARemoteDataSource {

    override fun getRemoteConfig(key: String): Flow<GSDAResult<GSDADashboard>> = flow {
        emit(GSDAResult.Loading)
        try {
            val result = firebase.getRemoteInstance().getString(key)
            Log.d("LordMiau2", "Res $result")
            if (result.isNotEmpty()) {
                val data = try {
                    val moshi = Moshi.Builder().build()
                    val dashboard = moshi.adapter(GSDADashboard::class.java)
                    dashboard.fromJson(result)
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
