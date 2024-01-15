package com.alex.dashboarddemo.presentation.dashboard.gsdaSliderImageCard

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alex.dashboarddemo.data.mockdata.DemoDataProvider
import com.alex.dashboarddemo.data.Item
import com.alex.dashboarddemo.presentation.dashboard.common.GSDAStoryPopup

@Composable
fun GSDASliderImageCard(
    imageIds: List<Item>,
) {
    Card(
        modifier = Modifier
            .height(200.dp)
            .padding(start = 16.dp, top = 8.dp, bottom = 8.dp, end = 16.dp)
            .clip(shape = RoundedCornerShape(16.dp)),
    ) {
        Column() {
            AnimatedVisibility(
                visible = true,
                enter = expandVertically() + fadeIn(),
                exit = shrinkVertically() + fadeOut(),
            ) {
                GSDAStoryPopup(
                    imageIds = imageIds,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SliderImagePreview(){

    GSDASliderImageCard(DemoDataProvider.itemList.take(6))
}