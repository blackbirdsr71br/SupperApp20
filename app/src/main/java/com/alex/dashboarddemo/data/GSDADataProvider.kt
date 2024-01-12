package com.alex.dashboarddemo.data

import androidx.compose.ui.graphics.Color


object GSDADataProvider {
    val configData = GSDAGenericCardModel(
        image = "ic_bitcoin",
        backgroundColor = Color(0xFF0C0623),
        title = "Wallet Bitcoin",
        text = "Compra y vende con la red de pago Lightning",
        textButton = "Conocer más",
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
