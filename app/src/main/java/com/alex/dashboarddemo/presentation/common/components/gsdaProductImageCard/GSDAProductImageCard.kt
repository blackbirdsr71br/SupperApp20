package com.alex.dashboarddemo.presentation.common.components.gsdaProductImageCard

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
import com.alex.dashboarddemo.presentation.common.model.GSDAProductImageCardImageModel
import com.alex.dashboarddemo.presentation.common.model.GSDAProductImageCardModel
import com.alex.dashboarddemo.presentation.common.model.GSDAProductImageCardPaymentModel
import com.alex.dashboarddemo.presentation.common.model.GSDAProductImageCardPriceModel
import com.alex.dashboarddemo.ui.theme.GSVCBlack
import com.alex.dashboarddemo.ui.theme.GSVCPrimary100
import com.alex.dashboarddemo.ui.theme.GSVCPurple
import com.alex.dashboarddemo.ui.theme.GSVCTextPurple
import com.alex.dashboarddemo.ui.theme.subtitle1

val mText = buildAnnotatedString {
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
fun GSDAProductImageCard(
    gsvcProductImageCardModel: GSDAProductImageCardModel? = null,
) {
    if (gsvcProductImageCardModel != null) {
        with(gsvcProductImageCardModel) {
            when (gsvcProductImageCardModel.type) {
                is GSDAProductImageCardModel.Type.Products -> {
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
                                GSDAProductImageCardImage(
                                    gsvcProductImageCardImageModel = gsvcProductImageCardImageModel,
                                )
                            }
                            GSDAProductImageDescription(
                                imgUrl = imgUrl,
                                txtMaker = txtMaker,
                                productDescription = productDescription,
                            )
                            if (gsvcProductImageCardPriceModel != null) {
                                GSDAProductImageCardPrice(
                                    gsvcProductImageCardPriceModel = gsvcProductImageCardPriceModel,
                                )
                            }
                            if (gsvcProductImageCardPaymentModel?.percentDiscount != 0) {
                                if (gsvcProductImageCardPaymentModel != null) {
                                    GSDAProductImageCardPayment(
                                        gsvcProductImageCardPaymentModel = gsvcProductImageCardPaymentModel,
                                    )
                                }
                            }
                        }
                    }
                }

                is GSDAProductImageCardModel.Type.Store -> {
                    GSDAProductShopCard(onCardClick = { onCardClick?.invoke() })
                }
            }
        }
    }
}

@Composable
fun GSDAProductImageDescription(
    imgUrl: Any,
    txtMaker: String,
    productDescription: String = "",
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        AsyncImage(
            modifier = Modifier.size(24.dp),
            model = imgUrl,
            contentDescription = null,
            alignment = Alignment.CenterStart,
            contentScale = ContentScale.Fit,
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = txtMaker,
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
private fun GSDAProductShopCard(
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
fun GSDAImageCardResourcePreview() {
    GSDAProductImageCardModel(
        type = GSDAProductImageCardModel.Type.Store,
    ).apply {
        GSDAProductImageCard(gsvcProductImageCardModel = this)
    }
}

@Preview(showBackground = true, backgroundColor = 0x00000000)
@Composable
fun GSDAProductImageCardPicturePreview() {
    val context = LocalContext.current

    val productImage = GSDAProductImageCardImageModel(
        urlImage = "",
        imageResource = R.drawable.moto,
        resourceTint = null,
        cardBackground = Color.Unspecified,
        urlImagePromo = "",
        imagePromoVisible = true,
    )
    val productPrice = GSDAProductImageCardPriceModel(
        amountDiscount = 1000,
        hasDiscount = true,
        lineaCredito = "Baz",
        availableCredit = true,
        regularPrice = "25999",
        finalPrice = "24999",
    )
    val productPayment = GSDAProductImageCardPaymentModel(
        percentDiscount = 25,
        weeklyPayment = "540",
        regularPrice = "25999",
        bazText = mText,
    )

    GSDAProductImageCardModel(
        productDescription = "Motocicleta Italika Mod. 125 Blanco Negro",
        onCardClick = { onCardClick(context) },
        freeShip = true,
        shipAmount = 120,
        type = GSDAProductImageCardModel.Type.Products,
        gsvcProductImageCardImageModel = productImage,
        gsvcProductImageCardPriceModel = productPrice,
        gsvcProductImageCardPaymentModel = productPayment,
    ).apply {
        GSDAProductImageCard(gsvcProductImageCardModel = this)
    }
}

@Preview(showBackground = true, backgroundColor = 0x00000000)
@Composable
fun GSDAProductImageCardPictureSlashed() {
    val context = LocalContext.current

    val productImage = GSDAProductImageCardImageModel(
        urlImage = "",
        imageResource = R.drawable.moto,
        resourceTint = null,
        cardBackground = Color.Unspecified,
        urlImagePromo = "",
        imagePromoVisible = true,
    )
    val productPrice = GSDAProductImageCardPriceModel(
        amountDiscount = 1000,
        hasDiscount = true,
        lineaCredito = "Baz",
        availableCredit = true,
        regularPrice = "",
        finalPrice = "24999",
    )
    val productPayment = GSDAProductImageCardPaymentModel(
        percentDiscount = 25,
        weeklyPayment = "540",
        regularPrice = "25999",
        bazText = mText,
    )

    GSDAProductImageCardModel(
        productDescription = "Motocicleta Italika Mod. 125 Blanco Negro",
        onCardClick = { onCardClick(context) },
        freeShip = true,
        shipAmount = 120,
        type = GSDAProductImageCardModel.Type.Products,
        gsvcProductImageCardImageModel = productImage,
        gsvcProductImageCardPriceModel = productPrice,
        gsvcProductImageCardPaymentModel = productPayment,
    ).apply {
        GSDAProductImageCard(gsvcProductImageCardModel = this)
    }
}

fun onCardClick(context: Context) {
    Toast.makeText(context, "Card Clicked", Toast.LENGTH_SHORT).show()
}
