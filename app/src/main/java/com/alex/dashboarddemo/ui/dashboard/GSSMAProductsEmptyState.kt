package com.alex.dashboarddemo.ui.dashboard

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alex.dashboarddemo.R
import com.alex.dashboarddemo.ui.theme.GSVCPrimary100
import com.alex.dashboarddemo.ui.theme.SDAColor.GSVCInteractions
import com.alex.dashboarddemo.ui.theme.SDAColor.GSVCPrimary
import com.alex.dashboarddemo.ui.theme.SDAColor.GSVCTypography
import com.alex.dashboarddemo.ui.theme.poppinsFamily

@Composable
fun GSSMAProductsEmptyState(
    noInternetConnection : Boolean = false,

    ) {
    // val activity = LocalContext.current as Activity

    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(color = GSVCPrimary)
            .padding(8.dp),
    ) {
        Image(
            painter = painterResource(
                id =
                if (noInternetConnection) {
                    R.drawable.ic_empty_state_plp
                } else {
                    R.drawable.gsmp_ic_connection_error
                },
            ),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .padding(vertical = 10.dp)
                .wrapContentWidth()
                .wrapContentHeight(),
        )

        Text(
            modifier = Modifier.padding(vertical = 20.dp),
            text = stringResource(
                if (noInternetConnection) {
                    R.string.gssma_check_yout_connection
                } else {
                    R.string.gssma_try_again
                },
            ),
            style = TextStyle(
                fontFamily = poppinsFamily,
                fontWeight = FontWeight.W400,
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
                color = GSVCTypography,
            ),
            lineHeight = 21.sp,
        )

        Row(
            modifier = Modifier
                .clickable {
                    if (noInternetConnection) {
                        //.invoke(GSSMAPLPIntent.GetMoreProducts(1))
                    } else {
                        //sendIntent.invoke(GSSMAPLPIntent.ExitScreen(activity))
                    }
                },
        ) {

            Icon(
                painter = painterResource(
                    id =
                    R.drawable.gsmp_ic_reintentar,
                ),
                tint = GSVCPrimary100,
                contentDescription = null,
                modifier = Modifier
                    .padding(end = 5.dp, top = 8.dp)
                    .wrapContentWidth()
                    .wrapContentHeight(),
            )
            
            Text(
                modifier = Modifier.padding(vertical = 10.dp),
                text = stringResource(
                    if (noInternetConnection) {
                        R.string.gssma_retry
                    } else {
                        R.string.gssma_retry
                    },
                ),
                style = TextStyle(
                    fontFamily = poppinsFamily,
                    fontWeight = FontWeight.W600,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center,
                    color = GSVCInteractions,
                ),
                lineHeight = 21.sp,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ErrorPreview() {
    GSSMAProductsEmptyState()
}
