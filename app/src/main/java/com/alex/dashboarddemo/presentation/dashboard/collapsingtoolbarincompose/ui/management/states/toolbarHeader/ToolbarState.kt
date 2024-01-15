package com.alex.dashboarddemo.presentation.dashboard.collapsingtoolbarincompose.ui.management.states.toolbarHeader

import androidx.compose.runtime.Stable

@Stable
interface ToolbarState {
    val offset: Float
    val height: Float
    val progress: Float
    val consumed: Float
    var scrollTopLimitReached: Boolean
    var scrollOffset: Float
}