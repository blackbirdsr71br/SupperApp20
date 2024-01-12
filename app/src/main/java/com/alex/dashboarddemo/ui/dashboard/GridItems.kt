package com.alex.dashboarddemo.ui.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun <T> GridItems(
    data: List<T>,
    columnCount: Int,
    modifier: Modifier,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.Start,
    itemContent: @Composable BoxScope.(T) -> Unit,
) {
    val size = data.count()


    val rows = if (size == 0) 0 else 1 + (size - 1) / columnCount

    for (rowIndex in 0..rows) {
        Row(
            horizontalArrangement = horizontalArrangement,
            modifier = modifier.background(Color.Gray),
        ) {
            for (columnIndex in 0 until columnCount) {
                val itemIndex = rowIndex * columnCount + columnIndex
                val modifier1: Modifier = Modifier.weight(1F, fill = true)
                if (itemIndex < size) {
                    Box(
                        modifier = modifier1,
                        propagateMinConstraints = true,
                    ) {
                        itemContent(data[itemIndex])
                    }
                } else {
                    Spacer(Modifier.weight(1F, fill = true))
                }
            }
        }
    }
}