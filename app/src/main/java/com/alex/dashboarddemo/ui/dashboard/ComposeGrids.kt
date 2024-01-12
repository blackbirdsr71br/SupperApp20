package com.alex.dashboarddemo.ui.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp
import com.alex.dashboarddemo.R

@Composable
fun MyCardList() {
    val cardData = remember { generateFakeCards() }

    LazyVerticalGrid(
        modifier = Modifier.height((cardData.size*20).dp),
        columns = object : GridCells {
            override fun Density.calculateCrossAxisCellSizes(
                availableSize: Int,
                spacing: Int,
            ): List<Int> {
                val firstColumn = (availableSize - spacing) * 2 / 3
                val secondColumn = availableSize - spacing - firstColumn
                return listOf(firstColumn, secondColumn)
            }
        },
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(24.dp),
    ) {
        cardData.forEachIndexed { index, card ->
            if (index == 0) {
                item(span = { GridItemSpan(maxLineSpan) }) {
                    MyCard(
                        title = card.first,
                        subtitle = card.second,
                    )
                }
            } else {
                item(span = { GridItemSpan(1) }) {
                    MyCard(
                        title = card.first,
                        subtitle = card.second,
                    )
                }
            }
        }
    }
}

@Composable
fun MyCard(
    title: String,
    subtitle: String,
) {
    Card(
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .height(180.dp)
            .width(140.dp),
    ) {
        Image(
            painter = painterResource(id = R.drawable.food1),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
        )
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(
                    top = 48.dp,
                    bottom = 16.dp,
                ),
        ) {
            Text(
                text = title,
                color = Color.White,
                style = MaterialTheme.typography.h6,
                textAlign = TextAlign.Center,
            )
            Text(
                text = subtitle,
                color = Color.White,
                style = MaterialTheme.typography.subtitle1,
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyCardPreview() {
    MyCard(
        title = "my title",
        subtitle = "my subtitle",
    )
}

private fun generateFakeCards(): List<Pair<String, String>> {
    return MutableList(20) { index ->
        val cardNumber = index + 1
        "Title $cardNumber" to "Subtitle $cardNumber"
    }
}
