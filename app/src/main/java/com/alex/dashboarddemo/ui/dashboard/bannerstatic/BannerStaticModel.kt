package com.example.gsdapaymentcarousel.bannerstatic

import androidx.compose.ui.layout.ContentScale
import com.alex.dashboarddemo.R

data class BannerStaticModel(
    val image: Int = R.drawable.bannerstatic1,
    val placeholder: Int?,
    val contentScale: ContentScale,
    val onClick: () -> Unit = {},
)
