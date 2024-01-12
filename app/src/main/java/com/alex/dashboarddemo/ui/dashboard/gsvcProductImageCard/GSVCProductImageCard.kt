package com.alex.dashboarddemo.ui.dashboard.gsvcProductImageCard

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.alex.dashboarddemo.R
import com.alex.dashboarddemo.ui.dashboard.badges.gsvcBadgeStatus.GSDAInformativeChip
import com.alex.dashboarddemo.ui.dashboard.badges.gsvcBadgeStatus.GSDAInformativeChipModel
import com.alex.dashboarddemo.ui.theme.GSVCBlack
import com.alex.dashboarddemo.ui.theme.GSVCPrimary100
import com.alex.dashboarddemo.ui.theme.GSVCPurple
import com.alex.dashboarddemo.ui.theme.GSVCTextPurple
import com.alex.dashboarddemo.ui.theme.h5
import com.alex.dashboarddemo.ui.theme.subtitle1

val texto = buildAnnotatedString {
    withStyle(
        style = SpanStyle(
            color = GSVCPrimary100,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
        ),
    ) {
        append("Pago")
    }
    withStyle(
        style = SpanStyle(
            color = GSVCPrimary100,
            fontSize = 12.sp,
        ),
    ) {
        append(" Semanal")
    }
}

@Composable
fun GSVCProductImageCard(
    gsvcProductImageCardModel: GSVCProductImageCardModel? = null,
) {
    if (gsvcProductImageCardModel != null) {
        with(gsvcProductImageCardModel) {
            when (gsvcProductImageCardModel.type) {
                is GSVCProductImageCardModel.Type.Products -> {
                    Card(
                        modifier = Modifier
                            .width(160.dp)
                            .height(305.dp)
                            .clickable { onCardClick?.invoke() },
                        shape = RoundedCornerShape(10.dp),
                        elevation = 0.dp,
                    ) {
                        Column(
                            modifier = Modifier
                                .height(intrinsicSize = IntrinsicSize.Max)
                                .width(170.dp)
                                .wrapContentWidth()
                                .padding(start = 8.dp, end = 8.dp)
                                .clip(shape = RoundedCornerShape(10.dp)),
                        ) {
                            if (gsvcProductImageCardImageModel != null) {
                                GSVCProductImageCardImage(
                                    gsvcProductImageCardImageModel = gsvcProductImageCardImageModel,
                                )
                            }
                            GSVCProductImageDescription(
                                img_Url = img_Url,
                                txt_Maker = txt_Maker,
                                productDescription = productDescription,
                            )
                            if (gsvcProductImageCardPriceModel != null) {
                                GSVCProductImageCardPrice(
                                    gsvcProductImageCardPriceModel = gsvcProductImageCardPriceModel,
                                )
                            }
                            if (gsvcProductImageCardPaymentModel?.percentDiscount != 0) {
                                if (gsvcProductImageCardPaymentModel != null) {
                                    GSVCProducImageCardPayment(
                                        gsvcProductImageCardPaymentModel = gsvcProductImageCardPaymentModel,
                                    )
                                }
                            }
                        }
                    }
                }

                is GSVCProductImageCardModel.Type.Store -> {
                    GSVCProductShopCard(onCardClick = { onCardClick?.invoke() })
                }
            }
        }
    }
}

@Composable
fun GSVCProductImageDescription(
    img_Url: Any,
    txt_Maker: String,
    productDescription: String = "",

) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        AsyncImage(
            modifier = Modifier.size(24.dp),
            model = img_Url,
            contentDescription = null,
            alignment = Alignment.CenterStart,
            contentScale = ContentScale.Fit,
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = txt_Maker,
            color = Color.Black,
            style = subtitle1,
            fontSize = 12.sp,
            maxLines = 1,
            overflow = TextOverflow.Clip,
        )
    }
    Spacer(modifier = Modifier.height(8.dp))
    Text(
        text = productDescription,
        color = Color.Black,
        style = subtitle1,
        fontSize = 12.sp,
        maxLines = 2,
        overflow = TextOverflow.Clip,
        modifier = Modifier.height(40.dp),
    )
}

