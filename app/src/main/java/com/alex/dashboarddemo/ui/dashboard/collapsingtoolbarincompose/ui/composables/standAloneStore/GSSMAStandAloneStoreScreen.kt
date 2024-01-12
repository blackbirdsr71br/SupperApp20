package com.alex.dashboarddemo.ui.dashboard.collapsingtoolbarincompose.ui.composables.standAloneStore

import androidx.compose.animation.core.FloatExponentialDecaySpec
import androidx.compose.animation.core.animateDecay
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Velocity
import androidx.compose.ui.unit.dp
import com.alex.dashboarddemo.R
import com.alex.dashboarddemo.ui.dashboard.categories
import com.alex.dashboarddemo.ui.dashboard.collapsingtoolbarincompose.ui.composables.GSSMACategoriesList
import com.alex.dashboarddemo.ui.dashboard.collapsingtoolbarincompose.ui.composables.GSSMACategoriesStoreModel
import com.alex.dashboarddemo.ui.dashboard.collapsingtoolbarincompose.ui.management.states.toolbarHeader.CollapsingToolbar
import com.alex.dashboarddemo.ui.dashboard.collapsingtoolbarincompose.ui.management.states.toolbarHeader.GSSMACollapsinToolbarModel
import com.alex.dashboarddemo.ui.dashboard.collapsingtoolbarincompose.ui.management.states.toolbarHeader.ToolbarState
import com.alex.dashboarddemo.ui.dashboard.collapsingtoolbarincompose.ui.management.states.toolbarHeader.scrollflags.ExitUntilCollapsedState
import com.alex.dashboarddemo.ui.dashboard.standAloneStore
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.launch

private val minToolbarHeight = 70.dp
private val maxToolbarHeight = 220.dp

@Composable
private fun rememberToolbarState(toolbarHeightRange : IntRange) : ToolbarState {
    return rememberSaveable(saver = ExitUntilCollapsedState.Saver) {
        ExitUntilCollapsedState(toolbarHeightRange)
    }
}

@Preview(showBackground = true)
@Composable
fun StandAloneStorePreview() {

    GSSMAStandAloneStoreScreen(
        standAloneGrid = standAloneStore,
        standAloneCategories = categories,
        onBackButtonClicked = {},
        onSearchButtonClicked = {},
        onShoppingCartButtonClicked = {},
        modifier = Modifier.fillMaxSize(),
    )
}

@Composable
fun GSSMAStandAloneStoreScreen(
    modifier : Modifier = Modifier,
    backgroundImageResId : Any = R.drawable.shoesback,
    imgStoreLogo : Any = R.drawable.flexilogo,
    standAloneGrid : List<GSSMAStandAloneGridModel>,
    standAloneCategories : List<GSSMACategoriesStoreModel>,
    onBackButtonClicked : () -> Unit,
    onSearchButtonClicked : () -> Unit,
    onShoppingCartButtonClicked : () -> Unit,
) {

    val lazyState = rememberLazyListState()
    val toolbarHeightRange = with(LocalDensity.current) {
        minToolbarHeight.roundToPx()..maxToolbarHeight.roundToPx()
    }
    val toolbarState = rememberToolbarState(toolbarHeightRange)
    val listState = rememberLazyListState()

    val scope = rememberCoroutineScope()

    val nestedScrollConnection = remember {
        object : NestedScrollConnection {
            override fun onPreScroll(available : Offset, source : NestedScrollSource) : Offset {
                toolbarState.scrollTopLimitReached =
                    listState.firstVisibleItemIndex == 0 && listState.firstVisibleItemScrollOffset == 0
                toolbarState.scrollOffset = toolbarState.scrollOffset - available.y
                return Offset(0f, toolbarState.consumed)
            }

            override suspend fun onPostFling(consumed : Velocity, available : Velocity) : Velocity {
                if (available.y > 0) {
                    scope.launch {
                        animateDecay(
                            initialValue = toolbarState.height + toolbarState.offset,
                            initialVelocity = available.y,
                            animationSpec = FloatExponentialDecaySpec(),
                        ) { value, velocity ->
                            toolbarState.scrollTopLimitReached =
                                listState.firstVisibleItemIndex == 0 && listState.firstVisibleItemScrollOffset == 0
                            toolbarState.scrollOffset =
                                toolbarState.scrollOffset - (value - (toolbarState.height + toolbarState.offset))
                            if (toolbarState.scrollOffset == 0f) scope.coroutineContext.cancelChildren()
                        }
                    }
                }

                return super.onPostFling(consumed, available)
            }
        }
    }

    Box(
        modifier = modifier
        .nestedScroll(nestedScrollConnection),
    ) {
        Column(
            modifier = modifier.nestedScroll(nestedScrollConnection),
        ) {
            GSSMACollapsinToolbarModel(
                backgroundImageResId = backgroundImageResId,
                imgStoreLogo = imgStoreLogo,
                progress = toolbarState.progress,
                onBackButtonClicked = onBackButtonClicked,
                onSearchButtonClicked = onSearchButtonClicked,
                onShoppingCartButtonClicked = onShoppingCartButtonClicked,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(with(LocalDensity.current) { toolbarState.height.toDp() })
                    .graphicsLayer { translationY = toolbarState.offset },
            ).apply {
                CollapsingToolbar(this)
            }
            Spacer(modifier = Modifier.height(32.dp))

            GSSMAStandAloneGridView(standAloneGrid)
        }
    }
    Box(
        modifier = Modifier
            .height(250.dp)
            .fillMaxWidth(),
        contentAlignment = Alignment.BottomCenter,
    ) {
        GSSMACategoriesList(
            item = standAloneCategories,
        )
    }
}
