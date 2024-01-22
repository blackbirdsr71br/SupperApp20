package com.alex.dashboarddemo.domain.model

import com.squareup.moshi.Json

enum class GSDAItemViewType {
    @Json(name = "horizontalScroll")
    HorizontalScroll,

    @Json(name = "verticalScroll")
    VerticalScroll,

    @Json(name = "verticalGrid")
    VerticalGrid,
}
