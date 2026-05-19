package com.example.needylivewallpaper.utils.phone

import com.example.needylivewallpaper.utils.Vector2

object Screen {
    var width = 0f
    var height = 0f

    val getCenter get() = Vector2(width / 2f, height / 2f)
}