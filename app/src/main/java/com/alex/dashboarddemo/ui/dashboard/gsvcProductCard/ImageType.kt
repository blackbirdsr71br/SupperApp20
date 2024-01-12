package com.alex.dashboarddemo.ui.dashboard.gsvcProductCard

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale

sealed class GSVCImageType {
    class UrlImage(
        val image: String,
        val contentScale: ContentScale? = null,
        val background: Color? = null,
    ) : GSVCImageType()

    class DrawableImage(
        @DrawableRes val image: Int,
        val contentScale: ContentScale? = null,
        val background: Color? = null,
    ) : GSVCImageType()

    class VectorImage(
        val image: ImageVector,
        val contentScale: ContentScale? = null,
        val background: Color? = null,
    ) : GSVCImageType()

    @Composable
    fun OnEach(
        isUrl: @Composable (String, ContentScale?, Color?) -> Unit,
        isDrawable: @Composable (Int, ContentScale?, Color?) -> Unit,
        isImageVector: @Composable (ImageVector, ContentScale?, Color?) -> Unit,
    ) {
        when (this) {
            is DrawableImage -> isDrawable(image, contentScale, background)
            is UrlImage -> isUrl(image, contentScale, background)
            is VectorImage -> isImageVector(image, contentScale, background)
        }
    }
}
