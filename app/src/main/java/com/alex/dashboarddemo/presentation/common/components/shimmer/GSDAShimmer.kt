@file:JvmName("GSDAShimmerConfigKt")

package com.alex.dashboarddemo.presentation.common.components.shimmer

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.alex.dashboarddemo.presentation.common.model.GSDAShimmerBounds

@Composable
fun rememberShimmer(
    shimmerBounds: GSDAShimmerBounds,
    theme: GSDAShimmerTheme = LocalShimmerTheme.current,
): GSDAShimmerConfig {
    val effect = rememberShimmerEffect(theme)
    val bounds = rememberShimmerBounds(shimmerBounds)

    return remember(theme, effect, bounds) {
        GSDAShimmerConfig(theme, effect, bounds)
    }
}