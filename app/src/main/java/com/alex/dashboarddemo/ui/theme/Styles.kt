package com.alex.dashboarddemo.ui.themeimport androidx.compose.ui.graphics.Colorimport androidx.compose.ui.text.TextStyleimport androidx.compose.ui.text.font.Fontimport androidx.compose.ui.text.font.FontFamilyimport androidx.compose.ui.text.font.FontWeightimport androidx.compose.ui.text.style.TextAlignimport androidx.compose.ui.unit.spimport com.alex.dashboarddemo.Rval poppinsFamily = FontFamily(    Font(R.font.font_regular, FontWeight.Normal),    Font(R.font.font_medium, FontWeight.Medium),    Font(R.font.font_semibold, FontWeight.SemiBold),    Font(R.font.font_bold, FontWeight.Bold),)val subtitle = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Normal,    fontSize = 10.sp,    textAlign = TextAlign.Left,    color = Color.LightGray,)val helperTextAlertLeft = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Bold,    fontSize = 12.sp,    textAlign = TextAlign.Start,    color = Color(0xFFff9500),)val helperText1DarkLeft = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Normal,    fontSize = 12.sp,    textAlign = TextAlign.Start,    color = GSVCBlack,)val helperText200Left = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Normal,    fontSize = 12.sp,    textAlign = TextAlign.Start,    color = GSVCNewsGray,)val body1GrayLeft = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Normal,    fontSize = 16.sp,    textAlign = TextAlign.Start,    color = GSVCNewsGray,)val helperTextText100Left = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Bold,    fontSize = 12.sp,    textAlign = TextAlign.Start,    color = Color(0xFF222e41),)val helperTextLilaCenter = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Medium,    fontSize = 14.sp,    textAlign = TextAlign.Center,    color = GSVCSecondary100,)val helperTextText100Center = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Medium,    fontSize = 12.sp,    textAlign = TextAlign.Center,    color = Color(0xFF222e41),)val helperText2Text100Left = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Medium,    fontSize = 12.sp,    textAlign = TextAlign.Start,    color = GSVCBlack,)val helperTextText200Left = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Medium,    fontSize = 10.sp,    textAlign = TextAlign.Start,    color = Color(0xFFff00be),)val body1 = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Normal,    fontSize = 12.sp,)val body2Text100Center = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Medium,    fontSize = 16.sp,    textAlign = TextAlign.Center,    color = GSVCText100,)val body2Text100Left = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Medium,    fontSize = 16.sp,    textAlign = TextAlign.Start,    color = GSVCText100,)val body4CenterText100 = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Medium,    fontSize = 14.sp,    textAlign = TextAlign.Center,    color = GSVCText100,)val subtitle1 = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Medium,    fontSize = 10.sp,)val subtitle1Text100Left = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Medium,    fontSize = 20.sp,    textAlign = TextAlign.Left,    color = GSVCBlack,)val ctaCenter = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Medium,    fontSize = 14.sp,    textAlign = TextAlign.Center,    color = GSVCNewsGray,)val h4 = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Bold,    fontSize = 12.sp,)val h5 = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Normal,    fontSize = 12.sp,)val GSVCAmountText100Left = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Medium,    fontSize = 54.sp,    color = GSVCText100,    textAlign = TextAlign.Start,)val GSVCAmountText100Center = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Medium,    fontSize = 54.sp,    color = GSVCText100,    textAlign = TextAlign.Center,)val GSVCAmountText100Right = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Medium,    fontSize = 54.sp,    color = GSVCText100,    textAlign = TextAlign.End,)val GSVCAmountText200Left = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Medium,    fontSize = 54.sp,    color = GSVCText200,    textAlign = TextAlign.Start,)val GSVCAmountText200Center = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Medium,    fontSize = 54.sp,    color = GSVCText200,    textAlign = TextAlign.Center,)val GSVCAmountText200Right = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Medium,    fontSize = 54.sp,    color = GSVCText200,    textAlign = TextAlign.End,)val GSVCAmountBase100Left = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Medium,    fontSize = 54.sp,    color = GSVCBase100,    textAlign = TextAlign.Start,)val GSVCAmountBase100Center = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Medium,    fontSize = 54.sp,    color = GSVCBase100,    textAlign = TextAlign.Center,)val GSVCAmountBase100Right = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Medium,    fontSize = 54.sp,    color = GSVCBase100,    textAlign = TextAlign.End,)val GSVCBalanceText100Left = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Medium,    fontSize = 36.sp,    color = GSVCText100,    textAlign = TextAlign.Start,)val GSVCBalanceText100Center = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Medium,    fontSize = 36.sp,    color = GSVCText100,    textAlign = TextAlign.Center,)val GSVCBalanceText100Right = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Medium,    fontSize = 36.sp,    color = GSVCText100,    textAlign = TextAlign.End,)val GSVCBalanceText200Left = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Medium,    fontSize = 36.sp,    color = GSVCText200,    textAlign = TextAlign.Start,)val GSVCBalanceText200Center = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Medium,    fontSize = 36.sp,    color = GSVCText200,    textAlign = TextAlign.Center,)val GSVCBalanceText200Right = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Medium,    fontSize = 36.sp,    color = GSVCText200,    textAlign = TextAlign.End,)val GSVCBalanceBase100Left = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Medium,    fontSize = 36.sp,    color = GSVCBase100,    textAlign = TextAlign.Start,)val GSVCBalanceBase100Center = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Medium,    fontSize = 36.sp,    color = GSVCBase100,    textAlign = TextAlign.Center,)val GSVCBalanceBase100Right = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Medium,    fontSize = 36.sp,    color = GSVCBase100,    textAlign = TextAlign.End,)val GSVCCardBalanceText100Left = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Medium,    fontSize = 32.sp,    color = GSVCText100,    textAlign = TextAlign.Start,)val GSVCCardBalanceText100Center = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Medium,    fontSize = 32.sp,    color = GSVCText100,    textAlign = TextAlign.Center,)val GSVCCardBalanceText100Right = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Medium,    fontSize = 32.sp,    color = GSVCText100,    textAlign = TextAlign.End,)val GSVCCardBalanceText200Left = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Medium,    fontSize = 32.sp,    color = GSVCText200,    textAlign = TextAlign.Start,)val GSVCCardBalanceText200Center = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Medium,    fontSize = 32.sp,    color = GSVCText200,    textAlign = TextAlign.Center,)val GSVCCardBalanceText200Right = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Medium,    fontSize = 32.sp,    color = GSVCText200,    textAlign = TextAlign.End,)val GSVCCardBalanceBase100Left = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Medium,    fontSize = 32.sp,    color = GSVCBase100,    textAlign = TextAlign.Start,)val GSVCCardBalanceBase100Center = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Medium,    fontSize = 32.sp,    color = GSVCBase100,    textAlign = TextAlign.Center,)val GSVCCardBalanceBase100Right = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Medium,    fontSize = 32.sp,    color = GSVCBase100,    textAlign = TextAlign.End,)val GSVCTitleText100Left = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Bold,    fontSize = 22.sp,    color = GSVCText100,    textAlign = TextAlign.Start,)val GSVCTitleText100Center = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Bold,    fontSize = 22.sp,    color = GSVCText100,    textAlign = TextAlign.Center,)val GSVCTitleText100Right = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Bold,    fontSize = 22.sp,    color = GSVCText100,    textAlign = TextAlign.End,)val GSVCTitleText200Left = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Bold,    fontSize = 22.sp,    color = GSVCText200,    textAlign = TextAlign.Start,)val GSVCTitleText200Center = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Bold,    fontSize = 22.sp,    color = GSVCText200,    textAlign = TextAlign.Center,)val GSVCTitleText200Right = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Bold,    fontSize = 22.sp,    color = GSVCText200,    textAlign = TextAlign.End,)val GSVCTitleBase100Left = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Bold,    fontSize = 22.sp,    color = GSVCBase100,    textAlign = TextAlign.Start,)val GSVCTitleBase100Center = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Bold,    fontSize = 22.sp,    color = GSVCBase100,    textAlign = TextAlign.Center,)val GSVCTitleBase100Right = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Bold,    fontSize = 22.sp,    color = GSVCBase100,    textAlign = TextAlign.End,)val GSVCaptionText100Left = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Medium,    fontSize = 20.sp,    color = GSVCText100,    textAlign = TextAlign.Start,)val GSVCaptionText100Center = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Medium,    fontSize = 20.sp,    color = GSVCText100,    textAlign = TextAlign.Center,)val GSVCaptionText100Right = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Medium,    fontSize = 20.sp,    color = GSVCText100,    textAlign = TextAlign.End,)val GSVCaptionText200Left = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Medium,    fontSize = 20.sp,    color = GSVCText200,    textAlign = TextAlign.Start,)val GSVCaptionText200Center = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Medium,    fontSize = 20.sp,    color = GSVCText200,    textAlign = TextAlign.Center,)val GSVCaptionText200Right = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Medium,    fontSize = 20.sp,    color = GSVCText200,    textAlign = TextAlign.End,)val GSVCaptionBase100Left = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Medium,    fontSize = 20.sp,    color = GSVCBase100,    textAlign = TextAlign.Start,)val GSVCaptionBase100Center = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Medium,    fontSize = 20.sp,    color = GSVCBase100,    textAlign = TextAlign.Center,)val GSVCaptionBase100Right = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Medium,    fontSize = 20.sp,    color = GSVCBase100,    textAlign = TextAlign.End,)val GSVCBody1Text100Left = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Normal,    fontSize = 16.sp,    color = GSVCText100,    textAlign = TextAlign.Start,)val GSVCBody1Text100Center = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Normal,    fontSize = 16.sp,    color = GSVCText100,    textAlign = TextAlign.Center,)val GSVCBody1Text100Right = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Normal,    fontSize = 16.sp,    color = GSVCText100,    textAlign = TextAlign.End,)val GSVCBody1Text200Left = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Normal,    fontSize = 16.sp,    color = GSVCText200,    textAlign = TextAlign.Start,)val GSVCBody1Text200Center = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Normal,    fontSize = 16.sp,    color = GSVCText200,    textAlign = TextAlign.Center,)val GSVCBody1Text200Right = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Normal,    fontSize = 16.sp,    color = GSVCText200,    textAlign = TextAlign.End,)val GSVCBody1Base100Left = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Normal,    fontSize = 16.sp,    color = GSVCBase100,    textAlign = TextAlign.Start,)val GSVCBody1Base100Center = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Normal,    fontSize = 16.sp,    color = GSVCBase100,    textAlign = TextAlign.Center,)val GSVCBody1Base100Right = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Normal,    fontSize = 16.sp,    color = GSVCBase100,    textAlign = TextAlign.End,)val GSVCBody2Text100Left = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Medium,    fontSize = 16.sp,    color = GSVCText100,    textAlign = TextAlign.Start,)val GSVCBody2Text100Center = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Medium,    fontSize = 16.sp,    color = GSVCText100,    textAlign = TextAlign.Center,)val GSVCBody2Text100Right = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Medium,    fontSize = 16.sp,    color = GSVCText100,    textAlign = TextAlign.End,)val GSVCBody2Text200Left = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Medium,    fontSize = 16.sp,    color = GSVCText200,    textAlign = TextAlign.Start,)val GSVCBody2Text200Center = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Medium,    fontSize = 16.sp,    color = GSVCText200,    textAlign = TextAlign.Center,)val GSVCBody2Text200Right = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Medium,    fontSize = 16.sp,    color = GSVCText200,    textAlign = TextAlign.End,)val GSVCBody2Base100Left = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Medium,    fontSize = 16.sp,    color = GSVCBase100,    textAlign = TextAlign.Start,)val GSVCBody2Base100Center = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Medium,    fontSize = 16.sp,    color = GSVCBase100,    textAlign = TextAlign.Center,)val GSVCBody2Base100Right = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Medium,    fontSize = 16.sp,    color = GSVCBase100,    textAlign = TextAlign.End,)val GSVCBody3Text100Left = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Normal,    fontSize = 14.sp,    color = GSVCText100,    textAlign = TextAlign.Start,)val GSVCBody3Text100Center = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Normal,    fontSize = 14.sp,    color = GSVCText100,    textAlign = TextAlign.Center,)val GSVCBody3Text100Right = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Normal,    fontSize = 14.sp,    color = GSVCText100,    textAlign = TextAlign.End,)val GSVCBody3Text200Left = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Normal,    fontSize = 14.sp,    color = GSVCText200,    textAlign = TextAlign.Start,)val GSVCBody3Text200Center = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Normal,    fontSize = 14.sp,    color = GSVCText200,    textAlign = TextAlign.Center,)val GSVCBody3Text200Right = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Normal,    fontSize = 14.sp,    color = GSVCText200,    textAlign = TextAlign.End,)val GSVCBody3Base100Left = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Normal,    fontSize = 14.sp,    color = GSVCBase100,    textAlign = TextAlign.Start,)val GSVCBody3Base100Center = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Normal,    fontSize = 14.sp,    color = GSVCBase100,    textAlign = TextAlign.Center,)val GSVCBody3Base100Right = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Normal,    fontSize = 14.sp,    color = GSVCBase100,    textAlign = TextAlign.End,)val GSVCBody4Text100Left = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Medium,    fontSize = 14.sp,    color = GSVCText100,    textAlign = TextAlign.Start,)val GSVCBody4Text100Center = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Medium,    fontSize = 14.sp,    color = GSVCText100,    textAlign = TextAlign.Center,)val GSVCBody4Text100Right = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Medium,    fontSize = 14.sp,    color = GSVCText100,    textAlign = TextAlign.End,)val GSVCBody4Text200Left = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Medium,    fontSize = 14.sp,    color = GSVCText200,    textAlign = TextAlign.Start,)val GSVCBody4Text200Center = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Medium,    fontSize = 14.sp,    color = GSVCText200,    textAlign = TextAlign.Center,)val GSVCBody4Text200Right = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Medium,    fontSize = 14.sp,    color = GSVCText200,    textAlign = TextAlign.End,)val GSVCBody4Base100Left = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Medium,    fontSize = 14.sp,    color = GSVCBase100,    textAlign = TextAlign.Start,)val GSVCBody4Base100Center = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Medium,    fontSize = 14.sp,    color = GSVCBase100,    textAlign = TextAlign.Center,)val GSVCBody4Base100Right = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Medium,    fontSize = 14.sp,    color = GSVCBase100,    textAlign = TextAlign.End,)val GSVCButtonText100Left = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Bold,    fontSize = 16.sp,    color = GSVCText100,    textAlign = TextAlign.Start,)val GSVCText100Left = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Medium,    fontSize = 16.sp,    color = GSVCText100,    textAlign = TextAlign.Start,)val GSVCButtonText100Center = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Bold,    fontSize = 16.sp,    color = GSVCText100,    textAlign = TextAlign.Center,)val GSVCButtonText100Right = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Bold,    fontSize = 16.sp,    color = GSVCText100,    textAlign = TextAlign.End,)val GSVCButtonText200Left = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Bold,    fontSize = 16.sp,    color = GSVCText200,    textAlign = TextAlign.Start,)val GSVCButtonText200Center = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Bold,    fontSize = 16.sp,    color = GSVCText200,    textAlign = TextAlign.Center,)val GSVCButtonText200Right = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Bold,    fontSize = 16.sp,    color = GSVCText200,    textAlign = TextAlign.End,)val GSVCButtonBase100Left = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Bold,    fontSize = 16.sp,    color = GSVCBase100,    textAlign = TextAlign.Start,)val GSVCButtonBase100Center = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Bold,    fontSize = 16.sp,    color = GSVCBase100,    textAlign = TextAlign.Center,)val GSVCButtonBase100Right = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Bold,    fontSize = 16.sp,    color = GSVCBase100,    textAlign = TextAlign.End,)val GSVCButtonSecondary100Left = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Bold,    fontSize = 16.sp,    color = GSVCSecondary100,    textAlign = TextAlign.Start,)val GSVCButtonSecondary100Center = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Bold,    fontSize = 16.sp,    color = GSVCSecondary100,    textAlign = TextAlign.Center,)val GSVCButtonSecondary100Right = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Bold,    fontSize = 16.sp,    color = GSVCSecondary100,    textAlign = TextAlign.End,)val GSVCCtaLeft = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Medium,    fontSize = 14.sp,    color = GSVCSecondary100,    textAlign = TextAlign.Start,)val GSVCCtaCenter = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Medium,    fontSize = 14.sp,    color = GSVCSecondary100,    textAlign = TextAlign.Center,)val GSVCCtaRight = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Medium,    fontSize = 14.sp,    color = GSVCSecondary100,    textAlign = TextAlign.End,)val GSVCHelper1Text100Left = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Normal,    fontSize = 12.sp,    color = GSVCText100,    textAlign = TextAlign.Start,)val GSVCHelper1Text100Center = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Normal,    fontSize = 12.sp,    color = GSVCText100,    textAlign = TextAlign.Center,)val GSVCHelper1Text100Right = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Normal,    fontSize = 12.sp,    color = GSVCText100,    textAlign = TextAlign.End,)val GSVCHelper1Text200Left = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Normal,    fontSize = 12.sp,    color = GSVCText200,    textAlign = TextAlign.Start,)val GSVCHelper1Text200Center = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Normal,    fontSize = 12.sp,    color = GSVCText200,    textAlign = TextAlign.Center,)val GSVCHelper1Text200Right = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Normal,    fontSize = 12.sp,    color = GSVCText200,    textAlign = TextAlign.End,)val GSVCHelper1Base100Left = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Normal,    fontSize = 12.sp,    color = GSVCBase100,    textAlign = TextAlign.Start,)val GSVCHelper1Base100Center = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Normal,    fontSize = 12.sp,    color = GSVCBase100,    textAlign = TextAlign.Center,)val GSVCHelper1Base100Right = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Normal,    fontSize = 12.sp,    color = GSVCBase100,    textAlign = TextAlign.End,)val GSVCHelper1Primary100Left = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Normal,    fontSize = 12.sp,    color = GSVCPrimary100,    textAlign = TextAlign.Start,)val GSVCHelper1Primary100Center = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Normal,    fontSize = 12.sp,    color = GSVCPrimary100,    textAlign = TextAlign.Center,)val GSVCHelper1Primary100Right = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Normal,    fontSize = 12.sp,    color = GSVCPrimary100,    textAlign = TextAlign.End,)val GSVCHelper1Info100Left = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Normal,    fontSize = 12.sp,    color = GSVCInfo100,    textAlign = TextAlign.Start,)val GSVCHelper1Info100Center = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Normal,    fontSize = 12.sp,    color = GSVCInfo100,    textAlign = TextAlign.Center,)val GSVCHelper1Info100Right = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Normal,    fontSize = 12.sp,    color = GSVCInfo100,    textAlign = TextAlign.End,)val GSVCHelper1Success100Left = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Normal,    fontSize = 12.sp,    color = GSVCSuccess100,    textAlign = TextAlign.Start,)val GSVCHelper1Success100Center = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Normal,    fontSize = 12.sp,    color = GSVCSuccess100,    textAlign = TextAlign.Center,)val GSVCHelper1Success100Right = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Normal,    fontSize = 12.sp,    color = GSVCSuccess100,    textAlign = TextAlign.End,)val GSVCHelper1Error100Left = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Normal,    fontSize = 12.sp,    color = GSVCError100,    textAlign = TextAlign.Start,)val GSVCHelper1Error100Center = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Normal,    fontSize = 12.sp,    color = GSVCError100,    textAlign = TextAlign.Center,)val GSVCHelper1Error100Right = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Normal,    fontSize = 12.sp,    color = GSVCError100,    textAlign = TextAlign.End,)val GSVCHelper1Warning100Left = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Normal,    fontSize = 12.sp,    color = GSVCAlert100,    textAlign = TextAlign.Start,)val GSVCHelper1Warning100Center = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Normal,    fontSize = 12.sp,    color = GSVCAlert100,    textAlign = TextAlign.Center,)val GSVCHelper1Warning100Right = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Normal,    fontSize = 12.sp,    color = GSVCAlert100,    textAlign = TextAlign.End,)val GSVCHelper2Text100Left = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Medium,    fontSize = 12.sp,    color = GSVCText100,    textAlign = TextAlign.Start,)val GSVCHelper2Text100Center = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Medium,    fontSize = 12.sp,    color = GSVCText100,    textAlign = TextAlign.Center,)val GSVCHelper2Text100Right = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Medium,    fontSize = 12.sp,    color = GSVCText100,    textAlign = TextAlign.End,)val GSVCHelper2Text200Left = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Medium,    fontSize = 12.sp,    color = GSVCText200,    textAlign = TextAlign.Start,)val GSVCHelper2Text200Center = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Medium,    fontSize = 12.sp,    color = GSVCText200,    textAlign = TextAlign.Center,)val GSVCHelper2Text200Right = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Medium,    fontSize = 12.sp,    color = GSVCText200,    textAlign = TextAlign.End,)val GSVCHelper2Base100Left = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Medium,    fontSize = 12.sp,    color = GSVCBase100,    textAlign = TextAlign.Start,)val GSVCHelper2Base100Center = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Medium,    fontSize = 12.sp,    color = GSVCBase100,    textAlign = TextAlign.Center,)val GSVCHelper2Base100Right = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Medium,    fontSize = 12.sp,    color = GSVCBase100,    textAlign = TextAlign.End,)val GSVCHelper2Secundario100Center = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Medium,    fontSize = 12.sp,    color = GSVCSecondary100,    textAlign = TextAlign.Center,)val GSVCHelper3Text100Left = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Bold,    fontSize = 12.sp,    color = GSVCText100,    textAlign = TextAlign.Start,)val GSVCHelper3Text100Center = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Bold,    fontSize = 12.sp,    color = GSVCText100,    textAlign = TextAlign.Center,)val GSVCHelper3Text100Right = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Bold,    fontSize = 12.sp,    color = GSVCText100,    textAlign = TextAlign.End,)val GSVCHelper3Text200Left = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Bold,    fontSize = 12.sp,    color = GSVCText200,    textAlign = TextAlign.Start,)val GSVCHelper3Text200Center = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Bold,    fontSize = 12.sp,    color = GSVCText200,    textAlign = TextAlign.Center,)val GSVCHelper3Text200Right = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Bold,    fontSize = 12.sp,    color = GSVCText200,    textAlign = TextAlign.End,)val GSVCHelper3Base100Left = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Bold,    fontSize = 12.sp,    color = GSVCBase100,    textAlign = TextAlign.Start,)val GSVCHelper3Base100Center = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Bold,    fontSize = 12.sp,    color = GSVCBase100,    textAlign = TextAlign.Center,)val GSVCHelper3Base100Right = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Bold,    fontSize = 12.sp,    color = GSVCBase100,    textAlign = TextAlign.End,)val GSVCHelper3Secondary100Left = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Bold,    fontSize = 12.sp,    color = GSVCSecondary100,    textAlign = TextAlign.Start,)val GSVCHelper3Secondary100Center = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Bold,    fontSize = 12.sp,    color = GSVCSecondary100,    textAlign = TextAlign.Center,)val GSVCHelper3Secondary100Right = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Bold,    fontSize = 12.sp,    color = GSVCSecondary100,    textAlign = TextAlign.End,)val GSVCHelper3Info100Left = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Bold,    fontSize = 12.sp,    color = GSVCInfo100,    textAlign = TextAlign.Start,)val GSVCHelper3Info100Center = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Bold,    fontSize = 12.sp,    color = GSVCInfo100,    textAlign = TextAlign.Center,)val GSVCHelper3Info100Right = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Bold,    fontSize = 12.sp,    color = GSVCInfo100,    textAlign = TextAlign.End,)val GSVCHelper3Success100Left = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Bold,    fontSize = 12.sp,    color = GSVCSuccess100,    textAlign = TextAlign.Start,)val GSVCHelper3Success100Center = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Bold,    fontSize = 12.sp,    color = GSVCSuccess100,    textAlign = TextAlign.Center,)val GSVCHelper3Success100Right = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Bold,    fontSize = 12.sp,    color = GSVCSuccess100,    textAlign = TextAlign.End,)val GSVCHelper3Error100Left = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Bold,    fontSize = 12.sp,    color = GSVCError100,    textAlign = TextAlign.Start,)val GSVCHelper3Error100Center = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Bold,    fontSize = 12.sp,    color = GSVCError100,    textAlign = TextAlign.Center,)val GSVCHelper3Error100Right = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Bold,    fontSize = 12.sp,    color = GSVCError100,    textAlign = TextAlign.End,)val GSVCHelper3Warning100Left = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Bold,    fontSize = 12.sp,    color = GSVCAlert100,    textAlign = TextAlign.Start,)val GSVCHelper3Warning100Center = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Bold,    fontSize = 12.sp,    color = GSVCAlert100,    textAlign = TextAlign.Center,)val GSVCHelper3Warning100Right = TextStyle(    fontFamily = poppinsFamily,    fontWeight = FontWeight.Bold,    fontSize = 12.sp,    color = GSVCAlert100,    textAlign = TextAlign.End,)