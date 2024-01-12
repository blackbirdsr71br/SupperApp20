package com.alex.dashboarddemo.ui.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.alex.dashboarddemo.components.LoadImage
import com.alex.dashboarddemo.components.PrimaryText
import com.alex.dashboarddemo.components.SecondaryText
import com.alex.dashboarddemo.network.model.Dashboard

@Composable
fun ShowCategoryElement(item: Dashboard.Item.SubItem) {
    Column {
        Spacer(modifier = Modifier.height(5.dp)) // added to support space for header
        CategoryImage(item = item)
        Spacer(modifier = Modifier.height(5.dp))
        CategoryInfo(
            title = item.title,
            subTitle = item.subTitle,
        )
    }
}

@Composable
private fun CategoryImage(item: Dashboard.Item.SubItem) {
    val bgColor = item.meta?.bgColor?.let { color ->
        getColor(color)
    } ?: Color.Blue

    Box(
        modifier = Modifier
            .size(70.dp)
            .background(bgColor, shape = RoundedCornerShape(5.dp)),
        contentAlignment = Alignment.Center,
    ) {
        LoadImage(
            image = item.imageUrl,
            tint = Color.White,
        )
    }
}

@Composable
private fun CategoryInfo(title: String?, subTitle: String?) {
    title?.let {
        PrimaryText {
            Text(
                text = it,
                style = MaterialTheme.typography.subtitle2,
            )
        }
    }
    subTitle?.let {
        SecondaryText {
            Text(
                text = it,
                style = MaterialTheme.typography.overline,
            )
        }
    }
}

fun getColor(colorString: String): Color {
    return Color(android.graphics.Color.parseColor(colorString))
}
