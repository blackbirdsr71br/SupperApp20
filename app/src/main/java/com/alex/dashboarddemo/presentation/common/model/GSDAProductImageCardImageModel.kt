package com.alex.dashboarddemo.presentation.common.model

import androidx.compose.ui.graphics.Color
import com.alex.dashboarddemo.R
import com.alex.dashboarddemo.ui.theme.GSVCBase100

data class GSDAProductImageCardImageModel(
    val urlImage: Any,
    val imageResource: Int = R.drawable.baz_logo,
    val resourceTint: Color? = GSVCBase100,
    val cardBackground: Color = GSVCBase100,
    val urlImagePromo: String = "",
    val imagePromoVisible: Boolean = false,
)
