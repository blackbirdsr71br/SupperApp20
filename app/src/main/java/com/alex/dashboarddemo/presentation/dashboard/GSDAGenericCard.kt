package com.alex.dashboarddemo.presentation.dashboard

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import com.alex.dashboarddemo.data.GSDADataProvider.configData
import com.alex.dashboarddemo.data.GSDAGenericCardModel
import com.alex.dashboarddemo.domain.model.Dashboard
import com.alex.dashboarddemo.utils.getDrawableFromString

@Composable
fun GSDAGenericCard(
    item: Dashboard.Item.SubItem? = null,
    config : GSDAGenericCardModel,
) {
    val mContext = LocalContext.current
    Card(
        modifier = Modifier
            .width(250.dp)
            .height(320.dp),
        colors = if (config.backgroundColor != null) {
            CardDefaults.cardColors(containerColor = config.backgroundColor)
        } else {
            CardDefaults.cardColors(containerColor = Color.White)
        },
    ) {
        if (!config.text.isNullOrEmpty() && !config.textButton.isNullOrEmpty()) {
            GSDAContentCard(
                item = item,
                config = config)
        } else {
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
}

@Composable
@Preview
fun GSDAGenericCardPreview() {
    GSDAGenericCard(config = configData)
}
