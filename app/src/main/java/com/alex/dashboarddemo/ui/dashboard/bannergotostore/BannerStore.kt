package com.alex.dashboarddemo.ui.dashboard.bannergotostore

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alex.dashboarddemo.R
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun BannerStore(bannerStoreModel: BannerStoreModel) {
    Card(
        modifier = Modifier
            .size(320.dp, 176.dp),
        shape = RoundedCornerShape(16.dp),
        backgroundColor = Color.Blue,
    ) {
        GlideImage(
            imageModel = bannerStoreModel.image,
            contentScale = bannerStoreModel.contentScale,
            modifier = Modifier
                .fillMaxWidth(),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewBannerStore() {
    BannerStoreModel(
        image = R.drawable.banner3,
        contentScale = ContentScale.Crop,
        placeholder = R.drawable.banner1,

    ).apply {
        BannerStore(bannerStoreModel = this)
    }
}
