package com.alex.dashboarddemo.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.alex.dashboarddemo.R

private val regular = Font(R.font.nunito_regular)
private val medium = Font(R.font.nunito_semibold, FontWeight.W600)
private val semibold = Font(R.font.nunito_bold, FontWeight.W700)

private val fontFamily = FontFamily(fonts = listOf(regular, medium, semibold))

val themeTypography = Typography(
    h4 = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.W700,
        fontSize = 30.sp,
    ),
    h5 = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.W600,
        fontSize = 24.sp,
    ),
    h6 = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.W700,
        fontSize = 20.sp,
    ),
    subtitle1 = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.W700,
        fontSize = 16.sp,
    ),
    subtitle2 = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.W600,
        fontSize = 14.sp,
    ),
    body1 = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
    ),
    body2 = TextStyle(
        fontFamily = fontFamily,
        fontSize = 14.sp,
    ),
    button = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.W600,
        fontSize = 14.sp,
    ),
    caption = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
    ),
    overline = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp,
    ),
)

object SDATypography {
    private val primary = FontFamily(
        Font(R.font.font_regular, FontWeight.Normal),
        Font(R.font.font_medium, FontWeight.Medium),
        Font(R.font.font_semibold, FontWeight.SemiBold),
        Font(R.font.font_bold, FontWeight.Bold),
    )

    val GSVCHero = TextStyle(
        fontFamily = primary,
        fontWeight = FontWeight.Medium,
        fontSize = 54.sp,
    )
    val GSVCSubhero = TextStyle(
        fontFamily = primary,
        fontWeight = FontWeight.SemiBold,
        fontSize = 30.sp,
    )
    val GSVCH1 = TextStyle(
        fontFamily = primary,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
    )
    val GSVCH2 = TextStyle(
        fontFamily = primary,
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp,
    )
    val GSVCH2Bold = TextStyle(
        fontFamily = primary,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
    )
    val GSVCH3 = TextStyle(
        fontFamily = primary,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
    )
    val GSVCH4 = TextStyle(
        fontFamily = primary,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
    )
    val GSVCBody = TextStyle(
        fontFamily = primary,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
    )
    val GSVCBodySemiBold = TextStyle(
        fontFamily = primary,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
    )
    val GSVCBodySmall = TextStyle(
        fontFamily = primary,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
    )
    val GSVCHelper = TextStyle(
        fontFamily = primary,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
    )
    val GSVCSubtitle = TextStyle(
        fontFamily = primary,
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp,
    )
    val GSVCSubtitleBold = TextStyle(
        fontFamily = primary,
        fontWeight = FontWeight.SemiBold,
        fontSize = 10.sp,
    )
    val GSVCInteractions = TextStyle(
        fontFamily = primary,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
    )
}
