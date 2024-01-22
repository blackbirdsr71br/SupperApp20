package com.alex.dashboarddemo.presentation.common.model

import com.alex.dashboarddemo.R

data class GSDAHeaderModel(
    val name: String = "",
    val points: String = "",
    val urlProfile: Int = R.drawable.personperfil,
    val urlNotification: Int = R.drawable.baseline_notifications_24,
    val urlRewards: Int = R.drawable.ic_gema,
    val notificationsIndicator: Boolean = false,
    val rewardsIndicator: Boolean = false,
)
