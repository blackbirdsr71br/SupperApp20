package com.alex.dashboarddemo.data.repository

import android.util.Log
import androidx.room.withTransaction
import com.alex.dashboarddemo.data.local.GSDARemoteConfigDB
import com.alex.dashboarddemo.domain.entity.GSDARemoteConfig
import com.alex.dashboarddemo.domain.repository.GSDALocalDataSource

class GSDALocalDataSourceImpl(
    private val remoteConfigDB: GSDARemoteConfigDB,
) : GSDALocalDataSource {

    override suspend fun getLocalData(key: String): GSDARemoteConfig? {
        return remoteConfigDB.remoteConfigDao().getRemoteConfig(key)
    }

    override suspend fun saveLocalData(key: String, remoteData: String) {
        try {
            remoteConfigDB.withTransaction {
                remoteConfigDB.remoteConfigDao().insert(
                    GSDARemoteConfig(
                        id = key,
                        data = remoteData,
                        timeStamp = System.currentTimeMillis(),
                    ),
                )
            }
        } catch (e: Exception) {
            Log.e("GSDALocalDataSourceImpl", "Error: No insert data. Details $e")
        }
    }

    override suspend fun deleteData(lastUpdate: GSDARemoteConfig?) {
        if (lastUpdate != null) {
            remoteConfigDB.withTransaction {
                remoteConfigDB.remoteConfigDao().delete(lastUpdate)
            }
        }
    }
}
