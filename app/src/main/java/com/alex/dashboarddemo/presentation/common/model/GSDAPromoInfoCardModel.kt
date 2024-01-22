package com.alex.dashboarddemo.presentation.common.model

import androidx.compose.ui.graphics.Color
import com.alex.dashboarddemo.ui.theme.GSVCBase100
import com.alex.dashboarddemo.ui.theme.GSVCSecondary100

data class GSDAPromoInfoCardModel(
    val chipInfo: String = "",
    val chipBackground: Color = GSVCSecondary100,
    val chipTextColor: Color = GSVCBase100,
    val titleInfo: String,
    val subtitleInfo: String,
    val buttonText: String,
    val onButtonClick: () -> Unit,
)
