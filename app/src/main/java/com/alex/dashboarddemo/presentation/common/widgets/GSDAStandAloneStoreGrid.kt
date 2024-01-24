package com.alex.dashboarddemo.presentation.common.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.rememberNestedScrollInteropConnection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alex.dashboarddemo.data.cache.preview.GSDAPreviewDataProvider.standAloneStore
import com.alex.dashboarddemo.presentation.common.model.GSDABadgesPosition
import com.alex.dashboarddemo.presentation.common.model.GSDACouponCardModel
import com.alex.dashboarddemo.presentation.common.components.GSDAProductCard
import com.alex.dashboarddemo.presentation.common.model.GSDAProductCardType
import com.alex.dashboarddemo.presentation.common.model.GSDAStandAloneGridModel
import com.alex.dashboarddemo.ui.theme.SDAColor

@Composable
fun GSDAStandAloneGridView(gssmaStandAloneStoreGridModel: List<GSDAStandAloneGridModel>) {
    val lazyGState = rememberLazyGridState()
    val nestedScroll = rememberNestedScrollInteropConnection()
    Column {
        LazyColumn(
            modifier = Modifier.nestedScroll(nestedScroll),
        ) {
            item {
                for (aList in gssmaStandAloneStoreGridModel) {
                    Text(
                        modifier = Modifier.padding(
                            start = 10.dp,
                            bottom = if (aList.productCards.size == 1) 8.dp else 0.dp,
                            top = 8.dp,
                        ),
                        text = aList.txtTitle,
                        fontSize = 18.sp,
                    )

                    LazyVerticalGrid(
                        columns = GridCells.Fixed(2),
                        state = lazyGState,
                        modifier = Modifier
                            .height((282 * (aList.productCards.size / 2)).dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        contentPadding = PaddingValues(8.dp),

                    ) {
                        aList.productCards.forEachIndexed { _, data ->
                            item {
                                val gsvcCouponCardModel = GSDACouponCardModel(
                                    badgesStatusText = "Oferta",
                                    badgesBackgroundColor = Color(0xFF770202),
                                    backgroundContent = Color.LightGray,
                                    badgesPosition = GSDABadgesPosition.LEFT,
                                    modifier = Modifier,
                                ) {
                                    GSDAProductCard(
                                        gsvcGenericProductCardBuilder = data,
                                        GSDAProductCardType.SHOPPING_CENTER,
                                    )
                                }
                                GSDACouponCard(gsvcCouponCardModel)
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center,
                    ) {
                        Button(
                            onClick = {},
                            shape = RoundedCornerShape(10.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = SDAColor.GSVCInteractions,
                            ),
                        ) {
                            Text(text = "Mostrar Todos")
                        }
                    }
                }
            }
            item {
                Spacer(modifier = Modifier.height(50.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GSDAStandAloneStoreGridPreview() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFDD6D6D6),
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp),
            ) {
                GSDAStandAloneGridView(standAloneStore)
            }
        }
    }
}
