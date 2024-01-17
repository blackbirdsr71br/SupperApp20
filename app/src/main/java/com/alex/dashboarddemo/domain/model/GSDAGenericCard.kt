package com.alex.dashboarddemo.domain.model

import androidx.compose.ui.graphics.Color

data class GSDAGenericCard(
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
