package com.alex.dashboarddemo.presentation.common.components.header

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alex.dashboarddemo.R
import com.alex.dashboarddemo.presentation.common.model.GSDAHeaderModel

@Composable
fun GSDAHeaderNotification(
    headerModel: GSDAHeaderModel,
) {
    Box(
        modifier = Modifier
            .width(30.dp)
            .height(30.dp),
    ) {
        Image(
            painter = painterResource(headerModel.urlNotification),
            contentDescription = "iconos",
        )
        if (headerModel.notificationsIndicator) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.TopEnd,
            ) {
                Box(
                    modifier = Modifier
                        .width(12.dp)
                        .height(12.dp)
                        .clip(CircleShape)
                        .background(Color.White),
                ) {
                    Box(
                        modifier = Modifier
                            .width(10.dp)
                            .height(10.dp)
                            .clip(CircleShape)
                            .background(Color.Red)
                            .align(Alignment.Center),
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GSDAIconsPreview() {
    val headerModelPreview = GSDAHeaderModel(
        name = "Andrea",
        points = "200",
        rewardsIndicator = true,
        notificationsIndicator = true,
        urlProfile = R.drawable.baz_logo,
        urlNotification = R.drawable.baseline_notifications_24,
        urlRewards = R.drawable.ic_gema,
    )
    GSDAHeaderNotification(headerModelPreview)
}

@Preview(showBackground = true)
@Composable
fun GSDAIconsFalsePreview() {
    val headerModelPreview = GSDAHeaderModel(
        name = "Andrea",
        points = "200",
        rewardsIndicator = true,
        notificationsIndicator = false,
        urlProfile = R.drawable.baz_logo,
        urlNotification = R.drawable.baseline_notifications_24,
        urlRewards = R.drawable.ic_gema,
    )
    GSDAHeaderNotification(headerModelPreview)
}
