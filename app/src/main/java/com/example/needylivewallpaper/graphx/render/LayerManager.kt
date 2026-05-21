package com.example.needylivewallpaper.graphx.render

import com.example.needylivewallpaper.utils.Logger.logE

abstract class LayerManager {
    val layers = arrayListOf<Layer>()


    fun addLayer(layer: Layer){
        if (layers.contains(layer)){
            logE("Adding a duplicate layer: $layer")
            return
        }

        layers.add(layer)
    }

    fun removeLayer(layer: Layer) {
        if (!layers.contains(layer)) {
            logE("This manager does not contain a layer: $layer")
            return
        }

        layers.remove(layer)
    }

    fun show(){
        for(layer in layers)
            layer.show()
    }

    fun hide(){
        for(layer in layers)
            layer.hide()
    }
}