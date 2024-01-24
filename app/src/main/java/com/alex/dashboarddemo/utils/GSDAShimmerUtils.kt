package com.alex.dashboarddemo.utils

import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.layout.LayoutCoordinates
import androidx.compose.ui.layout.positionInWindow

fun LayoutCoordinates.unClippedBoundsInWindow(): Rect {
    val positionInWindow = positionInWindow()
    return Rect(
        positionInWindow.x,
        positionInWindow.y,
        positionInWindow.x + size.width,
        positionInWindow.y + size.height,
    )
}
