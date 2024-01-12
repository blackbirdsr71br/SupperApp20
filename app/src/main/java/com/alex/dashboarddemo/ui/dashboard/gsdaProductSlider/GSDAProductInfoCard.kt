package com.alex.dashboarddemo.ui.dashboard.gsdaProductSlider

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alex.dashboarddemo.data.DemoDataProvider
import com.alex.dashboarddemo.mvi.HomeHelper
import com.alex.dashboarddemo.ui.dashboard.badges.gsvcBadgeStatus.GSDAInformativeChip
import com.alex.dashboarddemo.ui.dashboard.badges.gsvcBadgeStatus.GSDAInformativeChipModel
import com.alex.dashboarddemo.ui.theme.GSVCBase100
import com.alex.dashboarddemo.ui.theme.GSVCSecondary100
import com.alex.dashboarddemo.ui.theme.h5

data class GSDAProductInfoCardModel(
    val chipInfo: String = "",
    val chipBackground: Color = GSVCSecondary100,
    val chipTextColor: Color = GSVCBase100,
    val productDescription: String,
    val weekPayment: String,
    val aditionalInfo: String,
)

@Composable
fun GSDAProductInfoCard(
    gsdaInfoModel: List<GSDAProductInfoCardModel>,
    cardInfoIndex: Int,
) {
    var routed: String? by remember {
        mutableStateOf(null)
    }

    LaunchedEffect(routed) {
        HomeHelper.setRoute(routed)
    }

    with(gsdaInfoModel[cardInfoIndex]) {
        Card(
            modifier = Modifier
                .height(180.dp)
                .width(400.dp)
                .padding(start = 8.dp, top = 16.dp, bottom = 8.dp, end = 8.dp)
                .clip(shape = RoundedCornerShape(16.dp))
                .alpha(85f)
                .clickable(enabled = true) {
                    routed = productDescription
                },
            colors = CardDefaults.cardColors(
                containerColor = Color.White.copy(alpha = 0.85f),
            ),
        ) {
            Column(
                modifier = Modifier
                    .padding(start = 0.dp, top = 0.dp, bottom = 8.dp, end = 8.dp)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Box() {
                    GSDAInformativeChipModel(
                        badgesStatusText = chipInfo,
                        badgesTextColor = chipTextColor,
                        backgroundBadgesStatus = chipBackground,
                        textStyleBadgeStatus = h5,
                        roundedCornerShape = RoundedCornerShape(16.dp, 0.dp, 12.dp, 0.dp),
                    ).apply { GSDAInformativeChip(this) }
                }
                Box(
                    modifier = Modifier
                        .padding(start = 16.dp, top = 8.dp, end = 16.dp, bottom = 4.dp),
                ) {
                    Column() {
                        Text(
                            text = productDescription,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            maxLines = 2,
                        )
                        Text(
                            text = weekPayment,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                        )
                        Text(
                            text = aditionalInfo,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
fun ProductInfoCardPreview() {
    GSDAProductInfoCard(
        gsdaInfoModel = DemoDataProvider.gsdaProductInfoCardList,
        cardInfoIndex = 0,
    )
}
