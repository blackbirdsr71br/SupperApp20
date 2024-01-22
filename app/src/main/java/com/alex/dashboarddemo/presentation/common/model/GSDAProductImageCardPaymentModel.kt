package com.alex.dashboarddemo.presentation.common.model

import androidx.compose.ui.text.AnnotatedString
import com.alex.dashboarddemo.presentation.common.components.gsdaProductImageCard.mText

data class GSDAProductImageCardPaymentModel(
    val percentDiscount: Int = 0,
    val weeklyPayment: String = "",
    val regularPrice: String = "",
    val bazText: AnnotatedString = mText,
)