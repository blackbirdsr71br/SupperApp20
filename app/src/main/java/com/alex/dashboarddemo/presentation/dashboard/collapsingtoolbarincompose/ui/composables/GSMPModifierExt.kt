package com.alex.dashboarddemo.presentation.dashboard.collapsingtoolbarincompose.ui.composables

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp

val linearLightGradientColors = listOf(
    Color(0xFFF0F0F1),
    Color(0xFFCFCFCF),
    Color(0xFFF0F0F1),
)

val linearLightDarkGradientColors = listOf(
    Color(0xFFD9D9D9),
    Color(0xFFB8B8B8),
    Color(0xFFD9D9D9),
)

fun Modifier.shimmerEffect(
    durationMillis: Int = 1500,
    gradientColors: List<Color> = linearLightGradientColors,
): Modifier = composed {
    val size = remember { mutableStateOf(IntSize.Zero) }
    val transition = rememberInfiniteTransition()
    val startOffsetX = transition.animateFloat(
        initialValue = -2 * size.value.width.toFloat(),
        targetValue = 2 * size.value.width.toFloat(),
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = durationMillis, delayMillis = 250),
        ),
        label = "",
    )

    background(
        brush = Brush.linearGradient(
            colors = gradientColors,
            start = Offset(x = startOffsetX.value, y = 0f),
            end = Offset(
                x = startOffsetX.value + size.value.width.toFloat(),
                y = size.value.height.toFloat(),
            ),
        ),
    )
        .onGloballyPositioned {
            size.value = it.size
        }
}

@Preview(showBackground = true, backgroundColor = 0xffffff, widthDp = 300)
@Composable
private fun ColorsPreview() {
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(brush = Brush.linearGradient(colors = linearLightGradientColors)),
        )
        Spacer(modifier = Modifier.fillMaxWidth().height(20.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(
                    brush = Brush.linearGradient(
                        colors = linearLightDarkGradientColors,
                    ),
                ),
        )
    }
}

@Composable
fun BoxShimmer(
    height: Dp,
    fraction: Float = 1f,
    shape: Shape = RoundedCornerShape(6.dp),
) {
    Box(
        modifier = Modifier
            .fillMaxWidth(fraction = fraction)
            .height(height = height)
            .clip(shape = shape)
            .shimmerEffect(),
    )
}

@Composable
fun RoundShimmer(
    paddingSize: Dp = 20.dp,
    shape: Shape = RoundedCornerShape(50.dp),
) {
    Box(
        modifier = Modifier
            .padding(paddingSize)
            .aspectRatio(1F)
            .clip(shape = shape)
            .shimmerEffect(),
    )
}
