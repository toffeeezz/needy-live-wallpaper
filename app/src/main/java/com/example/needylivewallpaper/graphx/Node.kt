package com.example.needylivewallpaper.graphx

import android.graphics.Bitmap
import com.example.needylivewallpaper.utils.Vector2
import com.example.needylivewallpaper.utils.phone.Screen
import kotlin.properties.Delegates

abstract class Node(val layer: Layer, var bitmap: Bitmap) {

    init {
        layer.add(this)
    }

    var id: String ?= null

    var position: Vector2 by Delegates.vetoable(Vector2(0f, 0f)){
        _, _, new ->

        val screenXLimit = layer.size.width / 2f
        val screenYLimit = layer.size.height / 2f

        new.x >= -screenXLimit && new.x <= screenXLimit && new.y >= -screenYLimit && new.y <= screenYLimit
    }

    fun getX(): Float{return position.x}
    fun getY(): Float{return position.y}

}