package com.alex.dashboarddemo.ui.dashboard.gsvcProductCard

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alex.dashboarddemo.R
import com.alex.dashboarddemo.ui.dashboard.badges.gsvcBadgeStatus.GSDAInformativeChip
import com.alex.dashboarddemo.ui.dashboard.badges.gsvcBadgeStatus.GSDAInformativeChipModel
import com.alex.dashboarddemo.ui.theme.GSVCInfo100
import com.alex.dashboarddemo.ui.theme.SDAColor
import com.alex.dashboarddemo.ui.theme.SDATypography
import com.alex.dashboarddemo.ui.theme.h5
import com.bumptech.glide.request.RequestOptions
import com.example.basedemomaterial3.ui.theme.SDARatio
import com.example.basedemomaterial3.ui.theme.SDASpace
import com.skydoves.landscapist.glide.GlideImage

enum class ProductCardType {
    SHOPPING_CENTER,
    MARKET_PLACE,
}

@Composable
fun GSVCProductCard(
    gsvcGenericProductCardBuilder : GSVCGenericProductCardBuilder,
    productCardType : ProductCardType = ProductCardType.SHOPPING_CENTER,
) {
    when (productCardType) {
        ProductCardType.SHOPPING_CENTER -> CCProductCardLayout(gsvcGenericProductCardBuilder = gsvcGenericProductCardBuilder)
        ProductCardType.MARKET_PLACE -> {}
    }
}

/** LAYOUTS **/
@Composable
private fun CCProductCardLayout(gsvcGenericProductCardBuilder : GSVCGenericProductCardBuilder) {
    Surface(
        modifier = Modifier
            .width(180.dp)
            .height(270.dp),
        shape = RoundedCornerShape(CornerSize(SDARatio.GSVCSmall))
    ) {
        Column(
            modifier = Modifier
                .background(SDAColor.GSVCPrimary)
                .padding(SDASpace.GSVCSmall),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            gsvcGenericProductCardBuilder.image?.let { imageType ->
                Surface(shape = RoundedCornerShape(CornerSize(SDARatio.GSVCSmall))) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                    ) {
                        ProductImage(imageType = imageType)
                    }
                }
            }
            Spacer(modifier = Modifier.height(SDASpace.GSVCSmall))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                gsvcGenericProductCardBuilder.imageList?.let { imageList ->
                    ImageList(imageList = imageList)
                }
                Spacer(modifier = Modifier.width(SDASpace.GSVCExtrasmall))
                gsvcGenericProductCardBuilder.label?.let { label ->
                    Label(
                        label = label,
                        totalStores = gsvcGenericProductCardBuilder.imageList?.size ?: 0
                    )
                }
            }
            Spacer(modifier = Modifier.height(SDASpace.GSVCSmall))
            gsvcGenericProductCardBuilder.description?.let { description ->
                Description(description = description)
            }
            Spacer(modifier = Modifier.height(SDASpace.GSVCExtrasmall))
            gsvcGenericProductCardBuilder.prices?.let { priceDiscount ->
                PriceDiscount(priceDiscount = priceDiscount)
            }
            Spacer(modifier = Modifier.height(SDASpace.GSVCExtrasmall))
            gsvcGenericProductCardBuilder.body?.let { body ->
                Body(body = body)
            }
            gsvcGenericProductCardBuilder.optionList?.let { optionList ->
                OptionList(optionList = optionList)
            }

        }
    }
}

/** COMPONENTES**/
@Composable
private fun ProductImage(imageType : GSVCImageType) {
    imageType.OnEach(
        isUrl = { image, contenScale, _ ->
            GlideImage(
                modifier = Modifier.fillMaxSize(),
                imageModel = image,
                contentScale = contenScale ?: ContentScale.Fit,
                previewPlaceholder = R.drawable.placeholder_banner
            )
        },
        isDrawable = { image, contenScale, color ->
            Box(modifier = Modifier.background(color ?: Color.Unspecified)) {
                Image(
                    painter = painterResource(id = image),
                    contentDescription = "",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = contenScale ?: ContentScale.Fit,
                )
            }
        },
        isImageVector = { image, contenScale, color ->
            Box(modifier = Modifier.background(color ?: Color.Unspecified)) {
                Image(
                    imageVector = image,
                    contentDescription = "",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = contenScale ?: ContentScale.Fit,
                )
            }
        },
    )
}

