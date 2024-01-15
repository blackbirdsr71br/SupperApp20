package com.alex.dashboarddemo.presentation.dashboard.collapsingtoolbarincompose.ui.composables.standAloneStore

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
import com.alex.dashboarddemo.presentation.dashboard.gsvcCouponCard.BadgesPosition
import com.alex.dashboarddemo.presentation.dashboard.gsvcCouponCard.GSVCCouponCardModel
import com.alex.dashboarddemo.presentation.dashboard.gsvcProductCard.GSVCGenericProductCardBuilder
import com.alex.dashboarddemo.presentation.dashboard.gsvcProductCard.GSVCProductCard
import com.alex.dashboarddemo.presentation.dashboard.gsvcProductCard.ProductCardType
import com.alex.dashboarddemo.presentation.dashboard.standAloneStore
import com.alex.dashboarddemo.ui.theme.SDAColor
import com.baz.democouponcard.gsvcCouponCard.GSVCCouponCard


data class GSSMAStandAloneGridModel(
    val txttitle : String,
    val gssmaProductCardModel : List<GSVCGenericProductCardBuilder>,
)

@Composable
fun GSSMAStandAloneGridView(gssmaStandAloneStoreGridModel : List<GSSMAStandAloneGridModel>) {
    val lazyGState = rememberLazyGridState()
    val nestedScroll = rememberNestedScrollInteropConnection()
    Column {
        LazyColumn(
            modifier = Modifier.nestedScroll(nestedScroll),
        ) {
            item {
                for (aList in gssmaStandAloneStoreGridModel) {
                    // println("Elemento: ${aList.txt_title}")

                    Text(
                        modifier = Modifier.padding(
                            start = 10.dp,
                            bottom = if (aList.gssmaProductCardModel.size == 1) 8.dp else 0.dp,
                            top = 8.dp
                        ),
                        text = aList.txttitle,
                        fontSize = 18.sp,
                    )

                    LazyVerticalGrid(
                        columns = GridCells.Fixed(2),
                        state = lazyGState,
                        modifier = Modifier
                            .height((282 * (aList.gssmaProductCardModel.size / 2)).dp)
                            //.nestedScroll(nestedScroll),
                        ,horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        contentPadding = PaddingValues(8.dp),

                        ) {
                        aList.gssmaProductCardModel.forEachIndexed { _, data ->
                            // println("Elemento: $data")
                            item() {

                                val gsvcCouponCardModel = GSVCCouponCardModel(
                                    badgesStatusText = "Oferta",
                                    badgesBackgroundColor = Color(0xFF770202),
                                    backgroundContent = Color.LightGray,
                                    badgesPosition = BadgesPosition.LEFT,
                                    modifier = Modifier,
                                ) {
                                    GSVCProductCard(
                                        gsvcGenericProductCardBuilder = data,
                                        ProductCardType.SHOPPING_CENTER,
                                    )
                                }
                                GSVCCouponCard(gsvcCouponCardModel)

                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Button(
                            onClick = {},
                            shape = RoundedCornerShape(10.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = SDAColor.GSVCInteractions
                            )
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
fun StandAloneStoreGridPreview() {
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

                GSSMAStandAloneGridView(standAloneStore)
            }
        }
    }
}
