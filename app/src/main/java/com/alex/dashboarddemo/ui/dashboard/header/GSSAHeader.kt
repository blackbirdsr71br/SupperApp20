package com.alex.dashboarddemo.ui.dashboard.header

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alex.dashboarddemo.R

@Composable
fun GSSAHeader(
    headerModel: GSDAHeaderModel,
) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.densityDpi
    val topHeaderHeight = screenDensity(screenHeight = screenHeight)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(topHeaderHeight.dp)
            .padding(start = 12.dp, end = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            GSSAHeaderProfile(headerModel = headerModel)
            Column(
                modifier = Modifier.padding(start = 16.dp),
            ) {
                Text(
                    text = textBoldHeader(name = headerModel.name),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
                Text(
                    text = textBoldHeader(points = headerModel.points),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            }
        }
        GSSAHeaderNotification(headerModel)
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

fun textBoldHeader(name: String = "", points: String = ""): AnnotatedString {
    return buildAnnotatedString {
        if (name.isNotEmpty()) append("Hola, ")
        withStyle(
            style = SpanStyle(fontWeight = FontWeight.Bold, color = Color.Black),
        ) {
            if (name.isNotEmpty()) append(name) else append(points)
        }
        if (points.isNotEmpty()) append(" puntos")
    }
}

fun textBold(name: String, focusWorlds: List<String>, fontSize: Int): AnnotatedString {
    return buildAnnotatedString {
        var counterIndex = 0
        var rangeFocusWordInitial: Int
        var rangeFocusWordEnd: Int
        name.forEachIndexed { index, character ->
            rangeFocusWordInitial =
                name.indexOf(focusWorlds[counterIndex])
            rangeFocusWordEnd =
                rangeFocusWordInitial + focusWorlds[counterIndex].length

            if (index in rangeFocusWordInitial until rangeFocusWordEnd) {
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        fontSize = fontSize.sp,
                    ),
                ) {
                    append(character.toString())
                }
            } else {
                withStyle(
                    style = SpanStyle(
                        fontSize = fontSize.sp,
                    ),
                ) {
                    append(character.toString())
                }
            }

            if (rangeFocusWordEnd == index) {
                if (counterIndex < focusWorlds.size - 1) {
                    counterIndex++
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GSSAHeaderPreview() {
    val headerModelPreview = GSDAHeaderModel(
        name = "Andrea",
        points = "200",
        rewardsIndicator = true,
        notificationsIndicator = true,
        urlProfile = R.drawable.personperfil,
        urlNotification = R.drawable.baseline_notifications_24,
        urlRewards = R.drawable.ic_gema,
    )

    GSSAHeader(headerModel = headerModelPreview)
}
