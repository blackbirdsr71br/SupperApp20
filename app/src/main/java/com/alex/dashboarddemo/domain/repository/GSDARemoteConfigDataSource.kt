package com.alex.dashboarddemo.domain.repository

import com.google.firebase.remoteconfig.FirebaseRemoteConfig

interface GSDARemoteConfigDataSource {
    suspend fun fetchRemoteConfig(): Boolean

    fun getRemoteInstance(): FirebaseRemoteConfig
}
