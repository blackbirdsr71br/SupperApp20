package com.alex.dashboarddemo.presentation.common.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alex.dashboarddemo.R
import com.alex.dashboarddemo.presentation.common.model.GSDAHeaderModel
import com.alex.dashboarddemo.ui.theme.SDAColor.GSVCHeaderColor

@Composable
fun GSSAHeader(
    headerModel: GSDAHeaderModel,
) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.densityDpi
    val topHeaderHeight = screenDensity(screenHeight = screenHeight)
    Column(
        modifier = Modifier
            .background(GSVCHeaderColor)
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(topHeaderHeight.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Box {
                Text(
                    text = "baz",
                    color = Color.White,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                )
            }

            Box {
                Row {
                    GSDAButtonWithIcon()
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(
                        shape = RoundedCornerShape(4.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White,
                        ),
                        onClick = { /*TODO*/ },
                    ) {
                        Image(
                            painterResource(id = R.drawable.baz_logo),
                            contentDescription = "Cart button icon",
                            modifier = Modifier.size(20.dp),
                        )
                    }
                }
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .height(35.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = "Juan, ¿qué estás buscando?",
                fontSize = 16.sp,

            )
        }
    }
}

@Composable
fun screenDensity(screenHeight: Int): Int {
    var topHeaderHeight = 0
    when (screenHeight) {
        in 200..300 -> topHeaderHeight = 62
        in 301..500 -> topHeaderHeight = 72
        in 501..650 -> topHeaderHeight = 72
    }
    return topHeaderHeight
}

@Preview(showBackground = true)
@Composable
fun GSDAHeaderPreview() {
    val headerModelPreview = GSDAHeaderModel(
        name = "Andrea",
        points = "200",
        rewardsIndicator = true,
        notificationsIndicator = true,
        urlProfile = R.drawable.baz_logo,
        urlNotification = R.drawable.baseline_notifications_24,
        urlRewards = R.drawable.ic_gema,
    )

    GSSAHeader(headerModel = headerModelPreview)
}

@Composable
fun GSDAButtonWithIcon() {
    Button(
        shape = RoundedCornerShape(4.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White,
        ),
        onClick = {},
    ) {
        Image(
            painterResource(id = R.drawable.baz_logo),
            contentDescription = "Cart button icon",
            modifier = Modifier.size(20.dp),
        )

        Text(
            text = "Banco Azteca",
            Modifier.padding(start = 10.dp),
            color = Color.Black,
        )
    }
}
