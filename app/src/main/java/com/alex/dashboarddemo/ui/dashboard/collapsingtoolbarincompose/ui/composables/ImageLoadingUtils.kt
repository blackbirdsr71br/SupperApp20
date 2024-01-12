package com.alex.dashboarddemo.ui.dashboard.collapsingtoolbarincompose.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest

@Composable
fun LoadImage(
    modifier: Modifier = Modifier,
    image: Any?,
    tint: Color? = null,
) {
    SubcomposeAsyncImage(
        modifier = modifier
            .fillMaxSize()
            .clip(shape = RoundedCornerShape(5.dp))
            .padding(8.dp),
        model = ImageRequest.Builder(LocalContext.current)
            .data(image)
            .crossfade(true)
            .build(),
        alignment = Alignment.Center,
        contentDescription = "",
        contentScale = ContentScale.Fit,
        colorFilter = tint?.let { ColorFilter.tint(it) },
        loading = {
            BoxShimmer(fraction = 0.5f, height = 27.dp)
        },
    )
}

@Composable
private fun Placeholder() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray),
    ) {
    }
}
