package com.alex.dashboarddemo.presentation.common.model

import androidx.compose.ui.Modifier

data class GSDACAccountModel(
    val modifier: Modifier = Modifier,
    val titleText: String = "Tienes Dispponible",
    val balanceAmount: String = "1,000.00",
    val doubleDin: Boolean = false,
)
