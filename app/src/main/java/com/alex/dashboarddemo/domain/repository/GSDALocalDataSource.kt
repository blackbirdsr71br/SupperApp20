package com.alex.dashboarddemo.domain.repository

import com.alex.dashboarddemo.domain.model.GSDADashboard

interface GSDALocalDataSource {
    suspend fun getLocalData(key: String): GSDADashboard

    suspend fun saveLocalData(key: String, remoteData: String)

    suspend fun deleteData(key: String)
}
