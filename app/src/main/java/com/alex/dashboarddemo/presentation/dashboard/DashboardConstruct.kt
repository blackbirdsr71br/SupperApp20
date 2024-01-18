package com.alex.dashboarddemo.presentation.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.rememberNestedScrollInteropConnection
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.alex.dashboarddemo.presentation.components.ShowVerticalDivider
import com.alex.dashboarddemo.data.mockdata.DemoDataProvider
import com.alex.dashboarddemo.data.mockdata.DemoDataProvider.gridlist1
import com.alex.dashboarddemo.data.mockdata.GSDADataProvider
import com.alex.dashboarddemo.domain.model.GSDADashboard
import com.alex.dashboarddemo.domain.model.SubItemViewType
import com.alex.dashboarddemo.presentation.dashboard.gsdaProductSlider.GSDASliderProductCard
import com.alex.dashboarddemo.presentation.dashboard.gsdaPromoSlider.GSDASliderPromoCard
import com.example.basedemomaterial3.ui.theme.SDASpace

@Composable
fun ShowHorizontalElements(item: GSDADashboard.Item) {
    item.header?.let {
        it.title?.let { it1 ->
            ShowHeader(
                title = it1,
                hasMore = it.hasMore,
                subtitle = it.subtitle,
            )
        }
    }
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        //contentPadding = PaddingValues(horizontal =  SDASpace.GSVCSmall),
    ) {
        itemsIndexed(item.data) { index, data ->
            when (data.viewType) {
                SubItemViewType.CategoriesElement -> CategoriesElement(
                    item = data,
                )

                SubItemViewType.BannersElement ->  GSDAGenericCard(
                    item = data,
                    config = GSDADataProvider.configData)

                else -> {
                    // do nothing
                }
            }
            if (index != item.data.size) Spacer(modifier = Modifier.width(8.dp))
        }
    }
}

@Composable
fun ShowVerticalElements(item: GSDADashboard.Item) {
    item.header?.let {
        it.title?.let { it1 ->
            ShowHeader(
                title = it1,
                hasMore = it.hasMore,
                subtitle = it.subtitle,
            )
        }
    }
    item.data.forEachIndexed { index, data ->
        when (data.viewType) {
            SubItemViewType.RestaurantElement -> ShowRestaurantElement(
                item = data,
            )

            SubItemViewType.SlidePromoCard -> GSDASliderPromoCard(
                imageIds = DemoDataProvider.GSDAItemModelLists.take(6),
                gsdaInfoCardModel = DemoDataProvider.gsdaInfoCardList,
            )

            SubItemViewType.ImageCarousell -> GSDAImageCarousell()

            else -> {
                // do nothing
            }
        }
        if (index != item.data.size) ShowVerticalDivider()
    }
}

@Composable
fun ShowVerticalGrid(item: GSDADashboard.Item) {
    val lazyGState = rememberLazyGridState()
    val nestedScroll = rememberNestedScrollInteropConnection()
    LazyVerticalGrid(
        modifier = Modifier.height((75 * (item.data.size + 1)).dp)
            .background(Color.Gray)
            .nestedScroll(nestedScroll)
            .semantics { contentDescription = "" },
        state = lazyGState,
        columns = GridCells.Fixed(2),
    ) {
        items(item.data.size) { index ->
            GSVCContentCard(gridlist1[index])
        }
    }
}

@Composable
fun ShowGridElements(item: GSDADashboard.Item) {
    item.header?.let {
        it.title?.let { it1 ->
            ShowHeader(
                title = it1,
                hasMore = it.hasMore,
                subtitle = it.subtitle,
            )
        }
    }
    item.data.forEachIndexed { index, data ->
        when (data.viewType) {
            SubItemViewType.RestaurantElement -> ShowRestaurantElement(
                item = data,
            )

            SubItemViewType.SlidePromoCard -> GSDASliderPromoCard(
                imageIds = DemoDataProvider.GSDAItemModelLists.take(6),
                gsdaInfoCardModel = DemoDataProvider.gsdaInfoCardList,
            )

            else -> {
                // do nothing
            }
        }
        if (index != item.data.size) ShowVerticalDivider()
    }
}
