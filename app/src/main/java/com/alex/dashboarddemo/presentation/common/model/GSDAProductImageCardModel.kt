package com.alex.dashboarddemo.presentation.common.model

import com.alex.dashboarddemo.R

data class GSDAProductImageCardModel(
    val gsvcProductImageCardImageModel: GSDAProductImageCardImageModel? = null,
    val gsvcProductImageCardPaymentModel: GSDAProductImageCardPaymentModel? = null,
    val gsvcProductImageCardPriceModel: GSDAProductImageCardPriceModel? = null,
    val promoText: String = "Envío Gratis",
    val promoAddictText: String = "baz crédito",
    val imgUrl: Any = R.drawable.baz_logo,
    val txtMaker: String = "Fabricante",
    val productDescription: String = "",
    val onCardClick: (() -> Unit)? = null,
    val freeShip: Boolean = false,
    val shipAmount: Int = 0,
    val type: Type = Type.Products,
) {
    sealed class Type {
        object Products : Type()
        object Store : Type()
    }
}
