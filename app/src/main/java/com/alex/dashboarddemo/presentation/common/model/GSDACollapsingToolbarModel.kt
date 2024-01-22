package com.alex.dashboarddemo.presentation.common.model

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

data class GSDACollapsingToolbarModel(
    val backgroundImageResId: Any,
    val imgStoreLogo: Any,
    val progress: Float,
    val onBackButtonClicked: () -> Unit,
    val onSearchButtonClicked: () -> Unit,
    val onShoppingCartButtonClicked: () -> Unit,
    val modifier: Modifier = Modifier,
    val tint: Color? = null,
)
