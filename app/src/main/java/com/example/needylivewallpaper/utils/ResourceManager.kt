package com.example.needylivewallpaper.utils

import android.content.res.AssetManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log

object ResourceManager {

    const val DESKTOP_BG = "backgrounds/desktop_wallpaper.png"
    const val WEBCAM_DEFAULT = "webcam/webcam-default.png"
    const val WEBCAM_10K = "webcam/webcam-10k.png"
    const val MORNING_SD_BR = "sidebar/morning.png"
    const val EVENING_SD_BAR = "sidebar/evening.png"
    const val AFTERNOON_SD_BAR = "sidebar/afternoon.png"

    private val bitmapCache = mutableMapOf<String, Bitmap>()


    fun load(assets: AssetManager, path: String): Bitmap{
        if(bitmapCache.contains(path))
            return bitmapCache[path]!!

        val bitmap = BitmapFactory.decodeStream(assets.open(path))
        bitmapCache[path] = bitmap

        return bitmap
    }

    fun removeFromCache(bitmap: Bitmap){
        if (!bitmapCache.containsValue(bitmap)) {
            Log.w("ResourceManager", "Bitmap source is not on cache yet: $bitmap")
            return
        }

        val key = bitmapCache.entries.find { it.value == bitmap }?.key ?: return

        bitmapCache.remove(key)
    }

}