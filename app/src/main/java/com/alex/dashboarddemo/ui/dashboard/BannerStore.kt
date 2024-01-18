package com.alex.dashboarddemo.ui.dashboard

import androidx.compose.foundation.layout.fillMaxSize
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
import com.alex.dashboarddemo.data.BannerStoreModel
import com.alex.dashboarddemo.data.GSDADataProvider
import com.alex.dashboarddemo.network.model.Dashboard
import com.alex.dashboarddemo.utils.getDrawableFromString

@Composable
fun BannerStore(
    item: Dashboard.Item.SubItem? = null,
    bannerStoreModel: BannerStoreModel,
) {
    val mContext = LocalContext.current
    Card(
        modifier = Modifier
            .size(320.dp, 176.dp),
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
fun PreviewBannerStore() {
    BannerStoreModel(
        image = "banner3",
        contentScale = ContentScale.Crop,
        placeholder = "banner3",

    ).apply {
        BannerStore(bannerStoreModel = this)
    }
}

@Composable
@Preview
fun GSDABannerStorePreview() {
    BannerStore(bannerStoreModel = GSDADataProvider.conDataBannerStore)
}
