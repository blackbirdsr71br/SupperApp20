package com.alex.dashboarddemo.data.repository

import android.util.Log
import androidx.room.withTransaction
import com.alex.dashboarddemo.data.local.GSDARemoteConfigDB
import com.alex.dashboarddemo.domain.entity.GSDALocalRemoteConfig
import com.alex.dashboarddemo.domain.repository.GSDALocalDataSource

class GSDALocalDataSourceImpl(
    private val remoteConfigDB: GSDARemoteConfigDB,
) : GSDALocalDataSource {

    override suspend fun getLocalData(key: String): GSDALocalRemoteConfig? {
        return remoteConfigDB.localRemoteConfigDao().getRemoteConfig(key)
    }

    override suspend fun saveLocalData(key: String, remoteData: String) {
        try {
            remoteConfigDB.withTransaction {
                remoteConfigDB.localRemoteConfigDao().insert(
                    GSDALocalRemoteConfig(
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

    override suspend fun deleteData(lastUpdate: GSDALocalRemoteConfig?) {
        if (lastUpdate != null) {
            remoteConfigDB.withTransaction {
                remoteConfigDB.localRemoteConfigDao().delete(lastUpdate)
            }
        }
    }
}
