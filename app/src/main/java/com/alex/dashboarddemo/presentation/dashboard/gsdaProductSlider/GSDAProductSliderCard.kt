package com.alex.dashboarddemo.presentation.dashboard.gsdaProductSlider

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alex.dashboarddemo.data.mockdata.DemoDataProvider
import com.alex.dashboarddemo.domain.model.GSDAItem
import com.alex.dashboarddemo.presentation.dashboard.common.GSDAStoryPopup

@Composable
fun GSDASliderProductCard(
    imageIds: List<GSDAItem>,
    gsdaInfoCardModel: List<GSDAProductInfoCardModel>,
) {
    var index = 0
    Card(
        modifier = Modifier
            .height(540.dp)
            .width(450.dp)
            .padding(start = 4.dp, top = 4.dp, bottom = 4.dp, end = 4.dp)
            .clip(shape = RoundedCornerShape(16.dp)),
        colors = CardDefaults.cardColors(
            containerColor = Color.LightGray,
        ),
    ) {
        Column(
            modifier = Modifier
                .padding(top = 4.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(340.dp)
                    .padding(8.dp)
                    .clip(shape = RoundedCornerShape(16.dp)),
                contentAlignment = Alignment.BottomCenter,
            ) {
                index = GSDAStoryPopup(
                    imageIds = imageIds,
                    contentScale = ContentScale.Fit,
                    colorSlider = Color.LightGray,
                )
            }
            Box() {
                GSDAProductInfoCard(
                    gsdaInfoModel = gsdaInfoCardModel,
                    cardInfoIndex = index,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductCardPreview() {
    GSDASliderProductCard(
        imageIds = DemoDataProvider.ProductList.take(6),
        gsdaInfoCardModel = DemoDataProvider.gsdaProductInfoCardList,
    )
}
