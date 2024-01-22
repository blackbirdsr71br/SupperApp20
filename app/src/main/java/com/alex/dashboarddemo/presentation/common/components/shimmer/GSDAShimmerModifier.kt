@file:JvmName("GSDAShimmerModifierConfigKt")

package com.alex.dashboarddemo.presentation.common.components.shimmer

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.debugInspectorInfo
import com.alex.dashboarddemo.presentation.common.model.GSDAShimmerBounds


fun Modifier.shimmer(
    customShimmer: GSDAShimmerConfig? = null,
): Modifier = composed(
    factory = {
        val shimmer = customShimmer ?: rememberShimmer(GSDAShimmerBounds.View)

        val width = with(LocalDensity.current) { shimmer.theme.shimmerWidth.toPx() }
        val area = remember(width, shimmer.theme.rotation) {
            GSDAShimmerAreaConfig(width, shimmer.theme.rotation)
        }

        LaunchedEffect(area, shimmer) {
            shimmer.boundsFlow.collect {
                area.updateBounds(it)
            }
        }

        remember(area, shimmer) { GSDAShimmerModifierConfig(area, shimmer.effect) }
    },
    inspectorInfo = debugInspectorInfo {
        name = "shimmer"
        properties["customShimmer"] = customShimmer
    },
)