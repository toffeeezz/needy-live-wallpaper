package com.example.needylivewallpaper.graphx.render

import android.graphics.Canvas
import android.util.Size
import com.example.needylivewallpaper.utils.Logger.logD
import com.example.needylivewallpaper.utils.Vector2

open class SimpleLayer(size: Size ?= null, zOrder: Int) : Layer(size, zOrder) {

    override fun drawAllChildren(canvas: Canvas) {
        if(!isVisible) return

        for(child in children){

            val bitmap = child.bitmap

            val centerX = bitmap.width / 2f
            val centerY = bitmap.height / 2f

            val screenCenterX = size.width / 2f
            val screenCenterY = size.height / 2f

            val offsetPos = Vector2(screenCenterX - centerX, screenCenterY - centerY)


            logD("Drawing: ${child.id}")
            canvas.drawBitmap(child.bitmap, offsetPos.x + child.getX(), offsetPos.y - child.getY(), null)
        }
    }

}