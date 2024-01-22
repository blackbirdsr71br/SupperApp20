package com.alex.dashboarddemo.presentation.common.components

import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentAlpha
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun GSDAPrimaryText(children: @Composable () -> Unit) {
    CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.high) {
        children.invoke()
    }
}

@Composable
fun GSDASecondaryText(children: @Composable () -> Unit) {
    CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
        children.invoke()
    }
}

@Composable
fun GSDADisabledText(children: @Composable () -> Unit) {
    CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.disabled) {
        children.invoke()
    }
}
