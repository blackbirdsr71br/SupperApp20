package com.alex.dashboarddemo.presentation.common.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alex.dashboarddemo.data.mockdata.GSDADemoDataProvider
import com.alex.dashboarddemo.ui.theme.GSDAProfileSizes
import com.alex.dashboarddemo.ui.theme.instagramGradient

@Composable
fun GSDAStoryItem(
    @DrawableRes profileImageId: Int,
    profileName: String,
    isMe: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = MaterialTheme.typography.caption,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    val borderColor = if (isMe) {
        SolidColor(Color.LightGray)
    } else {
        Brush.linearGradient(
            colors = instagramGradient,
            start = Offset(x = 0f, y = 0f),
            end = Offset(x = 100f, y = 100f),
        )
    }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        GSDAProfilePicture(
            imageId = profileImageId,
            contentDescription = null,
            size = GSDAProfileSizes.large,
            modifier = Modifier
                .border(
                    shape = CircleShape,
                    border = BorderStroke(width = 3.dp, brush = borderColor),
                )
                .clickable(
                    interactionSource = interactionSource,
                    indication = rememberRipple(bounded = false, radius = GSDAProfileSizes.large / 2),
                    enabled = true,
                    onClickLabel = null,
                    onClick = onClick,
                ),
        )
        Text(text = profileName, style = textStyle, textAlign = TextAlign.Center)
    }
}

@Preview
@Composable
fun GSDAStoryItemPreview() {
    GSDAStoryItem(
        profileImageId = GSDADemoDataProvider.tweet.authorImageId,
        profileName = GSDADemoDataProvider.tweet.author,
        isMe = false,
        onClick = {},
    )
}

@Preview
@Composable
fun GSDAStoryItemMePreview() {
    GSDAStoryItem(
        profileImageId = GSDADemoDataProvider.tweet.authorImageId,
        profileName = GSDADemoDataProvider.tweet.author,
        isMe = true,
        onClick = {},
    )
}
