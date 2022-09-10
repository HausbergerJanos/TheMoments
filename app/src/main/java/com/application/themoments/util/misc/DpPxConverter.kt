package com.xeropan.student.util.misc

import android.content.res.Resources

val Int.pxTodp: Int
    get() = (this / Resources.getSystem().displayMetrics.density).toInt()

val Int.dpTopx: Int
    get() = (this * Resources.getSystem().displayMetrics.density).toInt()