package com.alex.dashboarddemo.data

import androidx.compose.ui.graphics.Color
import com.alex.dashboarddemo.network.model.Dashboard

data class GSDAGenericCardModel(
    val image: String? = null,
    val backgroundColor: Color? = null,
    val title: String? = null,
    val titleColor: Color? = null,
    val text: String? = null,
    val textColor: Color? = null,
    val textButton: String? = null,
    val textButtonColor: Color? = null,
    val iconTextBtn: String? = null,
    val tintIconTextColor: Color? = null,
)
