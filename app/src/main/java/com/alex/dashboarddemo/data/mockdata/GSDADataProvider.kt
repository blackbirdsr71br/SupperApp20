package com.alex.dashboarddemo.data.mockdata

import androidx.compose.ui.graphics.Color
import com.alex.dashboarddemo.domain.model.GSDAGenericCard

object GSDADataProvider {
    val configData = GSDAGenericCard(
        image = "ic_bitcoin",
        backgroundColor = Color(0xFF0C0623),
        title = "Wallet Bitcoin",
        text = "Compra y vende con la red de pago Lightning",
        textButton = "Conocer más",
    )

    val configData2 = GSDAGenericCard(
        image = "ic_bet365",
        backgroundColor = Color(0xFF126E51),
        title = "bet365",
        text = "Los partidos más grandes, todos en un mismo lugar!",
        textButton = "Conocer más",
    )

    val configImgComplete = GSDAGenericCard(
        image = "ic_bitcoin_complete",
    )

    val configImgComplete2 = GSDAGenericCard(
        image = "ic_bet365_complete",
    )
}
