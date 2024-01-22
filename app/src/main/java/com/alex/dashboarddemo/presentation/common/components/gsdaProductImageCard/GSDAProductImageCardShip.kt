package com.alex.dashboarddemo.presentation.common.components.gsdaProductImageCard

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alex.dashboarddemo.ui.theme.GSVCAlert100
import com.alex.dashboarddemo.ui.theme.GSVCText200
import com.alex.dashboarddemo.ui.theme.poppinsFamily
import com.alex.dashboarddemo.utils.asPrice

@Composable
fun GSDAProductImageCardShip(
    freeShip: Boolean,
    shipAmount: Int?,
) {
    if (freeShip) {
        Text(
            text = "Envio gratis",
            color = GSVCAlert100,
            fontFamily = poppinsFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 0.dp),
        )
    } else if (shipAmount != null) {
        if (shipAmount > 0) {
            Text(
                text = "Envio " + shipAmount.toString().asPrice(),
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
fun GSDAProductShippingPreview() {
    GSDAProductImageCardShip(
        freeShip = true,
        shipAmount = 1200,
    )
}
