package com.alex.dashboarddemo.presentation.common.model

import androidx.compose.ui.graphics.Color
import com.alex.dashboarddemo.ui.theme.GSVCBase100
import com.alex.dashboarddemo.ui.theme.GSVCSecondary100

data class GSDAProductInfoCardModel(
    val chipInfo: String = "",
    val chipBackground: Color = GSVCSecondary100,
    val chipTextColor: Color = GSVCBase100,
    val productDescription: String,
    val weekPayment: String,
    val additionalInfo: String,
)
