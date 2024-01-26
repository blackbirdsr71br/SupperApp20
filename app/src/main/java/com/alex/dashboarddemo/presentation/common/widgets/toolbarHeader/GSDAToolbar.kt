package com.alex.dashboarddemo.presentation.common.widgets.toolbarHeader

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import com.alex.dashboarddemo.R
import com.alex.dashboarddemo.presentation.common.model.GSDACollapsingToolbarModel
import com.alex.dashboarddemo.ui.theme.buttonSize
import com.alex.dashboarddemo.ui.theme.collapsedPadding
import com.alex.dashboarddemo.ui.theme.collapsedStoreLogoHeight
import com.alex.dashboarddemo.ui.theme.contentPadding
import com.alex.dashboarddemo.ui.theme.elevation
import com.alex.dashboarddemo.ui.theme.expandedPadding
import com.alex.dashboarddemo.ui.theme.expandedStoreLogoHeight
import kotlin.math.roundToInt

@Composable
fun GSDACollapsingToolbar(
    collapsingToolbarModel: GSDACollapsingToolbarModel,
) {
    with(collapsingToolbarModel) {
        val storeLogoHeight = with(LocalDensity.current) {
            lerp(collapsedStoreLogoHeight.toPx(), expandedStoreLogoHeight.toPx(), progress).toDp()
        }
        val logoPadding = with(LocalDensity.current) {
            lerp(collapsedPadding.toPx(), expandedPadding.toPx(), progress).toDp()
        }

        Surface(
            color = Color.Black,
            elevation = elevation,
            modifier = modifier,
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                // #region Background Image
                SubcomposeAsyncImage(
                    modifier = modifier
                        .fillMaxSize()
                        .padding(0.dp)
                        .clip(shape = RoundedCornerShape(0.dp)),
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(backgroundImageResId)
                        .crossfade(true)
                        .build(),
                    alignment = Alignment.Center,
                    contentDescription = "",
                    contentScale = ContentScale.FillWidth,
                    colorFilter = tint?.let { ColorFilter.tint(it) },
                    loading = {},
                    alpha = 0.5f,
                )

                // #endregion
                Box(
                    modifier = Modifier
                        .statusBarsPadding()
                        .padding(horizontal = contentPadding)
                        .fillMaxSize(),
                ) {
                    GSDACollapsingToolbarLayout(progress = progress) {
                        // #region Logo Images
                        Box(
                            modifier = Modifier
                                .height(storeLogoHeight)
                                .width(100.dp),
                            contentAlignment = Alignment.CenterStart,
                        ) {
                            SubcomposeAsyncImage(
                                modifier = modifier
                                    .padding(logoPadding)
                                    .height(storeLogoHeight),
                                model = ImageRequest.Builder(LocalContext.current)
                                    .data(imgStoreLogo)
                                    .build(),
                                contentDescription = "",
                                colorFilter = ColorFilter.tint(Color.White),
                            )
                        }

                        // #endregion

                        // #region Back Button
                        Row(
                            modifier = Modifier
                                .wrapContentSize()
                                .padding(top = 8.dp),
                            horizontalArrangement = Arrangement.spacedBy(contentPadding),
                        ) {
                            IconButton(
                                onClick = onBackButtonClicked,
                                modifier = Modifier
                                    .size(buttonSize)
                                    .background(
                                        color = LocalContentColor.current.copy(alpha = 0.0f),
                                        shape = CircleShape,
                                    ),
                            ) {
                                Icon(
                                    modifier = Modifier.fillMaxSize(),
                                    imageVector = Icons.AutoMirrored.Rounded.ArrowBack,
                                    contentDescription = null,
                                    tint = Color.White,
                                )
                            }
                        }
                        // #endregion backbutton

                        // #region Buttons
                        Row(
                            modifier = Modifier
                                .wrapContentSize()
                                .padding(top = 8.dp),
                            horizontalArrangement = Arrangement.spacedBy(contentPadding),
                        ) {
                            IconButton(
                                onClick = onSearchButtonClicked,
                                modifier = Modifier
                                    .size(buttonSize)
                                    .background(
                                        color = LocalContentColor.current.copy(alpha = 0.0f),
                                        shape = CircleShape,
                                    ),
                            ) {
                                Icon(
                                    modifier = Modifier.fillMaxSize(),
                                    imageVector = Icons.Rounded.Search,
                                    contentDescription = null,
                                    tint = Color.White,
                                )
                            }
                            IconButton(
                                onClick = onShoppingCartButtonClicked,
                                modifier = Modifier
                                    .size(buttonSize)
                                    .background(
                                        color = LocalContentColor.current.copy(alpha = 0.0f),
                                        shape = CircleShape,
                                    ),
                            ) {
                                Icon(
                                    modifier = Modifier.fillMaxSize(),
                                    imageVector = Icons.Rounded.ShoppingCart,
                                    contentDescription = null,
                                    tint = Color.White,
                                )
                            }
                        }
                        // #endregion
                    }
                }
            }
        }
    }
}

