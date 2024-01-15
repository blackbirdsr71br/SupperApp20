package com.baz.democouponcard.gsvcCouponCard

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alex.dashboarddemo.presentation.dashboard.badges.gsvcBadgeStatus.GSVCBadgesStatus
import com.alex.dashboarddemo.presentation.dashboard.badges.gsvcBadgeStatus.GSVCBadgesStatusModel
import com.alex.dashboarddemo.presentation.dashboard.gsvcCouponCard.BadgesPosition
import com.alex.dashboarddemo.presentation.dashboard.gsvcCouponCard.GSVCCouponCardModel
import com.alex.dashboarddemo.presentation.dashboard.gsvcCouponCard.charactersFormat
import com.alex.dashboarddemo.presentation.dashboard.gsvcProductCard.ProductCardPreviewDS
import com.example.basedemomaterial3.ui.theme.SDASpace

@Composable
fun GSVCCouponCard(gsvcCouponCardModel : GSVCCouponCardModel) {
    var roundedCornerShapeBadget by remember {
        mutableStateOf(RoundedCornerShape(0.dp, SDASpace.GSVCSmall, 0.dp, SDASpace.GSVCSmall))
    }
    var alignmentBadget by remember { mutableStateOf(Alignment.TopEnd) }
    if (gsvcCouponCardModel.badgesPosition == BadgesPosition.LEFT) {
        roundedCornerShapeBadget =
            RoundedCornerShape(SDASpace.GSVCSmall, 0.dp, SDASpace.GSVCSmall, 0.dp)
        alignmentBadget = Alignment.TopStart
    } else {
        roundedCornerShapeBadget =
            RoundedCornerShape(0.dp, SDASpace.GSVCSmall, 0.dp, SDASpace.GSVCSmall)
        alignmentBadget = Alignment.TopEnd
    }
    val paddingBorderContainer by remember {
        mutableStateOf(
            gsvcCouponCardModel.containerBorderSize ?: 0.dp,
        )
    }
    val gsvcBadgesStatusModel by remember {
        mutableStateOf(
            GSVCBadgesStatusModel(
                badgesStatusText = gsvcCouponCardModel.badgesStatusText.charactersFormat(10),
                textStyleBadgeStatus = gsvcCouponCardModel.badgesTextStyle,
                backgroundBadgesStatus = gsvcCouponCardModel.badgesBackgroundColor,
                roundedCornerShape = roundedCornerShapeBadget,
                modifier = Modifier.height(24.dp),
            ),
        )
    }
    val modifierClickable by remember {
        mutableStateOf(
            if (gsvcCouponCardModel.onClickCardEvent != null) {
                Modifier.clickable { gsvcCouponCardModel.onClickCardEvent.invoke() }
            } else {
                Modifier
            },
        )
    }
    val contairnerBorderModifier by remember {
        mutableStateOf(
            if (gsvcCouponCardModel.containerBorderSize != null) {
                Modifier.background(
                    gsvcCouponCardModel.containerBorderColor,
                    shape = RoundedCornerShape(SDASpace.GSVCSmall),
                )
            } else {
                Modifier.background(
                    Color.Transparent,
                    shape = RoundedCornerShape(SDASpace.GSVCSmall),
                )
            },
        )
    }
    val paddingContent by remember {
        mutableStateOf(
            gsvcCouponCardModel.paddingContent ?: PaddingValues(
                horizontal = 0.dp,
                vertical = 0.dp,
            ),
        )
    }

    Column(
        modifier = Modifier
            .wrapContentSize()
            .then(contairnerBorderModifier),
    ) {
        Spacer(modifier = Modifier.height(paddingBorderContainer))
        Row {
            Spacer(modifier = Modifier.width(paddingBorderContainer))
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(SDASpace.GSVCSmall))
                    .then(modifierClickable),

                ) {
                Box(
                    modifier = gsvcCouponCardModel.modifier
                        .clip(RoundedCornerShape(SDASpace.GSVCSmall))
                        .background(gsvcCouponCardModel.backgroundContent)
                        .padding(paddingContent),
                ) {
                    gsvcCouponCardModel.content.invoke()
                }
                Box(
                    modifier = Modifier
                        .align(alignment = alignmentBadget),
                ) {
                    GSVCBadgesStatus(gsvcBadgesStatusModel = gsvcBadgesStatusModel)
                }
            }
            Spacer(modifier = Modifier.width(paddingBorderContainer))
        }
        Spacer(modifier = Modifier.height(paddingBorderContainer))
    }
}

@Preview(showSystemUi = true, backgroundColor = 0xF9F9F9)
@Composable
fun GSVCCouponCardPreview() {
    val gsvcCouponCardModel = GSVCCouponCardModel(
        badgesStatusText = "Nuevo Elemento",
        badgesBackgroundColor = Color.Red,
        backgroundContent = Color.LightGray,
        badgesPosition = BadgesPosition.LEFT,
        modifier = Modifier
    ) {
        ProductCardPreviewDS()
    }
    GSVCCouponCard(gsvcCouponCardModel)
}
