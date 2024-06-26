package com.alex.dashboarddemo.network.model

import com.squareup.moshi.Json

data class Dashboard(
    val data: List<Item>,
) {
    data class Item(
        val viewType: ItemViewType,
        val header: Header?,
        val data: List<SubItem>,
    ) {
        data class Header(
            val title: String?,
            val hasMore: Boolean,
            val subtitle: String,
        )

        data class SubItem(
            val viewType: SubItemViewType,
            val imageUrl: String,
            val title: String?,
            val subTitle: String?,
            val action: DashboardAction,
            val meta: Meta?,
        ) {
            data class Meta(
                val bgColor: String?,
                val rating: String?,
                val reviewCount: String?,
                val hasFreeDelivery: Boolean,
            )
        }
    }
}

data class DashboardAction(
    val type: String,
    val value: String,
)

enum class ItemViewType {
    @Json(name = "horizontalScroll")
    HorizontalScroll,

    @Json(name = "verticalScroll")
    VerticalScroll,

    @Json(name = "verticalGrid")
    VerticalGrid,
}

enum class SubItemViewType {
    @Json(name = "categoryElement")
    CategoriesElement,

    @Json(name = "bannersElement")
    BannersElement,

    @Json(name = "restaurantElement")
    RestaurantElement,

    @Json(name = "sliderPromoCard")
    SlidePromoCard,

    @Json(name = "sliderProductCard")
    SlideProductCard,

    @Json(name = "paymentCard")
    PaymentCard,
}
