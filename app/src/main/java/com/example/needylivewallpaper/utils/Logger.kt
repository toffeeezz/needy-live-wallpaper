package com.example.needylivewallpaper.utils

import android.util.Log

object Logger {

    private const val DEBUG_FLAG = true

    fun Any.logD(message: String) {
        if(DEBUG_FLAG) Log.d(this::class.simpleName, message)
    }

    fun Any.logI(message: String) {
        if(DEBUG_FLAG) Log.i(this::class.simpleName, message)
    }

    fun Any.logW(message: String) {
        if(DEBUG_FLAG) Log.w(this::class.simpleName, message)
    }

    fun Any.logE(message: String, throwable: Throwable? = null) {
        if(DEBUG_FLAG) Log.e(this::class.simpleName, message, throwable)
    }
}