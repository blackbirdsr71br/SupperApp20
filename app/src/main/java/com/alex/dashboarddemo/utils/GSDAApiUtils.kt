package com.alex.dashboarddemo.utils

import com.alex.dashboarddemo.domain.model.GSDADashboard
import com.alex.dashboarddemo.utils.GSDAConstants.KEY_EXPLORE
import com.squareup.moshi.Moshi
import java.io.File

fun getInitialRefreshData(
    lastUpdate: Long,
    cacheTimeout: Int = 5,
): Boolean {
    val currentTime = System.currentTimeMillis()
    val diffInMinutes = (currentTime - lastUpdate) / 1000 / 60

    return (diffInMinutes <= cacheTimeout)
}

fun String.toDashboardModel(moshi: Moshi): GSDADashboard {
    val dashboardData = moshi.adapter(GSDADashboard::class.java)
    return dashboardData.fromJson(this) ?: GSDADashboard(data = emptyList())
}

fun getMockDataFromKey(
    key: String,
    moshiInit: Moshi,
): GSDADashboard {
    return when (key) {
        KEY_EXPLORE -> {
            val json = File("").bufferedReader().use { it.readText() }
            json.toDashboardModel(moshiInit)
        }

        else -> {
            val json = File("").bufferedReader().use { it.readText() }
            json.toDashboardModel(moshiInit)
        }
    }
}