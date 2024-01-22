package com.alex.dashboarddemo.domain.model

data class GSDADashboard(
    val data: List<GSDAItem>,
) {
    data class GSDAItem(
        val viewType: GSDAItemViewType,
        val header: GSDAHeader?,
        val data: List<GSDASubItem>,
    ) {
        data class GSDAHeader(
            val title: String?,
            val hasMore: Boolean,
            val subtitle: String,
        )

        data class GSDASubItem(
            val viewType: GSDASubItemViewType,
            val imageUrl: String,
            val title: String?,
            val subTitle: String?,
            val action: GSDADashboardAction,
            val meta: GSDAMeta?,
        ) {
            data class GSDAMeta(
                val bgColor: String?,
                val rating: String?,
                val reviewCount: String?,
                val hasFreeDelivery: Boolean,
            )
        }
    }
}
