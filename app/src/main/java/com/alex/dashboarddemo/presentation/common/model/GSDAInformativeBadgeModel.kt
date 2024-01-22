package com.alex.dashboarddemo.presentation.common.model

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.alex.dashboarddemo.ui.theme.GSVCBase100
import com.alex.dashboarddemo.ui.theme.GSVCHelper3Text100Center
import com.alex.dashboarddemo.ui.theme.GSVCSuccess200

data class GSDAInformativeBadgeModel(
    val badgesStatusText: String = "",
    val badgesTextColor: Color = GSVCBase100,
    val textStyleBadgeStatus: TextStyle = GSVCHelper3Text100Center,
    val backgroundBadgesStatus: Color = GSVCSuccess200,
    val roundedCornerShape: RoundedCornerShape = RoundedCornerShape(0.dp, 0.dp, 0.dp, 0.dp),
)
