package com.alex.dashboarddemo.ui.dashboard.bannergotostore

import androidx.compose.ui.layout.ContentScale
import com.alex.dashboarddemo.R

data class BannerStoreModel(
    val image: Int = R.drawable.banner2,
    val placeholder: Int?,
    val contentScale: ContentScale,
    val onClick: () -> Unit = {},
)
