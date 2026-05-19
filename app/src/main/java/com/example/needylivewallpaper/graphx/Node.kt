package com.example.needylivewallpaper.graphx

import android.graphics.Bitmap
import com.example.needylivewallpaper.utils.Vector2
import com.example.needylivewallpaper.utils.phone.Screen

abstract class Node(var bitmap: Bitmap) {

    var id: String ?= null
    var position: Vector2 = Vector2(0f, 0f)
        set(value) {
            val centerX = bitmap.width / 2f
            val centerY = bitmap.height / 2f

            val screenCenter = Screen.getCenter

            val pos = Vector2(screenCenter.x - centerX, screenCenter.y - centerY)

            field = Vector2(pos.x + value.x, pos.y + value.y)
        }
}