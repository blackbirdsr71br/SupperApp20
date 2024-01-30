package com.alex.dashboarddemo.presentation.common.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.alex.dashboarddemo.R
import com.alex.dashboarddemo.domain.model.GSDADashboard
import com.alex.dashboarddemo.domain.model.GSDAGenericCard
import com.alex.dashboarddemo.ui.theme.GSDASpace
import com.alex.dashboarddemo.utils.getDrawableFromString

@Composable
fun GSDAContentGridCard(
    item: GSDADashboard.GSDAItem.GSDASubItem? = null,
    config: GSDAGenericCard,
) {
    val mContext = LocalContext.current
    Column {
        AsyncImage(
            modifier = Modifier
                .weight(0.6F)
                .padding(bottom = GSDASpace.GSVCSmall),
            model = ImageRequest
                .Builder(mContext)
                .data(getDrawableFromString(mContext, item?.imageUrl ?: "ic_placeholder"))
                .error(R.drawable.ic_placeholder)
                .placeholder(R.drawable.ic_placeholder)
                .build(),
            contentDescription = "Image",
            contentScale = ContentScale.Crop,
        )

        Column(
            modifier = Modifier
                .weight(0.5F)
                .fillMaxSize(),
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = GSDASpace.GSVCSmall, vertical = GSDASpace.GSVCExtraSmall),
                fontWeight = FontWeight.Bold,
                text = config.title ?: "",
                color = config.titleColor ?: Color.White,
                fontSize = 24.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = GSDASpace.GSVCSmall, vertical = GSDASpace.GSVCExtraSmall),
                text = config.text ?: "",
                color = config.textColor ?: Color.White,
                fontSize = 18.sp,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = GSDASpace.GSVCSmall, vertical = GSDASpace.GSVCExtraSmall),
                horizontalArrangement = Arrangement.End,
            ) {
                TextButton(
                    onClick = { },
                ) {
                    Text(
                        modifier = Modifier
                            .padding(horizontal = GSDASpace.GSVCExtraSmall),
                        text = config.textButton ?: "Conocer más",
                        fontSize = 21.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF01AD35),
                    )

                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowRight,
                        tint = Color(0xFF01AD35),
                        contentDescription = "",
                    )
                }
            }
        }
    }
}

@Composable
@Preview
fun GSDAContentGridCard1() {
    Card(
        modifier = Modifier
            .width(250.dp)
            .height(320.dp),
        backgroundColor = Color(0xFF0B0621),
    ) {
        GSDAContentGridCard(
            config =
            GSDAGenericCard(
                title = "Wallet Bitcoin",
                text = "Compra y vende con la red de pago Lightning",
            ),
        )
    }
}
