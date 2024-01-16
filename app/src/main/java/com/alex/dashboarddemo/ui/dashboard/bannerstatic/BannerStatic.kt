package com.example.gsdapaymentcarousel.bannerstatic

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
fun BannerStatic(bannerStaticModel: BannerStaticModel) {
    Card(
        modifier = Modifier
            .size(328.dp, 100.dp),
        shape = RoundedCornerShape(16.dp),
        backgroundColor = Color.Blue,
    ) {
        GlideImage(
            imageModel = bannerStaticModel.image,
            contentScale = bannerStaticModel.contentScale,
            modifier = Modifier
                .fillMaxWidth(),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewBannerStatic() {
    BannerStaticModel(
        image = R.drawable.bannerstatic1,
        contentScale = ContentScale.Crop,
        placeholder = R.drawable.bannerstatic1,

    ).apply {
        BannerStatic(bannerStaticModel = this)
    }
}
