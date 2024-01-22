package com.alex.dashboarddemo.presentation.common.model

import androidx.compose.ui.text.AnnotatedString

class GSDAGenericProductCardBuilder private constructor(
    val image: GSDAImageType? = null,
    val imageList: List<GSDAImageType>? = null,
    val label: String? = null,
    val description: String? = null,
    val prices: Pair<AnnotatedString?, AnnotatedString>? = null,
    val body: AnnotatedString? = null,
    val optionList: List<Pair<Int?, String>>? = null,
) {
    private constructor(builder: Builder) : this(
        image = builder.image,
        imageList = builder.imageList,
        label = builder.label,
        description = builder.description,
        prices = builder.prices,
        body = builder.body,
        optionList = builder.optionList,
    )

    companion object {
        inline fun build(block: Builder.() -> Unit) = Builder().apply(block).build()
    }

    class Builder {
        var image: GSDAImageType? = null
        var imageList: List<GSDAImageType>? = null
        var label: String? = null
        var description: String? = null
        var prices: Pair<AnnotatedString?, AnnotatedString>? = null
        var body: AnnotatedString? = null
        var optionList: List<Pair<Int?, String>>? = null
        fun build() = GSDAGenericProductCardBuilder(this)
    }
}
