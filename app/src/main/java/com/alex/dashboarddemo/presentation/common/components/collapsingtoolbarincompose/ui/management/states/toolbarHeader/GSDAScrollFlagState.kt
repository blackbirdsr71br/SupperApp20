package com.alex.dashboarddemo.presentation.common.components.collapsingtoolbarincompose.ui.management.states.toolbarHeader

import com.alex.dashboarddemo.presentation.common.model.state.GSDAToolbarState

abstract class GSDAScrollFlagState(heightRange: IntRange) : GSDAToolbarState {

    init {
        require(heightRange.first >= 0 && heightRange.last >= heightRange.first) {
            "The lowest height value must be >= 0 and the highest height value must be >= the lowest value."
        }
    }

    protected val minHeight = heightRange.first
    protected val maxHeight = heightRange.last
    protected val rangeDifference = maxHeight - minHeight
    protected var mConsumed: Float = 0f

    protected abstract var mScrollOffset: Float

    final override val height: Float
        get() = (maxHeight - scrollOffset).coerceIn(minHeight.toFloat(), maxHeight.toFloat())

    final override val progress: Float
        get() = 1 - (maxHeight - height) / rangeDifference

    final override val consumed: Float
        get() = mConsumed

    final override var scrollTopLimitReached: Boolean = true
}
