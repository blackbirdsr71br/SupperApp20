package com.alex.dashboarddemo.presentation.common.components.shimmer

import androidx.compose.ui.geometry.Rect
import kotlinx.coroutines.flow.MutableStateFlow

class GSDAShimmerConfig internal constructor(
    internal val theme: GSDAShimmerTheme,
    internal val effect: GSDAShimmerEffectConfig,
    bounds: Rect?,
) {

    internal val boundsFlow = MutableStateFlow(bounds)

    fun updateBounds(bounds: Rect?) {
        boundsFlow.value = bounds
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as GSDAShimmerConfig

        if (theme != other.theme) return false
        if (effect != other.effect) return false

        return true
    }

    override fun hashCode(): Int {
        var result = theme.hashCode()
        result = 31 * result + effect.hashCode()
        return result
    }
}
