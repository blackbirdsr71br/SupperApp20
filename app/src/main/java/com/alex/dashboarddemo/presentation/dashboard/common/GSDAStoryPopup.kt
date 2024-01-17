package com.alex.dashboarddemo.presentation.dashboard.common

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alex.dashboarddemo.domain.model.GSDAItem
import com.alex.dashboarddemo.data.mockdata.DemoDataProvider
import com.alex.dashboarddemo.ui.theme.GSVCBase100
import kotlinx.coroutines.launch

@Composable
fun GSDAStoryPopup(
    imageIds: List<GSDAItem>,
    contentScale: ContentScale = ContentScale.Crop,
    colorSlider: Color = GSVCBase100
): Int {
    var currentStoryCount by remember { mutableStateOf(0) }

    var storyPaused by remember { mutableStateOf(false) }

    val percent = remember { Animatable(0f) }

    val config = LocalConfiguration.current
    val width = with(LocalDensity.current) { config.screenWidthDp.dp.toPx() }
    val leftClickSectionX = width / 4
    val rightClickSectionX = width - width / 4
    val coroutineScope = rememberCoroutineScope()
    val storySize = imageIds.size

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectTapGestures(
                    onPress = {
                        storyPaused = true
                        if (tryAwaitRelease()) {
                            storyPaused = false
                        }
                    },
                ) { offset ->
                    when {
                        offset.x < leftClickSectionX -> {
                            if (currentStoryCount > 0) {
                                currentStoryCount--
                                coroutineScope.launch {
                                    percent.snapTo(0f)
                                }
                            }
                        }

                        offset.x > rightClickSectionX -> {
                            if (currentStoryCount < storySize - 1) {
                                currentStoryCount++
                                coroutineScope.launch {
                                    percent.snapTo(0f)
                                }
                            }
                        }
                    }
                }
            },
    ) {
        Image(
            painter = painterResource(id = imageIds[currentStoryCount].imageId),
            modifier = Modifier.fillMaxSize(),
            contentDescription = null,
            contentScale = contentScale,
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
        ) {
            LaunchedEffect(currentStoryCount, storyPaused) { // (2)
                if (storyPaused) {
                    percent.stop()
                } else {
                    if (currentStoryCount == storySize - 1) {
                        currentStoryCount = 0
                        coroutineScope.launch {
                            percent.snapTo(0f)
                        }
                    }
                    percent.animateTo(
                        targetValue = 1f,
                        animationSpec = tween(
                            durationMillis = (5000 * (1f - percent.value)).toInt(), // (3)
                            easing = LinearEasing,
                        ),
                    )
                    if (storySize - 1 > currentStoryCount) {
                        percent.snapTo(0f)
                        currentStoryCount++
                    }
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
            ) {
                (0 until storySize - 1).forEach { storyIndex ->
                    val progress = when {
                        storyIndex < currentStoryCount -> 1f
                        storyIndex > currentStoryCount -> 0f
                        else -> percent.value
                    }
                    LinearProgressIndicator(
                        modifier = Modifier
                            .weight(1f)
                            .padding(horizontal = 4.dp),
                        progress = progress,
                        color = colorSlider,
                        strokeCap = StrokeCap.Round,
                    )
                }
            }
        }
    }
    return currentStoryCount
}

@Preview(showBackground = true)
@Composable
fun PopupPreview() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(400.dp)
            .padding(8.dp),
        contentAlignment = Alignment.BottomCenter,
    ) {
        val index = GSDAStoryPopup(
            imageIds = DemoDataProvider.ProductList.take(6),
            contentScale = ContentScale.Fit,
        )
    }
}
