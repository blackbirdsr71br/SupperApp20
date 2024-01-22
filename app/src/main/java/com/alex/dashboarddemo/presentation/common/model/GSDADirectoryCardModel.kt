package com.alex.dashboarddemo.presentation.common.model

import androidx.compose.ui.graphics.Color

data class GSDADirectoryCardModel(
    val imgUrl: String,
    val colorBackground: Color = Color.White,
    val onCardClick: (() -> Unit)? = null,
)
