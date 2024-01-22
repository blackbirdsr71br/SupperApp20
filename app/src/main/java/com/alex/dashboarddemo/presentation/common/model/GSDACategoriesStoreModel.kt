package com.alex.dashboarddemo.presentation.common.model

data class GSDACategoriesStoreModel(
    val imgImgUrl: String,
    val txtCategoryTitle: String,
    val onCardClicked: () -> Unit,
)
