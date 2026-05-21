package com.example.needylivewallpaper.utils.phone

import android.util.Size
import com.example.needylivewallpaper.utils.Vector2

object Screen {
    var width = 0
    var height = 0

    val getCenter get() = Size((width / 2), (height / 2))
}