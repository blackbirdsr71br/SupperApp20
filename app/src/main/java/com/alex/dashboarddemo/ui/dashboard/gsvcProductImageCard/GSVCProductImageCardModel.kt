package com.alex.dashboarddemo.ui.dashboard.gsvcProductImageCard

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import com.alex.dashboarddemo.R
import com.alex.dashboarddemo.ui.theme.GSVCBase100

data class GSVCProductImageCardImageModel(
    val urlImage: Any,
    val imageResource: Int = R.drawable.baz_logo,
    val resourceTint: Color? = GSVCBase100,
    val cardBackground: Color = GSVCBase100,
    val urlImagePromo: String = "",
    val imagePromoVisible: Boolean = false,
)

data class GSVCProductImageCardPriceModel(
    val amountDiscount: Int = 1000,
    val hasDiscount: Boolean = true,
    val lineaCredito: String? = "Hola",
    val availableCredit: Boolean = true,
    val regularPrice: String = "5999",
    val finalPrice: String = "4999",
)

data class GSVCProductImageCardPaymentModel(
    val percentDiscount: Int = 0,
    val weeklyPayment: String = "",
    val regularPrice: String = "",
    val bazTexto: AnnotatedString = texto,
)

data class GSVCProductImageCardModel(
    val gsvcProductImageCardImageModel: GSVCProductImageCardImageModel? = null,
    val gsvcProductImageCardPaymentModel: GSVCProductImageCardPaymentModel? = null,
    val gsvcProductImageCardPriceModel: GSVCProductImageCardPriceModel? = null,
    val promoText: String = "Envío Gratis",
    val promoAdicText: String = "baz crédito",
    val img_Url : Any = R.drawable.baz_logo,
    val txt_Maker: String = "Fabricante",
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
