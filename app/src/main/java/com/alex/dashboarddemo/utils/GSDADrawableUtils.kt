package com.alex.dashboarddemo.utils

import android.content.Context
import com.alex.dashboarddemo.R


fun getDrawableFromString(mContext: Context, drawableStr: String) =
    try {
        mContext.resources.getIdentifier(
            drawableStr,
            "drawable",
            mContext.packageName,
        )
    } catch (e: IllegalArgumentException) {
        R.drawable.ic_placeholder
    }