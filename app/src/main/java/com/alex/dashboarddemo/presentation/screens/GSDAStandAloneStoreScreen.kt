package com.alex.dashboarddemo.presentation.screens

import androidx.compose.animation.core.FloatExponentialDecaySpec
import androidx.compose.animation.core.animateDecay
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import com.alex.dashboarddemo.data.mockdata.categories
import com.alex.dashboarddemo.data.mockdata.standAloneStore
import com.alex.dashboarddemo.presentation.common.components.collapsingtoolbarincompose.ui.composables.GSDACategoriesList
import com.alex.dashboarddemo.presentation.common.components.collapsingtoolbarincompose.ui.management.states.toolbarHeader.GSDACollapsingToolbar
import com.alex.dashboarddemo.presentation.common.components.collapsingtoolbarincompose.ui.management.states.toolbarHeader.scrollflags.GSDAExitUntilCollapsedState
import com.alex.dashboarddemo.presentation.common.model.GSDACategoriesStoreModel
import com.alex.dashboarddemo.presentation.common.model.GSDACollapsingToolbarModel
import com.alex.dashboarddemo.presentation.common.model.GSDAStandAloneGridModel
import com.alex.dashboarddemo.presentation.common.model.state.GSDAToolbarState
import com.alex.dashboarddemo.presentation.common.widgets.GSDAStandAloneGridView
import com.alex.dashboarddemo.ui.theme.maxToolbarHeight
import com.alex.dashboarddemo.ui.theme.minToolbarHeight
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.launch

@Composable
fun GSDAStandAloneStoreScreen(
    modifier: Modifier = Modifier,
    backgroundImageResId: Any = R.drawable.shoesback,
    imgStoreLogo: Any = R.drawable.flexilogo,
    standAloneGrid: List<GSDAStandAloneGridModel>,
    standAloneCategories: List<GSDACategoriesStoreModel>,
    onBackButtonClicked: () -> Unit,
    onSearchButtonClicked: () -> Unit,
    onShoppingCartButtonClicked: () -> Unit,
) {
    val toolbarHeightRange = with(LocalDensity.current) {
        minToolbarHeight.roundToPx()..maxToolbarHeight.roundToPx()
    }
    val toolbarState = rememberToolbarState(toolbarHeightRange)
    val listState = rememberLazyListState()
    val scope = rememberCoroutineScope()
    val nestedScrollConnection = remember {
        object : NestedScrollConnection {
            override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
                toolbarState.scrollTopLimitReached =
                    listState.firstVisibleItemIndex == 0 && listState.firstVisibleItemScrollOffset == 0
                toolbarState.scrollOffset = toolbarState.scrollOffset - available.y
                return Offset(0f, toolbarState.consumed)
            }

            override suspend fun onPostFling(consumed: Velocity, available: Velocity): Velocity {
                if (available.y > 0) {
                    scope.launch {
                        animateDecay(
                            initialValue = toolbarState.height + toolbarState.offset,
                            initialVelocity = available.y,
                            animationSpec = FloatExponentialDecaySpec(),
                        ) { value, _ ->
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
            GSDACollapsingToolbarModel(
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
                GSDACollapsingToolbar(this)
            }
            Spacer(modifier = Modifier.height(32.dp))

            GSDAStandAloneGridView(standAloneGrid)
        }
    }
    Box(
        modifier = Modifier
            .height(250.dp)
            .fillMaxWidth(),
        contentAlignment = Alignment.BottomCenter,
    ) {
        GSDACategoriesList(
            item = standAloneCategories,
        )
    }
}

@Composable
private fun rememberToolbarState(toolbarHeightRange: IntRange): GSDAToolbarState {
    return rememberSaveable(saver = GSDAExitUntilCollapsedState.Saver) {
        GSDAExitUntilCollapsedState(toolbarHeightRange)
    }
}

@Preview(showBackground = true)
@Composable
fun GSDAStandAloneStorePreview() {
    GSDAStandAloneStoreScreen(
        standAloneGrid = standAloneStore,
        standAloneCategories = categories,
        onBackButtonClicked = {},
        onSearchButtonClicked = {},
        onShoppingCartButtonClicked = {},
        modifier = Modifier.fillMaxSize(),
    )
}
