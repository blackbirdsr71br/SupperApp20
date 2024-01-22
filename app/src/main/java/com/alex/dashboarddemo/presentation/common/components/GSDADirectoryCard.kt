package com.alex.dashboarddemo.presentation.common.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alex.dashboarddemo.presentation.common.model.GSDADirectoryCardModel

@Composable
fun GSDADirectoryCard(directoryCard: GSDADirectoryCardModel) {
    with(directoryCard) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .clickable { onCardClick?.invoke() },
            colors = CardDefaults.cardColors(),
            shape = RoundedCornerShape(10.dp),
        ) {
            Box(
                modifier = Modifier
                    .background(colorBackground)
                    .fillMaxSize(),
                contentAlignment = Alignment.Center,
            ) {
                GSDALoadImage(
                    image = imgUrl,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GSDACardPreview() {
    GSDADirectoryCardModel(
        imgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Tiendas/directorio/mosaico/largo/bancoazteca.png",
        colorBackground = Color(0xFF154205),
    ).apply {
        GSDADirectoryCard(this)
    }
}

@Preview(showBackground = true)
@Composable
fun GSDACardPreview1() {
    GSDADirectoryCardModel(
        imgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Tiendas/directorio/mosaico/medio/elektra.png",
        colorBackground = Color(0xFFFFEB3B),
    ).apply {
        GSDADirectoryCard(this)
    }
}