@Composable
private fun GSDACollapsingToolbarLayout(
    progress: Float,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Layout(
        modifier = modifier,
        content = content,
    ) { measurables, constraints ->
        check(measurables.size == 3) // [0]: Back Icon | [1]: Logo Images | [2]: Buttons

        val placeables = measurables.map {
            it.measure(constraints)
        }
        layout(
            width = constraints.maxWidth,
            height = constraints.maxHeight,
        ) {
            val expandedHorizontalGuideline = (constraints.maxHeight * 0.4f).roundToInt()
            val collapsedHorizontalGuideline = (constraints.maxHeight * 0.5f).roundToInt()
            val storeLogo = placeables[0]
            val backbutton = placeables[1]
            val actionButtons = placeables[2]
            storeLogo.placeRelative(
                x = lerp(
                    start = constraints.minWidth,
                    stop = (constraints.maxWidth / 3),
                    fraction = progress,
                ),
                y = lerp(
                    start = collapsedHorizontalGuideline - storeLogo.height / 2,
                    stop = expandedHorizontalGuideline,
                    fraction = progress,
                ),
            )
            backbutton.placeRelative(
                x = constraints.minWidth,
                y = lerp(
                    start = (constraints.maxHeight - actionButtons.height) / 3,
                    stop = 0,
                    fraction = progress,
                ),
            )
            actionButtons.placeRelative(
                x = constraints.maxWidth - actionButtons.width,
                y = lerp(
                    start = (constraints.maxHeight - actionButtons.height) / 3,
                    stop = 0,
                    fraction = progress,
                ),
            )
        }
    }
}

@Preview
@Composable
fun GSDACollapsingToolbarCollapsedPreview() {
    GSDACollapsingToolbarModel(
        backgroundImageResId = R.drawable.shoesback,
        imgStoreLogo = R.drawable.flexilogo,
        progress = 0f,
        onBackButtonClicked = {},
        onSearchButtonClicked = {},
        onShoppingCartButtonClicked = {},
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp),
    ).apply {
        GSDACollapsingToolbar(this)
    }
}

@Preview
@Composable
fun GSDACollapsingToolbarHalfwayPreview() {
    GSDACollapsingToolbarModel(
        backgroundImageResId = R.drawable.shoesback,
        imgStoreLogo = R.drawable.flexilogo,
        progress = 0.5f,
        onBackButtonClicked = {},
        onSearchButtonClicked = {},
        onShoppingCartButtonClicked = {},
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp),
    ).apply {
        GSDACollapsingToolbar(this)
    }
}

@Preview
@Composable
fun GSDACollapsingToolbarExpandedPreview() {
    GSDACollapsingToolbarModel(
        backgroundImageResId = R.drawable.shoesback,
        imgStoreLogo = R.drawable.flexilogo,
        progress = 1.0f,
        onBackButtonClicked = {},
        onSearchButtonClicked = {},
        onShoppingCartButtonClicked = {},
        modifier = Modifier
            .fillMaxWidth()
            .height(160.dp),
    ).apply {
        GSDACollapsingToolbar(this)
    }
}