package com.example.needylivewallpaper.graphx.render

import com.example.needylivewallpaper.utils.Logger.logE

interface LayerManager {
    val layers: ArrayList<Layer>

    fun show(){
        for(layer in layers)
            layer.show()
    }

    fun hide(){
        for(layer in layers)
            layer.hide()
    }
}