package com.example.needylivewallpaper.graphx

import android.graphics.Canvas
import com.example.needylivewallpaper.comp.LayerManager
import com.example.needylivewallpaper.utils.Logger.logE

object Renderer {

    val renderQueue = arrayListOf<Layer>()

    fun addQueue(layerManager: LayerManager){
        for(layer in layerManager.layers) {
            if (renderQueue.contains(layer)) {
                logE("Layer is already in queue: $layer")
                return
            }
            renderQueue.add(layer)
        }
    }

    fun render(canvas: Canvas){
        renderQueue.sortBy{it.zOrder}

        for(layer in renderQueue)
            layer.drawAllChildren(canvas)
    }
}