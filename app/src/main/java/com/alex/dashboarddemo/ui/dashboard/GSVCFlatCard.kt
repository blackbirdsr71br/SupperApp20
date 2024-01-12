package com.alex.dashboarddemo.ui.dashboard

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import com.alex.dashboarddemo.ui.theme.GSVCBody3Text100Left

data class GSVCFlatCard(
    val featureMessage: String? = null,
    val image: Int,
    val message: String,
    val style: TextStyle = GSVCBody3Text100Left,
    val BgCardColor: Color = Color.White,
    val size: GSVCFlatCardType = GSVCFlatCardType.FLAT,
    val content: @Composable () -> Unit = {},
    val route: String? = null
)
enum class GSVCFlatCardType {
    FLAT, COMPOSABLE
}
