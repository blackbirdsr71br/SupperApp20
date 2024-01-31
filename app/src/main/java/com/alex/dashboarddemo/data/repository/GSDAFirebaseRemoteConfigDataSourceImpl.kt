package com.alex.dashboarddemo.data.repository

import com.alex.dashboarddemo.domain.repository.GSDARemoteConfigDataSource
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class GSDAFirebaseRemoteConfigDataSourceImpl(
    private val remoteConfig: FirebaseRemoteConfig,
) : GSDARemoteConfigDataSource {

    private val remoteConfigSettings = remoteConfigSettings {
        minimumFetchIntervalInSeconds = 3600
    }

    init {
        remoteConfig.setConfigSettingsAsync(remoteConfigSettings)
        CoroutineScope(Dispatchers.IO).launch {
            fetchRemoteConfig()
        }
    }

    override suspend fun fetchRemoteConfig(): Boolean {
        return try {
            remoteConfig.fetchAndActivate().await()
        } catch (e: Exception) {
            false
        }
    }

    override fun getRemoteInstance(): FirebaseRemoteConfig {
        return remoteConfig
    }
}