@Composable
private fun ImageList(imageList : List<GSVCImageType>) {
    Row(horizontalArrangement = Arrangement.spacedBy((-12).dp)) {
        imageList.forEachIndexed { index, gsvcImageType ->
            if (index < 3) {
                gsvcImageType.OnEach(
                    isUrl = { image, contenScale, _ ->
                        GlideImage(
                            modifier = Modifier
                                .size(24.dp),
                            imageModel = image,
                            contentScale = contenScale ?: ContentScale.Crop,
                            requestOptions = { RequestOptions.circleCropTransform() },
                            previewPlaceholder = R.drawable.placeholder_banner
                        )
                    },
                    isDrawable = { image, contenScale, color ->
                        Surface(
                            shape = CircleShape,
                            border = BorderStroke(1.dp, SDAColor.GSVCPrimary),
                        ) {
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier.background(color ?: Color.Unspecified),
                            ) {
                                Image(
                                    painter = painterResource(id = image),
                                    contentDescription = "",
                                    modifier = Modifier
                                        .size(24.dp)
                                        .clip(CircleShape),
                                    contentScale = contenScale ?: ContentScale.Crop,
                                )
                            }
                        }
                    },
                    isImageVector = { image, contenScale, color ->
                        Surface(
                            shape = CircleShape,
                            border = BorderStroke(1.dp, SDAColor.GSVCPrimary),
                        ) {
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier.background(color ?: Color.Unspecified),
                            ) {
                                Image(
                                    imageVector = image,
                                    contentDescription = "",
                                    modifier = Modifier
                                        .size(24.dp)
                                        .clip(CircleShape),
                                    contentScale = contenScale ?: ContentScale.Crop,
                                )
                            }
                        }
                    },
                )
            }
        }
    }
}

@Composable
private fun Label(label : String, totalStores : Int) {
    Text(
        text =
        when (totalStores) {
            0 -> ""
            1 -> label
            in 2..3 -> "En $totalStores tiendas"
            else -> "En +3 tiendas"
        },
        style = SDATypography.GSVCHelper.merge(TextStyle(fontWeight = FontWeight.W600)),
        color = SDAColor.GSVCTypography,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
    )
}

@Composable
private fun Description(description : String) {
    Text(
        text = description,
        style = SDATypography.GSVCHelper,
        color = SDAColor.GSVCTypography,
        maxLines = 2, // Preguntar si va a dos líneas
        overflow = TextOverflow.Ellipsis,
    )
}

@Composable
private fun PriceDiscount(priceDiscount : Pair<AnnotatedString?, AnnotatedString>) {
    Row(modifier = Modifier.fillMaxWidth()) {
        priceDiscount.first?.let { leftPrice ->
            Text(
                text = leftPrice,
                style = SDATypography.GSVCHelper,
            )
        }
        Spacer(modifier = Modifier.width(SDASpace.GSVCExtrasmall))
        Text(
            text = priceDiscount.second,
            style = SDATypography.GSVCHelper,
        )
    }
}

@Composable
private fun Body(body : AnnotatedString) {
    Text(
        modifier = Modifier.fillMaxWidth(),
        text = body,
        textAlign = TextAlign.Start,
    )
}

@Composable
private fun OptionList(optionList : List<Pair<Int?, String>>) {
    optionList.forEach { option ->
        Spacer(modifier = Modifier.height(SDASpace.GSVCExtrasmall))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            option.first?.let { resource ->
                Icon(
                    painter = painterResource(id = resource),
                    contentDescription = "icon",
                    modifier = Modifier.size(16.dp),
                    tint = Color.Unspecified,
                )
            }
            Spacer(modifier = Modifier.width(SDASpace.GSVCSmall))
            Text(
                text = option.second,
                style = SDATypography.GSVCBodySmall,
            )
        }
    }
}


@Preview
@Composable
fun ProductCardPreviewDS() {

    val model2 = GSVCGenericProductCardBuilder.build {
        image = GSVCImageType.DrawableImage(image = R.drawable.apolo)
        imageList = listOf(
            GSVCImageType.UrlImage(
                image = "data:image/jpeg;base64,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",
                background = Color.Red,
            ),
        )
        label = "Steren"
        description = "Celular Samsung 128Gb de Almacenamiento y 8Gb de Ram dfdfdfdfdfdfdfdfdfdfdfdfdfdfdf"
        prices = Pair(
            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.W500,
                        textDecoration = TextDecoration.LineThrough,
                        color = SDAColor.GSVCInteractionDisable,
                    ),
                ) {
                    append("$1,169")
                }
            },
            buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.W500)) {
                    append("$1,074")
                }
            },
        )
        body = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                ),
            ) {
                append("$54")
            }
            withStyle(
                style = SpanStyle(
                    fontSize = 8.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    baselineShift = BaselineShift.Superscript,
                ),
            ) {
                append("80")
            }
            withStyle(
                style = SpanStyle(
                    fontSize = 10.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    color = SDAColor.GSVCInteractions,
                ),
            ) {
                append("\nPago semanal")
            }
        }
    }


        GSVCProductCard(gsvcGenericProductCardBuilder = model2, ProductCardType.SHOPPING_CENTER)

}