package com.alex.dashboarddemo.data.repository

import android.util.Log
import com.alex.dashboarddemo.data.local.dao.GSDALocalRemoteConfigDao
import com.alex.dashboarddemo.domain.entity.GSDARemoteConfig
import com.alex.dashboarddemo.domain.repository.GSDALocalDataSource

class GSDALocalDataSourceImpl(
    private val remoteConfigDao: GSDALocalRemoteConfigDao,
) : GSDALocalDataSource {

    override suspend fun getLocalData(key: String): GSDARemoteConfig? {
        return try {
            remoteConfigDao.getRemoteConfig(key)
        } catch (e: Exception) {
            null
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

    override suspend fun deleteData(lastUpdate: GSDARemoteConfig?) {
        if (lastUpdate != null) {
            remoteConfigDao.deleteRemoteConfig()
        }
    }
}
