@file:JvmName("GSDAContentGridCard")

package com.alex.dashboarddemo.presentation.common.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alex.dashboarddemo.data.mockdata.GSDADemoDataProvider.gridList1
import com.alex.dashboarddemo.mvi.GSDAHomeHelper
import com.alex.dashboarddemo.presentation.common.model.GSDAFlatCard
import com.alex.dashboarddemo.ui.theme.GSVCPurple

@Composable
fun GSDAContentGridCard(card: GSDAFlatCard) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .background(Color.Transparent)
            .height(128.dp)
            .fillMaxWidth(),

    ) {
        var routed: String? by remember {
            mutableStateOf(null)
        }

        LaunchedEffect(routed) {
            GSDAHomeHelper.setRoute(routed)
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(card.bgCardColor)
                .padding(start = 16.dp, bottom = 16.dp).clickable {
                    routed = card.route
                },
            verticalArrangement = Arrangement.Top,
        ) {
            Row(
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.Top,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(topEndPercent = 25, bottomStartPercent = 25)),

            ) {
                card.featureMessage?.let {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(topEndPercent = 25, bottomStartPercent = 25))
                            .background(GSVCPurple)
                            .width(56.dp)
                            .height(24.dp),
                        contentAlignment = Alignment.TopEnd,
                    ) {
                        Text(
                            it,
                            modifier = Modifier.padding(
                                bottom = 4.dp,
                                top = 4.dp,
                                end = 12.dp,
                                start = 12.dp,
                            ),
                            fontSize = 10.sp,
                        )
                    }
                }
            }
            if (card.featureMessage == null) {
                Spacer(modifier = Modifier.height(24.dp))
            }

            Column(
                modifier = Modifier.padding(start = 8.dp, end = 8.dp),
                verticalArrangement = Arrangement.SpaceBetween,
            ) {
                Image(
                    painter = painterResource(id = card.image),
                    contentDescription = "null",
                    modifier = Modifier.padding(bottom = 16.dp),

                )
                Row(
                    modifier = Modifier
                        .padding(end = 16.dp)
                        .height(106.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.Bottom,
                ) {
                    Text(card.message, style = card.style)
                }
            }
        }
    }
}

@Composable
@Preview
fun GSDAContentCardPreview() {
    GSDAContentGridCard(gridList1[1])
}