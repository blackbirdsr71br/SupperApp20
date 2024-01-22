package com.alex.dashboarddemo.domain.model

import com.squareup.moshi.Json

enum class GSDASubItemViewType {
    @Json(name = "categoriesElement")
    CategoriesElement,

    @Json(name = "bannersElement")
    BannersElement,

    @Json(name = "restaurantElement")
    RestaurantElement,

    @Json(name = "sliderPromoCard")
    SlidePromoCard,

    @Json(name = "imageCarousell")
    ImageCarousell,

    @Json(name = "staticBanner")
    StaticBanner,

    @Json(name = "storeBanner")
    StoreBanner,

    @Json(name = "paymentCard")
    PaymentCard,
}
