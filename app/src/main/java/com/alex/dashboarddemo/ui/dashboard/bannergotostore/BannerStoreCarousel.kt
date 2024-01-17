package com.alex.dashboarddemo.ui.dashboard.bannergotostore

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alex.dashboarddemo.R

@Composable
fun BannerStoreCarousel(bannerStoreCarouselModel: BannerStoreCarouselModel) {
    with(bannerStoreCarouselModel) {
        Column(
            modifier = Modifier
                .wrapContentSize()
                .padding(8.dp),
            horizontalAlignment = Alignment.Start,
        ) {
            LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                items(bannerStoreList) { item ->
                    BannerStoreModel(
                        image = item.image,
                        contentScale = ContentScale.Crop,
                        placeholder = R.drawable.banner1,
                    ).apply {
                        BannerStore(bannerStoreModel = this)
                    }
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun CardSapp20CarouselPreview() {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(0.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start,
    ) {
        val cardList = mutableListOf<BannerStoreModel>()

        cardList.add(
            BannerStoreModel(
                image = R.drawable.banner1,
                contentScale = ContentScale.Crop,
                placeholder = R.drawable.banner1,
            ),
        )

        cardList.add(
            BannerStoreModel(
                image = R.drawable.banner2,
                contentScale = ContentScale.Crop,
                placeholder = R.drawable.banner2,
            ),
        )

        cardList.add(
            BannerStoreModel(
                image = R.drawable.banner3,
                contentScale = ContentScale.Crop,
                placeholder = R.drawable.banner3,
            ),
        )

        cardList.add(
            BannerStoreModel(
                image = R.drawable.banner1,
                contentScale = ContentScale.Crop,
                placeholder = R.drawable.banner1,
            ),
        )

        cardList.add(
            BannerStoreModel(
                image = R.drawable.banner2,
                contentScale = ContentScale.Crop,
                placeholder = R.drawable.banner2,
            ),
        )

        BannerStoreCarouselModel(
            bannerStoreList = cardList,
        ).apply {
            BannerStoreCarousel(bannerStoreCarouselModel = this)
        }
    }
}
