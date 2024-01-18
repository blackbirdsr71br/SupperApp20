package com.alex.dashboarddemo.presentation.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import com.alex.dashboarddemo.domain.model.GSDADashboard
import com.alex.dashboarddemo.utils.getDrawableFromString

@Composable
fun GSDAStaticBanner(
    item: GSDADashboard.Item.SubItem? = null
) {
    val mContext = LocalContext.current
    Card(
        modifier = Modifier
            .padding(start = 0.dp)
            .height(100.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        backgroundColor = Color.Blue
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxSize(),
            model = ImageRequest
                .Builder(mContext)
                .data(getDrawableFromString(mContext, item?.imageUrl ?: "staticbanner1"))
                .error(R.drawable.ic_placeholder)
                .placeholder(R.drawable.staticbanner1)
                .build(),
            contentDescription = "Image",
            contentScale = ContentScale.Crop
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewBannerStatic() {
    GSDAStaticBanner()
}

@Composable
@Preview
fun GSDABannerStaticPreview() {
    GSDAStaticBanner()
}
