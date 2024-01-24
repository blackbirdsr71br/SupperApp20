package com.alex.dashboarddemo.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.DriveFileMove
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.rememberNestedScrollInteropConnection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alex.dashboarddemo.data.cache.preview.GSDAPreviewDataProvider.products
import com.alex.dashboarddemo.presentation.common.components.GSDAProductCard
import com.alex.dashboarddemo.presentation.common.model.GSDABadgesPosition
import com.alex.dashboarddemo.presentation.common.model.GSDACouponCardModel
import com.alex.dashboarddemo.presentation.common.model.GSDAGenericProductCardBuilder
import com.alex.dashboarddemo.presentation.common.widgets.GSDACouponCard
import com.alex.dashboarddemo.presentation.common.model.GSDAProductCardType
import com.alex.dashboarddemo.ui.theme.GSVCPrimary100
import com.alex.dashboarddemo.ui.theme.JetDeliveryTheme
import com.alex.dashboarddemo.ui.theme.SDAColor.GSVCCardsLightBG
import com.alex.dashboarddemo.ui.theme.SDATypography.GSVCH2
import com.alex.dashboarddemo.ui.theme.SDATypography.GSVCH4

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun GSDAProductGenericScreen(
    productList: List<GSDAGenericProductCardBuilder>,
    txtTitle: String,
    txtSubTitle: String? = null,
    iconFilter: ImageVector? = null,
    onBackClick: () -> Unit,
    onFilterClick: () -> Unit,
) {
    JetDeliveryTheme {
        Scaffold(
            topBar = {
                GSDAOfferTopBar(
                    txtTitle = txtTitle,
                    iconFilter = iconFilter,
                    onBackClick = { onBackClick.invoke() },
                    onFilterClick = { onFilterClick.invoke() },
                )
            },
            containerColor = GSVCCardsLightBG,
        ) {
            GSDAProductListGeneric(
                txtSubTitle = txtSubTitle,
                products = productList,
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun GSDAOfferTopBar(
    txtTitle: String = "Ofertas",
    iconFilter: ImageVector? = null,
    onBackClick: () -> Unit,
    onFilterClick: () -> Unit,
) {
    TopAppBar(
        navigationIcon = {
            IconButton(
                onClick = { onBackClick.invoke() },
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Ir hacia atrás",
                    tint = GSVCPrimary100,
                )
            }
        },
        actions = {
            if (iconFilter != null) {
                IconButton(
                    onClick = { onFilterClick.invoke() },
                ) {
                    Icon(
                        imageVector = iconFilter,
                        contentDescription = "Filtro",
                        tint = GSVCPrimary100,
                    )
                }
            }
        },
        title = {
            Text(
                text = txtTitle,
                style = GSVCH2,
                fontSize = 18.sp,
            )
        },
    )
}

@Composable
fun GSDAProductListGeneric(
    txtSubTitle: String? = null,
    products: List<GSDAGenericProductCardBuilder>,
) {
    val lazyGState = rememberLazyGridState()
    val nestedScroll = rememberNestedScrollInteropConnection()
    Column {
        Box(
            modifier = Modifier.padding(start = 12.dp, top = 100.dp, bottom = 8.dp),
        ) {
            if (txtSubTitle != null) {
                Text(
                    text = txtSubTitle,
                    style = GSVCH4,
                    fontSize = 24.sp,
                )
            }
        }

        LazyVerticalGrid(
            modifier = Modifier
                .height((165 * (products.size)).dp)
                .fillMaxWidth()
                .background(Color.Transparent)
                .nestedScroll(nestedScroll)
                .padding(start = 8.dp, top = 8.dp, bottom = 8.dp, end = 8.dp),
            state = lazyGState,
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            products.forEachIndexed { _, data ->
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
            item {
                Spacer(modifier = Modifier.height(50.dp))
            }
        }
    }
}

@Preview
@Composable
fun GSDAProductOfferPreview() {
    GSDAProductGenericScreen(
        productList = products,
        txtTitle = "Ofertas",
        onBackClick = {},
        onFilterClick = {},
    )
}

@Preview
@Composable
fun GSDAProductFlatsPreview() {
    GSDAProductGenericScreen(
        productList = products,
        txtTitle = "Flexi",
        txtSubTitle = "Flats",
        iconFilter = Icons.AutoMirrored.Filled.DriveFileMove,
        onBackClick = {},
        onFilterClick = {},
    )
}
