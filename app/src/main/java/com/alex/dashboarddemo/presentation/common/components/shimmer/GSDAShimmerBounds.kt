package com.alex.dashboarddemo.presentation.common.components.shimmer

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.platform.LocalContext
import com.alex.dashboarddemo.presentation.common.model.GSDAShimmerBounds

@Composable
internal fun rememberShimmerBounds(
    shimmerBounds: GSDAShimmerBounds,
): Rect? {
    val displayMetrics = LocalContext.current.resources.displayMetrics
    return remember(shimmerBounds, displayMetrics) {
        when (shimmerBounds) {
            GSDAShimmerBounds.Window -> Rect(
                0f,
                0f,
                displayMetrics.widthPixels.toFloat(),
                displayMetrics.heightPixels.toFloat(),
            )

            GSDAShimmerBounds.Custom -> Rect.Zero
            GSDAShimmerBounds.View -> null
        }
    }
}
