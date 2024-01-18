package com.alex.dashboarddemo.data

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale

object GSDADataProvider {
    val configData = GSDAGenericCardModel(
        image = "ic_bitcoin",
        backgroundColor = Color(0xFF0C0623),
        title = "Wallet Bitcoin",
        text = "Compra y vende con la red de pago Lightning",
        textButton = "Conocer más",
    )

    val confDataBannerStatic = BannerStaticModel(
        image = "ic_bitcoin",
        contentScale = ContentScale.Crop,
        placeholder = "ic_bitcoin",

    )

    val conDataBannerStore = BannerStoreModel(
        image = "banner2",
        contentScale = ContentScale.Crop,
        placeholder = "banner1",

    )

    val configData2 = GSDAGenericCardModel(
        image = "ic_bet365",
        backgroundColor = Color(0xFF126E51),
        title = "bet365",
        text = "Los partidos más grandes, todos en un mismo lugar!",
        textButton = "Conocer más",
    )

    val configImgComplete = GSDAGenericCardModel(
        image = "ic_bitcoin_complete",
    )

    val configImgComplete2 = GSDAGenericCardModel(
        image = "ic_bet365_complete",
    )
}
