package com.alex.dashboarddemo.presentation.common.components.builder

import androidx.compose.foundation.background
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
import com.alex.dashboarddemo.data.cache.preview.GSDAPreviewDataProvider.configData
import com.alex.dashboarddemo.data.cache.preview.GSDAPreviewDataProvider.gridList1
import com.alex.dashboarddemo.domain.model.GSDADashboard
import com.alex.dashboarddemo.domain.model.GSDASubItemViewType
import com.alex.dashboarddemo.presentation.common.components.GSDACategoriesElement
import com.alex.dashboarddemo.presentation.common.components.GSDAContentGridCard
import com.alex.dashboarddemo.presentation.common.components.GSDAGenericCard
import com.alex.dashboarddemo.presentation.common.components.GSDAImageCarousel
import com.alex.dashboarddemo.presentation.common.components.GSDAShowVerticalDivider
import com.alex.dashboarddemo.presentation.common.components.GSDAStaticBanner
import com.alex.dashboarddemo.presentation.common.components.GSDAStoreBanner
import com.alex.dashboarddemo.presentation.common.widgets.GSDAShowHeader
import com.alex.dashboarddemo.presentation.common.widgets.GSDAShowRestaurantElement

@Composable
fun GSDAShowHorizontalElements(item: GSDADashboard.GSDAItem) {
    item.header?.let {
        it.title?.let { it1 ->
            GSDAShowHeader(
                title = it1,
                hasMore = it.hasMore,
                subtitle = it.subtitle
            )
        }
    }
    LazyRow(
        modifier = Modifier.fillMaxWidth()
    ) {
        itemsIndexed(item.data) { index, data ->
            when (data.viewType) {
                GSDASubItemViewType.CategoriesElement -> GSDACategoriesElement(
                    item = data
                )

                GSDASubItemViewType.BannersElement -> GSDAGenericCard(
                    item = data,
                    config = configData
                )

                GSDASubItemViewType.StoreBanner -> GSDAStoreBanner(
                    item = data
                )

                else -> {
                    // do nothing
                }
            }
            if (index != item.data.size) Spacer(modifier = Modifier.width(10.dp))
        }
    }
}

@Composable
fun GSDAShowVerticalElements(item: GSDADashboard.GSDAItem) {
    item.header?.let {
        it.title?.let { it1 ->
            GSDAShowHeader(
                title = it1,
                hasMore = it.hasMore,
                subtitle = it.subtitle
            )
        }
    }
    item.data.forEachIndexed { index, data ->
        when (data.viewType) {
            GSDASubItemViewType.RestaurantElement -> GSDAShowRestaurantElement(
                item = data
            )
            GSDASubItemViewType.ImageCarousell -> GSDAImageCarousel()
            GSDASubItemViewType.StaticBanner -> GSDAStaticBanner(item = data)

            else -> {
                // do nothing
            }
        }
        if (index != item.data.size) GSDAShowVerticalDivider()
    }
}

@Composable
fun GSDAShowVerticalGrid(item: GSDADashboard.GSDAItem) {
    val lazyGState = rememberLazyGridState()
    val nestedScroll = rememberNestedScrollInteropConnection()
    LazyVerticalGrid(
        modifier = Modifier.height((75 * (item.data.size + 1)).dp)
            .background(Color.Gray)
            .nestedScroll(nestedScroll)
            .semantics { contentDescription = "" },
        state = lazyGState,
        columns = GridCells.Fixed(2)
    ) {
        items(item.data.size) { index ->
            GSDAContentGridCard(gridList1[index])
        }
    }
}

@Composable
fun GSDAShowGridElements(item: GSDADashboard.GSDAItem) {
    item.header?.let {
        it.title?.let { it1 ->
            GSDAShowHeader(
                title = it1,
                hasMore = it.hasMore,
                subtitle = it.subtitle
            )
        }
    }
    item.data.forEachIndexed { index, data ->
        when (data.viewType) {
            GSDASubItemViewType.RestaurantElement -> GSDAShowRestaurantElement(
                item = data
            )

            else -> {
                // do nothing
            }
        }
        if (index != item.data.size) GSDAShowVerticalDivider()
    }
}
