package com.alex.dashboarddemo.presentation.common.model

data class GSDAProductImageCardPriceModel(
    val amountDiscount: Int = 1000,
    val hasDiscount: Boolean = true,
    val lineaCredito: String? = "Hola",
    val availableCredit: Boolean = true,
    val regularPrice: String = "5999",
    val finalPrice: String = "4999",
)