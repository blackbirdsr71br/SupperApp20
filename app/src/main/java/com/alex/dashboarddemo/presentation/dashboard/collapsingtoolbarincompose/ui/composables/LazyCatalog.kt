package com.alex.dashboarddemo.presentation.dashboard.collapsingtoolbarincompose.ui.composables

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.alex.dashboarddemo.presentation.dashboard.collapsingtoolbarincompose.AnimalListPreviewParameterProvider
import com.alex.dashboarddemo.presentation.dashboard.collapsingtoolbarincompose.ui.composables.standAloneStore.GSSMAStandAloneGridModel
import com.alex.dashboarddemo.presentation.dashboard.gsvcCouponCard.BadgesPosition
import com.alex.dashboarddemo.presentation.dashboard.gsvcCouponCard.GSVCCouponCardModel
import com.alex.dashboarddemo.presentation.dashboard.gsvcProductCard.GSVCProductCard
import com.alex.dashboarddemo.presentation.dashboard.gsvcProductCard.ProductCardType
import com.alex.dashboarddemo.presentation.dashboard.standAloneStore
import com.baz.democouponcard.gsvcCouponCard.GSVCCouponCard

import com.pencelab.collapsingtoolbarincompose.data.model.Animal

@Preview(showBackground = true)
@Composable
fun LazyCatalogPreview(
    @PreviewParameter(AnimalListPreviewParameterProvider::class) animals: List<Animal>,
) {
    LazyCatalog(
        animals = standAloneStore,
        columns = 2,
        modifier = Modifier.fillMaxSize(),
    )
}

@Composable
fun LazyCatalog(
    animals: List<GSSMAStandAloneGridModel>,
    columns: Int,
    modifier: Modifier = Modifier,
    listState: LazyListState = rememberLazyListState(),
    contentPadding: PaddingValues = PaddingValues(0.dp),
) {
    val chunkedList = remember(animals, columns) {
        animals.chunked(columns)
    }

    LazyColumn(
        state = listState,
        contentPadding = contentPadding,
        modifier = modifier.padding(top = 32.dp),
    ) {
        itemsIndexed(chunkedList) { index, data ->
            Column {


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
            ) {
                data.forEach { datos ->
                    val gsvcCouponCardModel = GSVCCouponCardModel(
                        badgesStatusText = "Oferta",
                        badgesBackgroundColor = Color(0xFF770202),
                        backgroundContent = Color.LightGray,
                        badgesPosition = BadgesPosition.LEFT,
                        modifier = Modifier,
                    ) {
                        GSVCProductCard(
                            gsvcGenericProductCardBuilder = datos.gssmaProductCardModel[index],
                            ProductCardType.SHOPPING_CENTER,
                        )
                    }
                    GSVCCouponCard(gsvcCouponCardModel)
                }


            }
        }
        }
    }
}
