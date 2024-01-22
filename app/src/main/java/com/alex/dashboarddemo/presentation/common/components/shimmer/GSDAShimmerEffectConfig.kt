package com.alex.dashboarddemo.presentation.common.components.shimmer

import android.graphics.Matrix
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.toRect
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.LinearGradientShader
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.PaintingStyle
import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.withSaveLayer

internal class GSDAShimmerEffectConfig(
    private val animationSpec: AnimationSpec<Float>,
    private val blendMode: BlendMode,
    private val rotation: Float,
    private val shaderColors: List<Color>,
    private val shaderColorStops: List<Float>?,
    private val shimmerWidth: Float,
) {

    private val animatedState = Animatable(0f)

    private val transformationMatrix = Matrix()

    private val shader = LinearGradientShader(
        from = Offset(-shimmerWidth / 2, 0f),
        to = Offset(shimmerWidth / 2, 0f),
        colors = shaderColors,
        colorStops = shaderColorStops,
    )

    private val paint = Paint().apply {
        isAntiAlias = true
        style = PaintingStyle.Fill
        blendMode = this@GSDAShimmerEffectConfig.blendMode
        shader = this@GSDAShimmerEffectConfig.shader
    }

    internal suspend fun startAnimation() {
        animatedState.animateTo(
            targetValue = 1f,
            animationSpec = animationSpec,
        )
    }

    private val emptyPaint = Paint()

    fun ContentDrawScope.draw(shimmerArea: GSDAShimmerAreaConfig) = with(shimmerArea) {
        if (shimmerBounds.isEmpty || viewBounds.isEmpty) return

        val progress = animatedState.value
        val traversal = -translationDistance / 2 + translationDistance * progress + pivotPoint.x

        transformationMatrix.apply {
            reset()
            postTranslate(traversal, 0f)
            postRotate(rotation, pivotPoint.x, pivotPoint.y)
        }
        shader.setLocalMatrix(transformationMatrix)

        val drawArea = size.toRect()
        drawIntoCanvas { canvas ->
            canvas.withSaveLayer(
                bounds = drawArea,
                emptyPaint,
            ) {
                drawContent()
                canvas.drawRect(drawArea, paint)
            }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as GSDAShimmerEffectConfig

        if (animationSpec != other.animationSpec) return false
        if (blendMode != other.blendMode) return false
        if (rotation != other.rotation) return false
        if (shaderColors != other.shaderColors) return false
        if (shaderColorStops != other.shaderColorStops) return false
        if (shimmerWidth != other.shimmerWidth) return false

        return true
    }

    override fun hashCode(): Int {
        var result = animationSpec.hashCode()
        result = 31 * result + blendMode.hashCode()
        result = 31 * result + rotation.hashCode()
        result = 31 * result + shaderColors.hashCode()
        result = 31 * result + shaderColorStops.hashCode()
        result = 31 * result + shimmerWidth.hashCode()
        return result
    }
}
