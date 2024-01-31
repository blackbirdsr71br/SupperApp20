package com.alex.dashboarddemo.domain.model

import com.alex.dashboarddemo.utils.GSDAConstants.KEY_EXPLORE

sealed class GSDAMockDataFromKey(
    val value: String,
    val route: String,
) {
    object GSDAExplore : GSDAMockDataFromKey(KEY_EXPLORE, "com/alex/dashboarddemo/data/cache/mockdata/GSDAExploreData.kt")

    object GSDADirectory : GSDAMockDataFromKey(KEY_EXPLORE, "com.alex.dashboarddemo.data.cache.mockdata.com.alex.dashboarddemo.data.cache.mockdata.GSDAExploreData.kt")

    object GSDABenefits : GSDAMockDataFromKey(KEY_EXPLORE, "com.alex.dashboarddemo.data.cache.mockdata.com.alex.dashboarddemo.data.cache.mockdata.GSDAExploreData.kt")

    object GSDAProfile : GSDAMockDataFromKey(KEY_EXPLORE, "com.alex.dashboarddemo.data.cache.mockdata.com.alex.dashboarddemo.data.cache.mockdata.GSDAExploreData.kt")

    object GSDACommonUI : GSDAMockDataFromKey(KEY_EXPLORE, "com.alex.dashboarddemo.data.cache.mockdata.com.alex.dashboarddemo.data.cache.mockdata.GSDAExploreData.kt")
}
