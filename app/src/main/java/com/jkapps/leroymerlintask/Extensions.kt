package com.jkapps.leroymerlintask

import android.content.res.Resources

fun Int.toPx() : Int = (this * Resources.getSystem().displayMetrics.density).toInt()