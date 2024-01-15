package com.alex.dashboarddemo.presentation.dashboard.gsdaPromoSlider

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alex.dashboarddemo.data.mockdata.DemoDataProvider
import com.alex.dashboarddemo.data.Item
import com.alex.dashboarddemo.presentation.dashboard.common.GSDAStoryPopup

@Composable
fun GSDASliderPromoCard(
    imageIds: List<Item>,
    gsdaInfoCardModel: List<GSDAPromoInfoCardModel>,
) {
    Card(
        modifier = Modifier
            .height(300.dp)
            .width(500.dp)
            .padding(start = 4.dp, top = 8.dp, bottom = 8.dp, end = 4.dp)
            .clip(shape = RoundedCornerShape(16.dp)),
        colors = CardDefaults.cardColors(
            containerColor = Color.Black,
        ),
    ) {
        Box(
            contentAlignment = Alignment.BottomCenter,
        ) {
            val index = GSDAStoryPopup(
                imageIds = imageIds,
            )
            GSDAPromoInfoCard(
                gsdaInfoModel = gsdaInfoCardModel,
                cardInfoIndex = index,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PromoCardPreview() {
    GSDASliderPromoCard(
        imageIds = DemoDataProvider.itemList.take(6),
        gsdaInfoCardModel = DemoDataProvider.gsdaInfoCardList,
    )
}
