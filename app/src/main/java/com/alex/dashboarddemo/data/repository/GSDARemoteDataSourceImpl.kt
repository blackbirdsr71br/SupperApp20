package com.alex.dashboarddemo.data.repository

import com.alex.dashboarddemo.data.remote.GSDAResult
import com.alex.dashboarddemo.domain.entity.GSDARemoteConfig
import com.alex.dashboarddemo.domain.model.GSDADashboard
import com.alex.dashboarddemo.domain.repository.GSDALocalDataSource
import com.alex.dashboarddemo.domain.repository.GSDARemoteDataSource
import com.alex.dashboarddemo.utils.GSDAFirebaseController
import com.alex.dashboarddemo.utils.getInitialRefreshData
import com.alex.dashboarddemo.utils.getMockDataFromKey
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
        val lastData = localData.getLocalData(key)
        if (lastData != null) {
            if (getInitialRefreshData(lastData.timeStamp)) {
                emit(GSDAResult.Success(getRemoteConfigData(key, lastData)))
            } else {
                emit(GSDAResult.Success(getDataFromDBOrMockData(key, lastData)))
            }
        } else {
            emit(GSDAResult.Success(getRemoteConfigData(key)))
        }
    }

    private suspend fun getRemoteConfigData(
        key: String,
        dataDB: GSDARemoteConfig? = null,
    ): GSDADashboard {
        return try {
            val result = firebase.getRemoteInstance().getString(key)
            if (result.isNotEmpty()) {
                localData.deleteData(dataDB)
                localData.saveLocalData(key, result)
                result.toDashboardModel(moshiInit)
            } else {
                getDataFromDBOrMockData(key, dataDB)
            }
        } catch (e: Exception) {
            getDataFromDBOrMockData(key, dataDB)
        }
    }

    private fun getDataFromDBOrMockData(
        key: String,
        dataDB: GSDARemoteConfig?,
    ): GSDADashboard {
        return dataDB?.data?.toDashboardModel(moshiInit) ?: getMockDataFromKey(key, moshiInit)
    }
}
