package com.alex.dashboarddemo.presentation.dashboard

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
import com.alex.dashboarddemo.presentation.components.LoadImage

data class GSSMADirectoryCardModel(
    val img_imgUrl: String,
    val color_Background: Color = Color.White,
    val onCardClick: (() -> Unit)? = null,
)

@Composable
fun GSSMADirectoryCard(gssmaDirectoryCardModel: GSSMADirectoryCardModel) {
    with(gssmaDirectoryCardModel) {
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
                    .background(color_Background)
                    .fillMaxSize(),
                contentAlignment = Alignment.Center,
            ) {
                LoadImage(
                    image = img_imgUrl,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CardPreview() {
    GSSMADirectoryCardModel(
        img_imgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Tiendas/directorio/mosaico/largo/bancoazteca.png",
        color_Background = Color(0xFF154205),
    ).apply {
        GSSMADirectoryCard(this)
    }
}

@Preview(showBackground = true)
@Composable
fun CardPreview1() {
    GSSMADirectoryCardModel(
        img_imgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Tiendas/directorio/mosaico/medio/elektra.png",
        color_Background = Color(0xFFFFEB3B),
    ).apply {
        GSSMADirectoryCard(this)
    }
}
