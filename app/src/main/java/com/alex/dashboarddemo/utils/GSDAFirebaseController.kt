package com.alex.dashboarddemo.utils

import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings

class GSDAFirebaseController {
    private val remoteConfig: FirebaseRemoteConfig = Firebase.remoteConfig
    private val configSettings = remoteConfigSettings {
        minimumFetchIntervalInSeconds = 0
    }

    init {
        remoteConfig.setConfigSettingsAsync(configSettings)
    }

    fun getRemoteInstance() = remoteConfig
}
