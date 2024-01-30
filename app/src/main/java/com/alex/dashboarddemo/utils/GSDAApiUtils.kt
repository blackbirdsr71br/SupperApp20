package com.alex.dashboarddemo.utils

import com.alex.dashboarddemo.data.cache.mockdata.GSDAExploreData.json
import com.alex.dashboarddemo.domain.model.GSDADashboard
import com.alex.dashboarddemo.domain.model.GSDAMockDataFromKey.*
import com.squareup.moshi.Moshi

fun getInitialRefreshData(
    lastUpdate: Long,
    cacheTimeout: Int = 1,
): Boolean {
    val currentTime = System.currentTimeMillis()
    val diffInMinutes = (currentTime - lastUpdate) / 1000 / 60

    return (diffInMinutes >= cacheTimeout)
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
        GSDAExplore.value -> {
            json.toDashboardModel(moshiInit)
        }

        else -> {
            json.toDashboardModel(moshiInit)
        }
    }
}
