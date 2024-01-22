package com.alex.dashboarddemo.presentation.common.components.gsdaProductImageCard

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alex.dashboarddemo.presentation.common.model.GSDAProductImageCardPaymentModel
import com.alex.dashboarddemo.ui.theme.GSVCBlack
import com.alex.dashboarddemo.ui.theme.GSVCNewsGray
import com.alex.dashboarddemo.ui.theme.h5
import com.alex.dashboarddemo.ui.theme.subtitle1
import com.alex.dashboarddemo.utils.asPrice

@Composable
fun GSDAProductImageCardPayment(
    gsvcProductImageCardPaymentModel: GSDAProductImageCardPaymentModel,
) {
    Column {
        Text(
            text = if (gsvcProductImageCardPaymentModel.percentDiscount != 0) {
                gsvcProductImageCardPaymentModel.weeklyPayment.asPrice()
            } else {
                gsvcProductImageCardPaymentModel.regularPrice.asPrice()
            },
            color = GSVCBlack,
            style = h5,
            textAlign = TextAlign.Center,
            fontSize = 23.sp,
            lineHeight = 0.sp,
        )
        Column(
            modifier = Modifier
                .padding(start = 4.dp),
            verticalArrangement = Arrangement.Center,
        ) {
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = gsvcProductImageCardPaymentModel.bazText,
                color = GSVCNewsGray,
                lineHeight = 10.sp,
                style = subtitle1,
                modifier = Modifier.offset(0.dp, ((-8).dp)),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GSDAPaymentPreview() {
    val productPayment = GSDAProductImageCardPaymentModel(
        percentDiscount = 25,
        weeklyPayment = "540",
        regularPrice = "25999",
        bazText = mText,
    )
    GSDAProductImageCardPayment(
        gsvcProductImageCardPaymentModel = productPayment,
    )
}
