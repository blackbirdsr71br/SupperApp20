package com.alex.dashboarddemo.presentation.common.widgets

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.rememberNestedScrollInteropConnection
import androidx.compose.ui.unit.dp
import com.alex.dashboarddemo.domain.model.GSDAItemViewType
import com.alex.dashboarddemo.mvi.GSDAHomeContract
import com.alex.dashboarddemo.presentation.common.components.builder.GSDAShowHorizontalElements
import com.alex.dashboarddemo.presentation.common.components.builder.GSDAShowVerticalElements

@Composable
fun GetStateScreen(
    state: GSDAHomeContract.DashBoardState,
    uiLoading: @Composable () -> Unit = {},
    uiError: @Composable () -> Unit = {},
    effect: (Unit) -> Unit = {},
) {
    val lazyState = rememberLazyListState()
    val nestedScroll = rememberNestedScrollInteropConnection()

    when (state.getInfo) {
        GSDAHomeContract.DashBoardApiState.Idle -> {
            uiLoading.invoke()
        }

        is GSDAHomeContract.DashBoardApiState.OnSuccess -> {
            if (state.getInfo.items?.data != null) {
                LazyColumn(
                    modifier =
                    Modifier
                        .fillMaxSize()
                        .nestedScroll(nestedScroll),
                    state = lazyState,
                    contentPadding = PaddingValues(vertical = 8.dp, horizontal = 12.dp),
                ) {
                    itemsIndexed(items = state.getInfo.items.data) { index, item ->
                        when (item.viewType) {
                            GSDAItemViewType.HorizontalScroll -> GSDAShowHorizontalElements(
                                item = item,
                            )

                            GSDAItemViewType.VerticalScroll -> GSDAShowVerticalElements(
                                item = item,
                            )

                            else -> {}
                        }
                        if (index != item.data.size) Spacer(modifier = Modifier.height(10.dp))
                        Spacer(modifier = Modifier.height(12.dp))
                    }
                    item {
                        Spacer(modifier = Modifier.height(50.dp))
                    }
                }
            }
        }

        is GSDAHomeContract.DashBoardApiState.OnNavigate -> {
            uiError.invoke()
        }

        else -> {}
    }
}
