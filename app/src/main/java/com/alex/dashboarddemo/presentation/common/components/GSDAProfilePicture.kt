package com.alex.dashboarddemo.presentation.common.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.alex.dashboarddemo.data.mockdata.GSDADemoDataProvider
import com.alex.dashboarddemo.ui.theme.GSDAProfileSizes

@Composable
fun GSDAProfilePicture(
    @DrawableRes imageId: Int,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    size: Dp = GSDAProfileSizes.medium,
) {
    Image(
        painter = painterResource(id = imageId),
        modifier = modifier
            .size(size)
            .clip(CircleShape),
        contentDescription = contentDescription,
        contentScale = ContentScale.Crop,
    )
}

@Preview
@Composable
fun GSDAProfilePicturePreview() {
    Column {
        GSDAProfilePicture(
            imageId = GSDADemoDataProvider.tweetList.first().authorImageId,
            contentDescription = "Profile picture",
            size = GSDAProfileSizes.small,
        )
        GSDAProfilePicture(
            imageId = GSDADemoDataProvider.tweetList.first().authorImageId,
            contentDescription = "Profile picture",
            size = GSDAProfileSizes.medium,
        )
    }
}
