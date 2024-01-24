package com.alex.dashboarddemo.presentation.common.model

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import com.alex.dashboarddemo.ui.theme.SDAColor
import com.alex.dashboarddemo.ui.theme.SDATypography

data class GSDACouponCardModel(
    val badgesStatusText: String = "",
    val badgesTextStyle: TextStyle = SDATypography.GSVCSubtitleBold.merge(TextStyle(color = SDAColor.GSVCPrimary)),
    val badgesBackgroundColor: Color = SDAColor.GSVCInformation200,
    val badgesPosition: GSDABadgesPosition = GSDABadgesPosition.RIGHT,
    val backgroundContent: Color = SDAColor.GSVCPrimary,
    val modifier: Modifier,
    val containerBorderSize: Dp? = null,
    val containerBorderColor: Color = SDAColor.GSVCCardsLightBG,
    val paddingContent: PaddingValues? = null,
    val onClickCardEvent: (() -> Unit)? = null,
    val content: @Composable () -> Unit,
)
