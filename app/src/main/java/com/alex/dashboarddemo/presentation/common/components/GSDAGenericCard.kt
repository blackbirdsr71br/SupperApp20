package com.alex.dashboarddemo.presentation.common.components

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
import com.alex.dashboarddemo.data.mockdata.GSDADataProvider.configData
import com.alex.dashboarddemo.domain.model.GSDADashboard
import com.alex.dashboarddemo.domain.model.GSDAGenericCard
import com.alex.dashboarddemo.utils.getDrawableFromString

@Composable
fun GSDAGenericCard(
    item: GSDADashboard.GSDAItem.GSDASubItem? = null,
    config: GSDAGenericCard,
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
            GSDAContentGridCard(
                item = item,
                config = config,
            )
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
