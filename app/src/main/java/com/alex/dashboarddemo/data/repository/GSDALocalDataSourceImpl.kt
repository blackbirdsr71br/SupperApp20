package com.alex.dashboarddemo.data.repository

import android.util.Log
import com.alex.dashboarddemo.data.local.dao.GSDALocalRemoteConfigDao
import com.alex.dashboarddemo.domain.entity.GSDARemoteConfig
import com.alex.dashboarddemo.domain.model.GSDADashboard
import com.alex.dashboarddemo.domain.repository.GSDALocalDataSource
import com.alex.dashboarddemo.utils.toDashboardModel
import com.squareup.moshi.Moshi

class GSDALocalDataSourceImpl(
    private val remoteConfigDao: GSDALocalRemoteConfigDao,
    private val moshiInit: Moshi,
) : GSDALocalDataSource {

    override suspend fun getLocalData(key: String): GSDADashboard {
        return try {
            val localData = remoteConfigDao.getRemoteConfig(key).data
            localData.toDashboardModel(moshiInit)
        } catch (e: Exception) {
            GSDADashboard(data = emptyList())
        }
    }

    override suspend fun saveLocalData(key: String, remoteData: String) {
        try {
            remoteConfigDao.insert(
                GSDARemoteConfig(
                    id = key,
                    data = remoteData,
                    timeStamp = System.currentTimeMillis(),
                ),
            )
        } catch (e: Exception) {
            Log.e("GSDALocalDataSourceImpl", "Error: No insert data")
        }
    }

    override suspend fun deleteData(key: String) {
        val localData = remoteConfigDao.getRemoteConfig(key)
        remoteConfigDao.delete(localData)
    }
}
