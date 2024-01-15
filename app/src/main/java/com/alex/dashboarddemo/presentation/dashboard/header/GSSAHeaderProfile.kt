package com.alex.dashboarddemo.presentation.dashboard.header

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alex.dashboarddemo.R

@Composable
fun GSSAHeaderProfile(
    headerModel: GSDAHeaderModel,
) {
    Box {
        Image(
            painter = painterResource(id = headerModel.urlProfile),
            contentDescription = "profile",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
                .shadow(elevation = 10.dp),
        )
        if (headerModel.rewardsIndicator) {
            Box(
                modifier = Modifier
                    .size(48.dp),
            ) {
                Column {
                    Box(
                        modifier = Modifier
                            .width(48.dp)
                            .height(48.dp),
                        contentAlignment = Alignment.BottomEnd,
                    ) {
                        Image(
                            modifier = Modifier.size(15.dp),
                            painter = painterResource(headerModel.urlRewards),
                            contentDescription = "gema",
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileRewardsPreview() {
    val headerModelPreview = GSDAHeaderModel(
        name = "Andrea",
        points = "200",
        rewardsIndicator = true,
        notificationsIndicator = true,
        urlProfile = R.drawable.personperfil,
        urlRewards = R.drawable.ic_gema,
    )
    GSSAHeaderProfile(headerModelPreview)
}

@Preview(showBackground = true)
@Composable
fun ProfileRewardsFalsePreview() {
    val headerModelPreview = GSDAHeaderModel(
        name = "Andrea",
        points = "200",
        rewardsIndicator = false,
        notificationsIndicator = true,
        urlProfile = R.drawable.personperfil,
        urlRewards = R.drawable.ic_gema,
    )
    GSSAHeaderProfile(headerModelPreview)
}
