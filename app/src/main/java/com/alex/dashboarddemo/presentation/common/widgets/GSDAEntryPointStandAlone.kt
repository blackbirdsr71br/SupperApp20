package com.alex.dashboarddemo.presentation.common.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import com.alex.dashboarddemo.R
import com.alex.dashboarddemo.ui.theme.SDATypography

@Composable
fun GSDAEntryPointStandAlone(
    modifier: Modifier = Modifier,
    txtEntryPointTitle: String = "Duerme como oso",
    imgEntryImage: Any,
    imgBackImage: Any,
    tint: Color? = null,
) {
    Column(
        modifier = modifier.padding(4.dp),
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = txtEntryPointTitle,
                style = SDATypography.GSVCH4,

            )
            Spacer(
                modifier = Modifier.width(8.dp),
            )

            SubcomposeAsyncImage(
                modifier = modifier
                    .size(60.dp)
                    .clip(shape = RoundedCornerShape(10.dp)),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(imgEntryImage)
                    .crossfade(true)
                    .build(),
                alignment = Alignment.Center,
                contentDescription = "",
                contentScale = ContentScale.Fit,
                colorFilter = tint?.let { ColorFilter.tint(it) },
                loading = {
                    GSDAPlaceholder()
                },
            )
        }
        Spacer(
            modifier = Modifier.height(8.dp),
        )
        Card(
            modifier = modifier
                .height(300.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(10.dp),
        ) {
            SubcomposeAsyncImage(
                modifier = modifier
                    .fillMaxSize()
                    .clip(shape = RoundedCornerShape(10.dp)),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(imgBackImage)
                    .crossfade(true)
                    .build(),
                alignment = Alignment.Center,
                contentDescription = "",
                contentScale = ContentScale.Crop,
                colorFilter = tint?.let { ColorFilter.tint(it) },
                loading = {
                    GSDAPlaceholder()
                },
            )
        }
    }
}

@Composable
private fun GSDAPlaceholder() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .clip(shape = RoundedCornerShape(10.dp)),
    ) {
    }
}

@Preview(showBackground = true)
@Composable
fun GSDAEntryPointPreview() {
    GSDAEntryPointStandAlone(
        imgEntryImage = R.drawable.springair,
        imgBackImage = R.drawable.entryspring,
    )
}
