package com.alex.dashboarddemo.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.alex.dashboarddemo.presentation.common.model.GSDAProfileSectionSize

val contentPadding = 8.dp
val elevation = 4.dp
val buttonSize = 24.dp
val expandedPadding = 1.dp
val collapsedPadding = 3.dp
val expandedStoreLogoHeight = 70.dp
val collapsedStoreLogoHeight = 32.dp

val minToolbarHeight = 70.dp
val maxToolbarHeight = 220.dp

object GSDARatio {
    val GSVCLarge = 24.dp
    val GSVCMedium = 16.dp
    val GSVCSmall = 8.dp
    val GSVCExtraSmall = 4.dp
}

object GSDASpace {
    val GSVCLarge = 16.dp
    val GSVCMedium = 12.dp
    val GSVCSmall = 8.dp
    val GSVCExtraSmall = 4.dp
}

object GSDAProfileSizes {
    val small = 20.dp
    val medium = 32.dp
    val large = 64.dp
}

object GSDAProfileSectionSizes {
    @Composable
    fun small() = GSDAProfileSectionSize(
        GSDAProfileSizes.small,
        MaterialTheme.typography.caption,
    )

    @Composable
    fun medium() = GSDAProfileSectionSize(
        GSDAProfileSizes.medium,
        MaterialTheme.typography.body1,
    )
}