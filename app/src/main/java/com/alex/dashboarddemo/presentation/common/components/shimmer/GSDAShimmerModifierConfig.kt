package com.alex.dashboarddemo.presentation.common.components.shimmer

import androidx.compose.ui.draw.DrawModifier
import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import androidx.compose.ui.layout.LayoutCoordinates
import androidx.compose.ui.layout.OnGloballyPositionedModifier
import com.alex.dashboarddemo.utils.unClippedBoundsInWindow

internal class GSDAShimmerModifierConfig(
    private val area: GSDAShimmerAreaConfig,
    private val effect: GSDAShimmerEffectConfig,
) : DrawModifier, OnGloballyPositionedModifier {

    override fun ContentDrawScope.draw() {
        with(effect) { draw(area) }
    }

    override fun onGloballyPositioned(coordinates: LayoutCoordinates) {
        val viewBounds = coordinates.unClippedBoundsInWindow()
        area.viewBounds = viewBounds
    }
}
