package com.alex.dashboarddemo.presentation.common.components.shimmer

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalDensity

@Composable
internal fun rememberShimmerEffect(theme: GSDAShimmerTheme): GSDAShimmerEffectConfig {
    val shimmerWidth = with(LocalDensity.current) { theme.shimmerWidth.toPx() }
    val shimmerEffect = remember(theme) {
        GSDAShimmerEffectConfig(
            animationSpec = theme.animationSpec,
            blendMode = theme.blendMode,
            rotation = theme.rotation,
            shaderColors = theme.shaderColors,
            shaderColorStops = theme.shaderColorStops,
            shimmerWidth = shimmerWidth,
        )
    }

    LaunchedEffect(shimmerEffect) {
        shimmerEffect.startAnimation()
    }
    return shimmerEffect
}