@Composable
private fun GSVCProductShopCard(
    onCardClick: (() -> Unit)?,
) {
    Card(
        modifier = Modifier
            .width(160.dp)
            .height(305.dp)
            .clickable { onCardClick?.invoke() },
        shape = RoundedCornerShape(10.dp),
        elevation = 0.dp,
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .background(GSVCPurple)
                .fillMaxWidth()
                .fillMaxHeight()
                .clip(shape = RoundedCornerShape(10.dp)),
        ) {
            Icon(
                painterResource(R.drawable.gsvc_icons_system_navigation_back_off),
                "",
                tint = GSVCTextPurple,
                modifier = Modifier.size(40.dp),
            )
            Box(Modifier.height(8.dp))
            Text(
                text = "Ver toda la \n tienda",
                color = GSVCBlack,
                style = subtitle1,
                textAlign = TextAlign.Center,
                fontSize = 12.sp,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.fillMaxWidth(),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewImageCardResource() {
    GSVCProductImageCardModel(
        type = GSVCProductImageCardModel.Type.Store,
    ).apply {
        GSVCProductImageCard(gsvcProductImageCardModel = this)
    }
}

@Preview(showBackground = true, backgroundColor = 0x00000000)
@Composable
fun ProductImageCardPicture() {
    val context = LocalContext.current

    val productImage = GSVCProductImageCardImageModel(
        urlImage = "",
        imageResource = R.drawable.moto,
        resourceTint = null,
        cardBackground = Color.Unspecified,
        urlImagePromo = "",
        imagePromoVisible = true,
    )
    val productPrice = GSVCProductImageCardPriceModel(
        amountDiscount = 1000,
        hasDiscount = true,
        lineaCredito = "Baz",
        availableCredit = true,
        regularPrice = "25999",
        finalPrice = "24999",
    )
    val productPayment = GSVCProductImageCardPaymentModel(
        percentDiscount = 25,
        weeklyPayment = "540",
        regularPrice = "25999",
        bazTexto = texto,
    )

    GSVCProductImageCardModel(
        productDescription = "Motocicleta Italika Mod. 125 Blanco Negro",
        onCardClick = { onCardClick(context) },
        freeShip = true,
        shipAmount = 120,
        type = GSVCProductImageCardModel.Type.Products,
        gsvcProductImageCardImageModel = productImage,
        gsvcProductImageCardPriceModel = productPrice,
        gsvcProductImageCardPaymentModel = productPayment,
    ).apply {
        GSVCProductImageCard(gsvcProductImageCardModel = this)
    }
}

@Preview(showBackground = true, backgroundColor = 0x00000000)
@Composable
fun ProductImageCardPictureSlashed() {
    val context = LocalContext.current

    val productImage = GSVCProductImageCardImageModel(
        urlImage = "",
        imageResource = R.drawable.moto,
        resourceTint = null,
        cardBackground = Color.Unspecified,
        urlImagePromo = "",
        imagePromoVisible = true,
    )
    val productPrice = GSVCProductImageCardPriceModel(
        amountDiscount = 1000,
        hasDiscount = true,
        lineaCredito = "Baz",
        availableCredit = true,
        regularPrice = "",
        finalPrice = "24999",
    )
    val productPayment = GSVCProductImageCardPaymentModel(
        percentDiscount = 25,
        weeklyPayment = "540",
        regularPrice = "25999",
        bazTexto = texto,
    )

    GSVCProductImageCardModel(
        productDescription = "Motocicleta Italika Mod. 125 Blanco Negro",
        onCardClick = { onCardClick(context) },
        freeShip = true,
        shipAmount = 120,
        type = GSVCProductImageCardModel.Type.Products,
        gsvcProductImageCardImageModel = productImage,
        gsvcProductImageCardPriceModel = productPrice,
        gsvcProductImageCardPaymentModel = productPayment,
    ).apply {
        GSVCProductImageCard(gsvcProductImageCardModel = this)
    }
}

/*@Preview(showBackground = true)
@Composable
fun GSVCProductImageCardList() {
    val context = LocalContext.current

    val products = mutableListOf(
        GSVCProductImageCardImageModel(
            urlImage = "",
            imageResource = R.drawable.telefono,
            resourceTint = null,
            cardBackground = Color.Unspecified,
            urlImagePromo = "",
            imagePromoVisible = true,
        ),
        GSVCProductImageCardImageModel(
            urlImage = "",
            imageResource = R.drawable.moto,
            resourceTint = null,
            cardBackground = Color.Unspecified,
            urlImagePromo = "",
            imagePromoVisible = true,
        ),
        GSVCProductImageCardImageModel(
            urlImage = "",
            imageResource = R.drawable.horno,
            resourceTint = null,
            cardBackground = Color.Unspecified,
            urlImagePromo = "",
            imagePromoVisible = true,
        ),
        GSVCProductImageCardImageModel(
            urlImage = "",
            imageResource = R.drawable.horno,
            resourceTint = null,
            cardBackground = Color.Unspecified,
            urlImagePromo = "",
            imagePromoVisible = true,
        ),
        GSVCProductImageCardImageModel(
            urlImage = "",
            imageResource = R.drawable.horno,
            resourceTint = null,
            cardBackground = Color.Unspecified,
            urlImagePromo = "",
            imagePromoVisible = true,
        ),
        GSVCProductImageCardImageModel(
            urlImage = "",
            imageResource = R.drawable.horno,
            resourceTint = null,
            cardBackground = Color.Unspecified,
            urlImagePromo = "",
            imagePromoVisible = true,
        ),
        GSVCProductImageCardImageModel(
            urlImage = "",
            imageResource = R.drawable.horno,
            resourceTint = null,
            cardBackground = Color.Unspecified,
            urlImagePromo = "",
            imagePromoVisible = true,
        ),
        GSVCProductImageCardImageModel(
            urlImage = "",
            imageResource = R.drawable.horno,
            resourceTint = null,
            cardBackground = Color.Unspecified,
            urlImagePromo = "",
            imagePromoVisible = true,
        ),
    )
    val prices = mutableListOf(
        GSVCProductImageCardPriceModel(
            amountDiscount = 1000,
            hasDiscount = true,
            lineaCredito = "Baz",
            availableCredit = true,
            regularPrice = "25999",
            finalPrice = "24999",
        ),
        GSVCProductImageCardPriceModel(
            amountDiscount = 1000,
            hasDiscount = true,
            lineaCredito = "Baz",
            availableCredit = true,
            regularPrice = "25999",
            finalPrice = "24999",
        ),
        GSVCProductImageCardPriceModel(
            amountDiscount = 1000,
            hasDiscount = true,
            lineaCredito = "Baz",
            availableCredit = true,
            regularPrice = "25999",
            finalPrice = "24999",
        ),
        GSVCProductImageCardPriceModel(
            amountDiscount = 1000,
            hasDiscount = true,
            lineaCredito = "Baz",
            availableCredit = true,
            regularPrice = "25999",
            finalPrice = "24999",
        ),
        GSVCProductImageCardPriceModel(
            amountDiscount = 1000,
            hasDiscount = true,
            lineaCredito = "Baz",
            availableCredit = true,
            regularPrice = "25999",
            finalPrice = "24999",
        ),
        GSVCProductImageCardPriceModel(
            amountDiscount = 1000,
            hasDiscount = true,
            lineaCredito = "Baz",
            availableCredit = true,
            regularPrice = "25999",
            finalPrice = "24999",
        ),
        GSVCProductImageCardPriceModel(
            amountDiscount = 1000,
            hasDiscount = true,
            lineaCredito = "Baz",
            availableCredit = true,
            regularPrice = "25999",
            finalPrice = "24999",
        ),

    )

    val payments = mutableListOf(
        GSVCProductImageCardPaymentModel(
            percentDiscount = 25,
            weeklyPayment = "600",
            regularPrice = "32000",
            bazTexto = texto,
        ),
        GSVCProductImageCardPaymentModel(
            percentDiscount = 25,
            weeklyPayment = "540",
            regularPrice = "25999",
            bazTexto = texto,
        ),
        GSVCProductImageCardPaymentModel(
            percentDiscount = 25,
            weeklyPayment = "150",
            regularPrice = "5000",
            bazTexto = texto,
        ),
        GSVCProductImageCardPaymentModel(
            percentDiscount = 25,
            weeklyPayment = "150",
            regularPrice = "5000",
            bazTexto = texto,
        ),
        GSVCProductImageCardPaymentModel(
            percentDiscount = 25,
            weeklyPayment = "150",
            regularPrice = "5000",
            bazTexto = texto,
        ),
        GSVCProductImageCardPaymentModel(
            percentDiscount = 25,
            weeklyPayment = "150",
            regularPrice = "5000",
            bazTexto = texto,
        ),
        GSVCProductImageCardPaymentModel(
            percentDiscount = 25,
            weeklyPayment = "150",
            regularPrice = "5000",
            bazTexto = texto,
        ),
        GSVCProductImageCardPaymentModel(
            percentDiscount = 25,
            weeklyPayment = "150",
            regularPrice = "5000",
            bazTexto = texto,
        ),
    )

    val descriptions = mutableListOf(
        "iPhone 14 PRo 128 GB Libre Oro",
        "Motocicleta Italika Mod. 125 Blanco Negro",
        "Horno Freidor Aire DPS100",
        "",
    )

    val productCards = mutableListOf<GSVCProductImageCardModel>()

    products.forEachIndexed { index, _ ->
        productCards.add(
            GSVCProductImageCardModel(
                gsvcProductImageCardImageModel = products[index],
                gsvcProductImageCardPaymentModel = payments[index],
                gsvcProductImageCardPriceModel = prices[index],
                productDescription = descriptions[index],
                onCardClick = { onCardClick(context) },
                freeShip = true,
                shipAmount = 120,
                type = GSVCProductImageCardModel.Type.Products,
            ),
        )
    }

    LazyRow(
        modifier = Modifier
            .padding(4.dp),
    ) {
        item {
            productCards.forEachIndexed { _, item ->
                Box(
                    modifier = Modifier.padding(4.dp),
                ) {
                    GSVCProductImageCard(item)
                }
            }
        }
    }
}*/

fun onCardClick(context: Context) {
    Toast.makeText(context, "Card Clicked", Toast.LENGTH_SHORT).show()
}
