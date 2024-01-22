package com.alex.dashboarddemo.presentation.common.components.builder

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alex.dashboarddemo.R
import com.alex.dashboarddemo.presentation.common.components.GSDAInformativeBadge
import com.alex.dashboarddemo.presentation.common.components.gsdaProductImageCard.GSDAProductImageCardImage
import com.alex.dashboarddemo.presentation.common.components.gsdaProductImageCard.GSDAProductImageCardPrice
import com.alex.dashboarddemo.presentation.common.components.gsdaProductImageCard.GSDAProductImageDescription
import com.alex.dashboarddemo.presentation.common.components.gsdaProductImageCard.GSDAPaymentPreview
import com.alex.dashboarddemo.presentation.common.model.GSDAInformativeBadgeModel
import com.alex.dashboarddemo.presentation.common.model.GSDAProductImageCardImageModel
import com.alex.dashboarddemo.presentation.common.model.GSDAProductImageCardPriceModel
import com.alex.dashboarddemo.ui.theme.h5

@Composable
fun GSDAProductCard(
    modifier: Modifier = Modifier,
    imageSlot: @Composable () -> Unit = {},
    descriptionSlot: @Composable () -> Unit = {},
    priceSlot: @Composable () -> Unit = {},
    weeklySlot: @Composable () -> Unit = {},
    offerSlot: @Composable () -> Unit = {},
) {
    Card(
        modifier = modifier
            .clickable { }
            .width(170.dp)
            .height(305.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = 5.dp,
    ) {
        Column(
            modifier = Modifier
                .height(intrinsicSize = IntrinsicSize.Max)
                .clip(shape = RoundedCornerShape(10.dp)),
        ) {
            imageSlot()
            descriptionSlot()
            priceSlot()
            weeklySlot()
        }
        offerSlot()
    }
}

@Preview(showBackground = true, backgroundColor = 0x00000000)
@Composable
fun GSDAProductCardPreview() {
    GSDAProductCard(
        modifier = Modifier
            .wrapContentSize(),
        imageSlot = {
            Column(
                modifier = Modifier.fillMaxWidth(),
            ) {
                GSDAProductImageCardImageModel(
                    urlImage = R.drawable.telefono,
                    imageResource = R.drawable.estufa,
                    imagePromoVisible = true,
                ).apply {
                    GSDAProductImageCardImage(
                        gsvcProductImageCardImageModel = this,
                    )
                }
            }
        },
        descriptionSlot = {
            Column(
                modifier = Modifier.padding(start = 8.dp),
            ) {
                GSDAProductImageDescription(
                    imgUrl = R.drawable.baz_logo,
                    txtMaker = "Spring Air",
                    productDescription = "Motocicleta Italika Mod. 125 Blanco Negro",
                )
            }
        },
        priceSlot = {
            Column(
                modifier = Modifier.padding(start = 8.dp),
            ) {
                GSDAProductImageCardPriceModel(
                    amountDiscount = 1000,
                    hasDiscount = true,
                    lineaCredito = "Baz",
                    availableCredit = true,
                    regularPrice = "5999",
                    finalPrice = "4999",

                ).apply {
                    GSDAProductImageCardPrice(gsvcProductImageCardPriceModel = this)
                }
            }
        },
        weeklySlot = {
            Column(
                modifier = Modifier.padding(start = 8.dp),
            ) {
                GSDAPaymentPreview()
            }
        },
        offerSlot = {
            GSDAInformativeBadgeModel(
                badgesStatusText = "Oferta",
                backgroundBadgesStatus = Color(0xFFAA0404),
                textStyleBadgeStatus = h5,
                roundedCornerShape = RoundedCornerShape(8.dp, 0.dp, 8.dp, 0.dp),
            ).apply { GSDAInformativeBadge(this) }
        },
    )
}
