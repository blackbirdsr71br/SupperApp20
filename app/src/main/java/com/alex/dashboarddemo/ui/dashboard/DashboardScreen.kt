@file:Suppress("ktlint:standard:no-wildcard-imports")

package com.alex.dashboarddemo.ui.dashboard

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.rememberNestedScrollInteropConnection
import androidx.compose.ui.unit.dp
import com.alex.dashboarddemo.network.model.Dashboard
import com.alex.dashboarddemo.network.model.ItemViewType
import com.alex.dashboarddemo.shimmer.LocalShimmerTheme
import com.alex.dashboarddemo.shimmer.ShimmerBounds
import com.alex.dashboarddemo.shimmer.defaultShimmerTheme
import com.alex.dashboarddemo.shimmer.rememberShimmer

@Composable
fun ShowDashboard(data: List<Dashboard.Item>) {
    val lazyState = rememberLazyListState()
    val lazySGState = rememberLazyStaggeredGridState()
    val lazyGState = rememberLazyGridState()
    val nestedScroll = rememberNestedScrollInteropConnection()

    LazyColumn(
        modifier =
        Modifier
            .padding(8.dp)
            .fillMaxSize()
            .nestedScroll(nestedScroll),
        state = lazyState,
        contentPadding = PaddingValues(vertical = 8.dp)
    ) {
        itemsIndexed(items = data) { index, item ->
            when (item.viewType) {
                ItemViewType.HorizontalScroll -> ShowHorizontalElements(
                    item = item,
                )

                ItemViewType.VerticalScroll -> ShowVerticalElements(
                    item = item,
                )

                else -> {}
            }
            if (index != item.data.size) Spacer(modifier = Modifier.height(10.dp))
            Spacer(modifier = Modifier.height(12.dp))
        }
    }
    Spacer(modifier = Modifier.height(24.dp))
}
