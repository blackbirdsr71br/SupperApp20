package com.alex.dashboarddemo.presentation.common.components.collapsingtoolbarincompose.ui.composables

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
import com.alex.dashboarddemo.data.mockdata.GSDAAnimalListProvider
import com.alex.dashboarddemo.data.mockdata.standAloneStore
import com.alex.dashboarddemo.presentation.common.components.GSDAProductCard
import com.alex.dashboarddemo.presentation.common.model.GSDAAnimal
import com.alex.dashboarddemo.presentation.common.model.GSDABadgesPosition
import com.alex.dashboarddemo.presentation.common.model.GSDAProductCardType
import com.alex.dashboarddemo.presentation.common.model.GSDAStandAloneGridModel
import com.alex.dashboarddemo.presentation.common.model.GSVCCouponCardModel
import com.alex.dashboarddemo.presentation.common.widgets.GSDACouponCard

@Preview(showBackground = true)
@Composable
fun GSDALazyCatalogPreview(
    @PreviewParameter(GSDAAnimalListProvider::class) animals: List<GSDAAnimal>,
) {
    GSDALazyCatalog(
        animals = standAloneStore,
        columns = 2,
        modifier = Modifier.fillMaxSize(),
    )
}

@Composable
fun GSDALazyCatalog(
    animals: List<GSDAStandAloneGridModel>,
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
                            badgesPosition = GSDABadgesPosition.LEFT,
                            modifier = Modifier,
                        ) {
                            GSDAProductCard(
                                gsvcGenericProductCardBuilder = datos.productCards[index],
                                GSDAProductCardType.SHOPPING_CENTER,
                            )
                        }
                        GSDACouponCard(gsvcCouponCardModel)
                    }
                }
            }
        }
    }
}
