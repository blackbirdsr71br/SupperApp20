package com.example.gsdapaymentcarousel.bannerstatic

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.alex.dashboarddemo.R
import com.alex.dashboarddemo.data.BannerStaticModel
import com.alex.dashboarddemo.data.GSDADataProvider
import com.alex.dashboarddemo.network.model.Dashboard
import com.alex.dashboarddemo.utils.getDrawableFromString

@Composable
fun BannerStatic(
    item: Dashboard.Item.SubItem? = null,
    bannerStaticModel: BannerStaticModel,
) {
    val mContext = LocalContext.current
    Card(
        modifier = Modifier
            .padding(start = 8.dp)
            .size(328.dp, 100.dp),
        shape = RoundedCornerShape(16.dp),
        backgroundColor = Color.Blue,
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxSize(),
            model = ImageRequest
                .Builder(mContext)
                .data(getDrawableFromString(mContext, item?.imageUrl ?: "ic_placeholder"))
                .error(R.drawable.ic_placeholder)
                .placeholder(R.drawable.ic_placeholder)
                .build(),
            contentDescription = "Image",
            contentScale = ContentScale.Crop,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewBannerStatic() {
    BannerStaticModel(
        image = "ic_bitcoin",
        contentScale = ContentScale.Crop,
        placeholder = "bannerstatic1",

    ).apply {
        BannerStatic(bannerStaticModel = this)
    }
}

@Composable
@Preview
fun GSDABannerStaticPreview() {
    BannerStatic(bannerStaticModel = GSDADataProvider.confDataBannerStatic)
}
