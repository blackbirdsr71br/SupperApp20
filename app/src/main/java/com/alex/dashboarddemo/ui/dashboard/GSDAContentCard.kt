package com.alex.dashboarddemo.ui.dashboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import com.alex.dashboarddemo.data.GSDAGenericCardModel
import com.alex.dashboarddemo.network.model.Dashboard
import com.alex.dashboarddemo.utils.getDrawableFromString
import com.example.basedemomaterial3.ui.theme.SDASpace

@Composable
fun GSDAContentCard(
    item: Dashboard.Item.SubItem? = null,
    config: GSDAGenericCardModel
) {
    val mContext = LocalContext.current
    Column {
        AsyncImage(
            modifier = Modifier
                .weight(0.6F)
                .padding(bottom = SDASpace.GSVCSmall),
            model = ImageRequest
                .Builder(mContext)
                .data(getDrawableFromString(mContext, item?.imageUrl ?: "ic_placeholder"))
                .error(R.drawable.ic_placeholder)
                .placeholder(R.drawable.ic_placeholder)
                .build(),
            contentDescription = "Image",
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .weight(0.5F)
                .fillMaxSize()
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = SDASpace.GSVCSmall, vertical = SDASpace.GSVCExtrasmall),
                fontWeight = FontWeight.Bold,
                text = config.title ?: "",
                color = config.titleColor ?: Color.White,
                fontSize = 24.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = SDASpace.GSVCSmall, vertical = SDASpace.GSVCExtrasmall),
                text = config.text ?: "",
                color = config.textColor ?: Color.White,
                fontSize = 18.sp,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = SDASpace.GSVCSmall, vertical = SDASpace.GSVCExtrasmall),
                horizontalArrangement = Arrangement.End
            ) {
                TextButton(
                    onClick = {  }
                ) {
                    Text(
                        modifier = Modifier
                            .padding(horizontal = SDASpace.GSVCExtrasmall),
                        text = config.textButton ?: "Conocer más",
                        fontSize = 21.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF01AD35)
                    )

                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                        tint = Color(0xFF01AD35),
                        contentDescription = ""
                    )
                }
            }
        }
    }
}

@Composable
@Preview
fun GSDAContentCardv() {
    Card(
        modifier = Modifier
            .width(250.dp)
            .height(320.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF0B0621)
        )
    ) {
        GSDAContentCard( config =
            GSDAGenericCardModel(
                title = "Wallet Bitcoin",
                text = "Compra y vende con la red de pago Lightning"
            )
        )
    }
}
