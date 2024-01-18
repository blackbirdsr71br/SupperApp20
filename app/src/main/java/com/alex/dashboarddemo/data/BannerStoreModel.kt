package com.alex.dashboarddemo.data

import androidx.compose.ui.layout.ContentScale

data class BannerStoreModel(
    val image: String? = null,
    val placeholder: String? = null,
    val contentScale: ContentScale,
    val onClick: () -> Unit = {},
)
