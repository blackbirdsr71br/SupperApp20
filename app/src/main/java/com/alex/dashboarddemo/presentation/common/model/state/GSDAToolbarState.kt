package com.alex.dashboarddemo.presentation.common.model.state

import androidx.compose.runtime.Stable

@Stable
interface GSDAToolbarState {
    val offset: Float
    val height: Float
    val progress: Float
    val consumed: Float
    var scrollTopLimitReached: Boolean
    var scrollOffset: Float
}
