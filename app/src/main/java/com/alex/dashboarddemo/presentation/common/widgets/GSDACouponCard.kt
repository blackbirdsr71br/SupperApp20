package com.alex.dashboarddemo.presentation.common.widgets

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
import com.alex.dashboarddemo.presentation.common.components.GSDAInformativeBadge
import com.alex.dashboarddemo.presentation.common.components.GSDAProductCardPreviewDS
import com.alex.dashboarddemo.presentation.common.model.GSDABadgesPosition
import com.alex.dashboarddemo.presentation.common.model.GSDAInformativeBadgeModel
import com.alex.dashboarddemo.presentation.common.model.GSDACouponCardModel
import com.alex.dashboarddemo.ui.theme.GSDASpace
import com.alex.dashboarddemo.utils.charactersFormat

@Composable
fun GSDACouponCard(gsvcCouponCardModel: GSDACouponCardModel) {
    var roundedCornerShapeBadget by remember {
        mutableStateOf(RoundedCornerShape(0.dp, GSDASpace.GSVCSmall, 0.dp, GSDASpace.GSVCSmall))
    }
    var alignmentBadget by remember { mutableStateOf(Alignment.TopEnd) }
    if (gsvcCouponCardModel.badgesPosition == GSDABadgesPosition.LEFT) {
        roundedCornerShapeBadget =
            RoundedCornerShape(GSDASpace.GSVCSmall, 0.dp, GSDASpace.GSVCSmall, 0.dp)
        alignmentBadget = Alignment.TopStart
    } else {
        roundedCornerShapeBadget =
            RoundedCornerShape(0.dp, GSDASpace.GSVCSmall, 0.dp, GSDASpace.GSVCSmall)
        alignmentBadget = Alignment.TopEnd
    }
    val paddingBorderContainer by remember {
        mutableStateOf(
            gsvcCouponCardModel.containerBorderSize ?: 0.dp,
        )
    }
    val gsvcBadgesStatusModel by remember {
        mutableStateOf(
            GSDAInformativeBadgeModel(
                badgesStatusText = gsvcCouponCardModel.badgesStatusText.charactersFormat(10),
                textStyleBadgeStatus = gsvcCouponCardModel.badgesTextStyle,
                backgroundBadgesStatus = gsvcCouponCardModel.badgesBackgroundColor,
                roundedCornerShape = roundedCornerShapeBadget,
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
                    shape = RoundedCornerShape(GSDASpace.GSVCSmall),
                )
            } else {
                Modifier.background(
                    Color.Transparent,
                    shape = RoundedCornerShape(GSDASpace.GSVCSmall),
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
                    .clip(RoundedCornerShape(GSDASpace.GSVCSmall))
                    .then(modifierClickable),

            ) {
                Box(
                    modifier = gsvcCouponCardModel.modifier
                        .clip(RoundedCornerShape(GSDASpace.GSVCSmall))
                        .background(gsvcCouponCardModel.backgroundContent)
                        .padding(paddingContent),
                ) {
                    gsvcCouponCardModel.content.invoke()
                }
                Box(
                    modifier = Modifier
                        .align(alignment = alignmentBadget),
                ) {
                    GSDAInformativeBadge(badgesModel = gsvcBadgesStatusModel)
                }
            }
            Spacer(modifier = Modifier.width(paddingBorderContainer))
        }
        Spacer(modifier = Modifier.height(paddingBorderContainer))
    }
}

@Preview(showSystemUi = true, backgroundColor = 0xF9F9F9)
@Composable
fun GSDACouponCardPreview() {
    val gsvcCouponCardModel = GSDACouponCardModel(
        badgesStatusText = "Nuevo Elemento",
        badgesBackgroundColor = Color.Red,
        backgroundContent = Color.LightGray,
        badgesPosition = GSDABadgesPosition.LEFT,
        modifier = Modifier,
    ) {
        GSDAProductCardPreviewDS()
    }
    GSDACouponCard(gsvcCouponCardModel)
}
