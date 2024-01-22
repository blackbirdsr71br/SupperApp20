package com.alex.dashboarddemo.presentation.common.widgets

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alex.dashboarddemo.data.mockdata.GSDADemoDataProvider
import com.alex.dashboarddemo.presentation.common.components.GSDAProfilePicture
import com.alex.dashboarddemo.presentation.common.model.GSDAProfileSectionSize
import com.alex.dashboarddemo.ui.theme.GSDAProfileSectionSizes

@Composable
fun GSDAProfileSection(
    @DrawableRes firstImageId: Int,
    text: String,
    modifier: Modifier = Modifier,
    iconRight: @Composable () -> Unit = {},
    size: GSDAProfileSectionSize = GSDAProfileSectionSizes.small(),
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        GSDAProfilePicture(
            imageId = firstImageId,
            contentDescription = null,
            size = size.profileIconSize,
        )
        Text(
            text = text,
            style = size.textStyle,
            color = MaterialTheme.colors.onBackground,
            modifier = Modifier
                .weight(1f)
                .padding(start = 8.dp),
        )
        iconRight()
    }
}

@Preview
@Composable
fun GSDAProfileInfoPreview() {
    GSDAProfileSection(
        firstImageId = GSDADemoDataProvider.tweetList.first().authorImageId,
        text = GSDADemoDataProvider.tweetList.first().author,
        size = GSDAProfileSectionSizes.medium(),
        iconRight = { Icon(imageVector = Icons.Default.MoreVert, contentDescription = null) },
    )
}

@Preview
@Composable
fun GSDALikesSectionPreview() {
    val tweet = GSDADemoDataProvider.tweetList.first()
    GSDAProfileSection(
        firstImageId = tweet.authorImageId,
        text = "Liked by ${tweet.author} and ${tweet.likesCount} others",
    )
}
