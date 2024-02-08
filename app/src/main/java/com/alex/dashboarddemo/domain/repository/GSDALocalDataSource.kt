package com.alex.dashboarddemo.domain.repository

import com.alex.dashboarddemo.domain.entity.GSDALocalRemoteConfig

interface GSDALocalDataSource {
    suspend fun getLocalData(key: String): GSDALocalRemoteConfig?

    suspend fun saveLocalData(key: String, remoteData: String)

    suspend fun deleteData(lastUpdate: GSDALocalRemoteConfig?)
}
