package com.example.needylivewallpaper.graphx.render

import android.graphics.Canvas
import android.util.Log
import com.example.needylivewallpaper.utils.Logger
import com.example.needylivewallpaper.utils.Logger.logD
import com.example.needylivewallpaper.utils.Logger.logE
import com.example.needylivewallpaper.utils.Logger.logI

object Renderer {

    val renderQueue = arrayListOf<Layer>()

    fun addQueue(layerManager: LayerManager){
        for(layer in layerManager.layers) {
            if (renderQueue.contains(layer)) {
                logE("Layer is already in queue: $layer")
                continue
            }
            Log.d("Renderer","Added ${layer.javaClass.simpleName}")
            renderQueue.add(layer)
        }
    }

    fun render(canvas: Canvas){
        Logger.logD("Drawing")
        renderQueue.sortBy{it.zOrder}

        for(layer in renderQueue)
            layer.drawAllChildren(canvas)
    }
}