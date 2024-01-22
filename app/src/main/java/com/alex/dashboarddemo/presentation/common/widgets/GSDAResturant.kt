package com.alex.dashboarddemo.presentation.common.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.dp
import com.alex.dashboarddemo.R
import com.alex.dashboarddemo.domain.model.GSDADashboard
import com.alex.dashboarddemo.presentation.common.components.GSDALoadImage
import com.alex.dashboarddemo.presentation.common.components.GSDAPrimaryText
import com.alex.dashboarddemo.presentation.common.components.GSDASecondaryText
import com.alex.dashboarddemo.ui.theme.themeTypography

@Composable
fun GSDAShowRestaurantElement(item: GSDADashboard.GSDAItem.GSDASubItem) {
    Row(modifier = Modifier.padding(dimensionResource(id = R.dimen.padding))) {
        GSDARestaurantImage(url = item.imageUrl)
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = dimensionResource(id = R.dimen.padding))
                .align(Alignment.CenterVertically),
        ) {
            GSDARestaurantInfo(item = item)
        }
    }
}

@Composable
private fun GSDARestaurantImage(url: String) {
    GSDALoadImage(
        modifier = Modifier
            .size(70.dp)
            .clip(RoundedCornerShape(5.dp)),
        image = url,
    )
}

@Composable
private fun GSDARestaurantInfo(item: GSDADashboard.GSDAItem.GSDASubItem) {
    val title = item.title ?: "Name"
    val subTitle = item.subTitle ?: "Caption"
    val rating = "${item.meta?.rating}"
    val reviewCount = "${item.meta?.reviewCount}"

    GSDAPrimaryText {
        Text(
            text = title,
            style = themeTypography.subtitle1,
        )
    }

    GSDASecondaryText {
        Text(
            text = subTitle,
            style = themeTypography.caption,
        )
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            modifier = Modifier.size(16.dp),
            contentDescription = "",
            painter = painterResource(id = R.drawable.ic_round_star_24),
            tint = Color(0xFFF5CE47),
        )

        Spacer(modifier = Modifier.width(4.dp))

        Text(
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterVertically),
            text = buildAnnotatedString {
                append(rating)
                pushStyle(SpanStyle(color = Color.Gray))
                append(" ( $reviewCount reviews)")
                pop()
            },
            style = MaterialTheme.typography.caption,
        )

        Text(
            modifier = Modifier
                .background(MaterialTheme.colors.primary, RoundedCornerShape(100.dp))
                .padding(horizontal = 5.dp, vertical = 2.dp),
            text = stringResource(id = R.string.free_delivery),
            color = Color.White,
            style = MaterialTheme.typography.overline,
        )
    }
}
