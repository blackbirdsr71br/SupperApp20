package com.alex.dashboarddemo.presentation.dashboard

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.yield

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GSDAImageCarousell() {
    val pagerState =
        rememberPagerState(
            pageCount = { Int.MAX_VALUE },
            initialPage = Int.MAX_VALUE / 3
        )
    LaunchedEffect(Unit) {
        while (true) {
            yield()
            delay(5000)
            pagerState.animateScrollToPage(
                page = (pagerState.currentPage + 1) % (pagerState.pageCount)
            )
        }
    }
    Box(
        modifier =
        Modifier
            .fillMaxWidth()
            .height(250.dp)
    ) {
        HorizontalPager(
            modifier = Modifier.align(Alignment.Center),
            state = pagerState
        ) { page ->
            Card(
                modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(10.dp, 10.dp, 10.dp, 10.dp),
                shape = RoundedCornerShape(10.dp)
            ) {
                val newKids = kidsList[page % kidsList.size]
                Box(
                    modifier =
                    Modifier
                        .fillMaxSize()
                        .background(Color.LightGray)
                        .align(Alignment.Center)
                ) {
                    Image(
                        painter =
                        painterResource(
                            id = newKids.imgUri
                        ),
                        contentDescription = "Image",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ) {
            Card(
                modifier =
                Modifier
                    .height(57.dp)
                    .padding(16.dp),
                shape = RoundedCornerShape(8.dp),
                backgroundColor = Color.White.copy(alpha = .50f)
            ) {
                Row(
                    modifier =
                    Modifier
                        .background(Color.White.copy(alpha = .50f))
                        .padding(4.dp)
                        .clip(shape = RoundedCornerShape(10.dp))
                ) {
                    repeat(kidsList.size) {
                        CustomIndicators(selected = pagerState.currentPage % kidsList.size == it)
                    }
                }
            }
        }
    }
}

@Composable
fun CustomIndicators(selected: Boolean) {
    Box(
        modifier =
        Modifier
            .padding(4.dp)
            .background(color = if (selected) Color.Black else Color.White, shape = CircleShape)
            .height(8.dp)
            .width(width = if (!selected) 8.dp else 18.dp)
    )
}

@Preview
@Composable
private fun Test() {
    GSDAImageCarousell()
}
