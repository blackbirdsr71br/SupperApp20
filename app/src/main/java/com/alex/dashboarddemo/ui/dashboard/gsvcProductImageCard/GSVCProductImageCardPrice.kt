package com.alex.dashboarddemo.ui.dashboard.gsvcProductImageCard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alex.dashboarddemo.ui.theme.GSVCBlack
import com.alex.dashboarddemo.ui.theme.GSVCNewsGray
import com.alex.dashboarddemo.ui.theme.GSVCText200
import com.alex.dashboarddemo.ui.theme.poppinsFamily

@Composable
fun GSVCProductImageCardPrice(
    gsvcProductImageCardPriceModel: GSVCProductImageCardPriceModel,
) {
    // val discountAmount = product.deal?.categorias?.productos?.get(0)?.montoDescuento ?: 0

    if (gsvcProductImageCardPriceModel.hasDiscount && gsvcProductImageCardPriceModel.amountDiscount > 0) {
        if (!gsvcProductImageCardPriceModel.lineaCredito.isNullOrBlank() && gsvcProductImageCardPriceModel.availableCredit
        ) {
            Column {
                Text(
                    modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 1.dp),
                    text = buildAnnotatedString {
                        if (!gsvcProductImageCardPriceModel.regularPrice.isBlank()) {
                            withStyle(
                                style = SpanStyle(
                                    color = GSVCNewsGray,
                                    fontFamily = poppinsFamily,
                                    fontWeight = FontWeight.Medium,
                                    fontSize = 12.sp,
                                ),
                            ) {
                                append("$")
                            }
                            withStyle(
                                style = SpanStyle(
                                    color = GSVCNewsGray,
                                    fontFamily = poppinsFamily,
                                    fontWeight = FontWeight.Medium,
                                    textDecoration = TextDecoration.LineThrough,
                                    fontSize = 12.sp,
                                ),
                            ) {
                                append(gsvcProductImageCardPriceModel.regularPrice.asDecimal() + "   ")
                            }
                        }
                        withStyle(
                            style = SpanStyle(
                                color = Color.Black,
                                fontFamily = poppinsFamily,
                                fontWeight = FontWeight.Normal,
                                fontSize = 12.sp,
                            ),
                        ) {
                            append(gsvcProductImageCardPriceModel.finalPrice.asPrice())
                        }
                    },
                )
                /*Text(
                    modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 1.dp),
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                color = GSVCNewsGray,
                                fontFamily = poppinsFamily,
                                fontWeight = FontWeight.Medium,
                                fontSize = 12.sp,
                            ),
                        ) {
                            append("$")
                        }
                        withStyle(
                            style = SpanStyle(
                                color = GSVCBlack,
                                fontFamily = poppinsFamily,
                                fontWeight = FontWeight.Medium,
                                fontSize = 12.sp,
                            ),
                        ) {
                            append(gsvcProductImageCardPriceModel.regularPrice.asDecimal() + "   ")
                        }
                    },
                )*/
                val amtdiscount = gsvcProductImageCardPriceModel.amountDiscount
                /*Text(
                    text = "Ahorras $amtdiscount",
                    color = GSVCText200,
                    fontFamily = poppinsFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 0.dp),
                )*/
            }
        } else {
            Text(
                modifier = Modifier.padding(0.dp, 0.dp, 8.dp, 0.dp),
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = GSVCNewsGray,
                            fontFamily = poppinsFamily,
                            fontWeight = FontWeight.Medium,
                            fontSize = 12.sp,
                        ),
                    ) {
                        append("$")
                    }
                    withStyle(
                        style = SpanStyle(
                            color = GSVCNewsGray,
                            fontFamily = poppinsFamily,
                            fontWeight = FontWeight.Medium,
                            textDecoration = TextDecoration.LineThrough,
                            fontSize = 12.sp,
                        ),
                    ) {
                        append(gsvcProductImageCardPriceModel.regularPrice.asDecimal())
                    }

                    withStyle(
                        style = SpanStyle(
                            color = GSVCNewsGray,
                            fontFamily = poppinsFamily,
                            fontWeight = FontWeight.Medium,
                            fontSize = 12.sp,
                        ),
                    ) {
                        append(" Ahorras $$gsvcProductImageCardPriceModel.amountDiscount")
                    }
                },
            )
        }
    } else {
        if (!gsvcProductImageCardPriceModel.lineaCredito.isNullOrBlank() && gsvcProductImageCardPriceModel.availableCredit
        ) {
            Column {
                Text(
                    text = "",
                    color = GSVCText200,
                    fontFamily = poppinsFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(8.dp, 0.dp, 0.dp, 0.dp),
                )
                Text(
                    text = gsvcProductImageCardPriceModel.finalPrice.asPrice(),
                    color = GSVCBlack,
                    fontFamily = poppinsFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 0.dp),
                )
            }
        } else {
            Text(
                text = "",
                color = GSVCText200,
                fontFamily = poppinsFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp,
                modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 0.dp),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GSVCProductPricePreview() {
    Column {
        GSVCProductImageCardPriceModel(
            amountDiscount = 1000,
            hasDiscount = true,
            lineaCredito = "Baz",
            availableCredit = true,
            regularPrice = "5999",
            finalPrice = "4999",

        ).apply {
            GSVCProductImageCardPrice(gsvcProductImageCardPriceModel = this)
        }
        Spacer(modifier = Modifier.height(32.dp))
        GSVCProductImageCardPriceModel(
            amountDiscount = 1000,
            hasDiscount = true,
            lineaCredito = "Baz",
            availableCredit = true,
            regularPrice = "",
            finalPrice = "4999",

        ).apply {
            GSVCProductImageCardPrice(gsvcProductImageCardPriceModel = this)
        }
    }
}
