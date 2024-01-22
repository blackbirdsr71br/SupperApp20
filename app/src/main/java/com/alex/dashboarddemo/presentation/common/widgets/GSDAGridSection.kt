package com.alex.dashboarddemo.presentation.common.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.rememberNestedScrollInteropConnection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alex.dashboarddemo.data.mockdata.gridDirectory
import com.alex.dashboarddemo.presentation.common.components.GSDACCAccounts
import com.alex.dashboarddemo.presentation.common.components.GSDADirectoryCard
import com.alex.dashboarddemo.presentation.common.model.GSDACAccountModel
import com.alex.dashboarddemo.presentation.common.model.GSDADirectoryGridModel

typealias ComposableFun = @Composable () -> Unit

@Composable
fun GSDAVerticalGridView(
    composableFuns: MutableList<ComposableFun>,
) {
    val lazyGState = rememberLazyStaggeredGridState()
    val nestedScroll = rememberNestedScrollInteropConnection()

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        LazyVerticalStaggeredGrid(
            modifier = Modifier
                .height((155 * (2)).dp)
                .fillMaxWidth()
                .background(Color.Transparent)
                .nestedScroll(nestedScroll),
            state = lazyGState,
            columns = StaggeredGridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(0.dp),
            verticalItemSpacing = 12.dp,
        ) {
            items(composableFuns) { content ->
                content()
            }
        }
    }
}

@Composable
fun GSDADirectoryGridView(gssmaDirectoryGridModel: List<GSDADirectoryGridModel>) {
    val lazyGState = rememberLazyGridState()
    val nestedScroll = rememberNestedScrollInteropConnection()
    Column {
        for (aList in gssmaDirectoryGridModel) {
            // println("Elemento: ${aList.txt_title}")

            Text(
                modifier = Modifier.padding(
                    start = 10.dp,
                    bottom = if (aList.directoryCards.size == 1) 6.dp else 0.dp,
                ),
                text = aList.txtTitle,
                fontSize = 18.sp,
            )

            LazyVerticalGrid(
                columns = object : GridCells {
                    override fun Density.calculateCrossAxisCellSizes(
                        availableSize: Int,
                        spacing: Int,
                    ): List<Int> {
                        val firstColumn = (availableSize - spacing) / 2
                        val secondColumn = availableSize - spacing - firstColumn
                        return listOf(firstColumn, secondColumn)
                    }
                },
                state = lazyGState,
                modifier = Modifier
                    .nestedScroll(nestedScroll)
                    .height(
                        if (aList.directoryCards.size % 2 == 0) {
                            (95 * (aList.directoryCards.size / 2)).dp
                        } else {
                            if (aList.directoryCards.size == 1) {
                                (93 * (aList.directoryCards.size)).dp
                            } else {
                                (65 * (aList.directoryCards.size)).dp
                            }
                        },
                    ),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(8.dp),

            ) {
                aList.directoryCards.forEachIndexed { index, data ->
                    // println("Elemento: $data")
                    if (aList.directoryCards.size % 2 == 0) {
                        item(span = { GridItemSpan(1) }) {
                            Column {
                                GSDADirectoryCard(data)
                            }
                        }
                    } else {
                        if (index % 3 == 0) {
                            item(span = { GridItemSpan(maxLineSpan) }) {
                                Column {
                                    GSDADirectoryCard(data)
                                }
                            }
                        } else {
                            item(span = { GridItemSpan(1) }) {
                                Column {
                                    GSDADirectoryCard(data)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun GSDAGridPreview() {
    val componente: ComposableFun = { }
    val composableFuns = mutableListOf(componente)

    composableFuns.add {
        GSDACAccountModel(
            doubleDin = true,
        ).apply {
            GSDACCAccounts(
                this,
            )
        }
    }
    composableFuns.add {
        GSDACAccountModel(
            doubleDin = false,
        ).apply {
            GSDACCAccounts(
                this,
            )
        }
    }

    composableFuns.add {
        GSDACAccountModel(
            doubleDin = false,
        ).apply {
            GSDACCAccounts(
                this,
            )
        }
    }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        GSDAVerticalGridView(composableFuns)
    }
}

@Preview(showBackground = true)
@Composable
fun GSDADirectoryGridPreview() {
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
                GSDADirectoryGridView(gridDirectory)
            }
        }
    }
}
