package com.alex.dashboarddemo.presentation.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alex.dashboarddemo.domain.model.GSDADashboard
import com.alex.dashboarddemo.domain.model.DashboardAction
import com.alex.dashboarddemo.domain.model.SubItemViewType
import com.alex.dashboarddemo.presentation.components.LoadImage

@Composable
fun CategoriesElement(item: GSDADashboard.Item.SubItem) {
    Box(
        modifier = Modifier
            .size(96.dp)
            .padding(0.dp)
            .clip(shape = RoundedCornerShape(5.dp)),
        contentAlignment = Alignment.Center,
        propagateMinConstraints = true,
    ) {
        Column(
            modifier = Modifier
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            BannerImage(url = item.imageUrl)
            Spacer(modifier = Modifier.height(4.dp))
            item.title?.let {
                BannerText(
                    Modifier,
                    title = it,
                )
            }
        }
    }
}

@Composable
private fun BannerImage(url: String) {
    LoadImage(
        modifier = Modifier
            .width(70.dp)
            .height(70.dp),
        image = url,
    )
}

@Composable
private fun BannerText(
    modifier: Modifier,
    title: String,
) {
    Text(
        modifier = modifier
            .padding(start = 4.dp, end = 4.dp)
            .fillMaxWidth()
            .background(Color.Transparent),
        text = title,
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.subtitle2.copy(
            color = Color.Black,
            fontSize = 14.sp,
        ),

    )
}

@Preview(showBackground = true)
@Composable
fun PreviewBanner() {
    val dash = DashboardAction(
        type = "",
        value = "",
    )
    val meta = GSDADashboard.Item.SubItem.Meta(
        bgColor = "Color.White",
        rating = "",
        reviewCount = "",
        hasFreeDelivery = false,
    )
    val item = GSDADashboard.Item.SubItem(
        viewType = SubItemViewType.CategoriesElement,
        action = dash,
        imageUrl = "R.drawable.lavadora",
        meta = meta,
        subTitle = "",
        title = "Ropa",
    )
    CategoriesElement(item)
}
