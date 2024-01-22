package com.alex.dashboarddemo.presentation.common.model

sealed class GSDAShimmerBounds {
    object Custom : GSDAShimmerBounds()
    object View : GSDAShimmerBounds()
    object Window : GSDAShimmerBounds()
}
