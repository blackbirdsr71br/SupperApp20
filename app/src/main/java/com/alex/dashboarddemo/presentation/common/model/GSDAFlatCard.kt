package com.alex.dashboarddemo.presentation.common.model

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import com.alex.dashboarddemo.ui.theme.GSVCBody3Text100Left

data class GSDAFlatCard(
    val featureMessage: String? = null,
    val image: Int,
    val message: String,
    val style: TextStyle = GSVCBody3Text100Left,
    val bgCardColor: Color = Color.White,
    val size: GSDAFlatCardType = GSDAFlatCardType.FLAT,
    val content: @Composable () -> Unit = {},
    val route: String? = null,
)
