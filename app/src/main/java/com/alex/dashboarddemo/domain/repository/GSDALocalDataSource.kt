package com.alex.dashboarddemo.domain.repository

import com.alex.dashboarddemo.domain.entity.GSDARemoteConfig

interface GSDALocalDataSource {
    suspend fun getLocalData(key: String): GSDARemoteConfig?

    suspend fun saveLocalData(key: String, remoteData: String)

    suspend fun deleteData(lastUpdate: GSDARemoteConfig?)
}
