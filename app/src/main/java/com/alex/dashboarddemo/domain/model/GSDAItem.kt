package com.alex.dashboarddemo.domain.model

data class GSDAItem(
    val id: Int,
    val title: String,
    val subtitle: String,
    val imageId: Int,
    val source: String = "demo source",
)
