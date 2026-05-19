package com.example.needylivewallpaper.graphx

import android.graphics.Canvas
import android.util.Size
import com.example.needylivewallpaper.utils.Logger.logE

abstract class Layer(var zOrder: Int) {

    abstract var size: Size
    val children: ArrayList<Node> = arrayListOf()
    var isVisible = true

    fun add(node: Node){
        if(children.contains(node)){
            logE("Adding a duplicate child: $node")
            return
        }
        children.add(node)
    }

    fun remove(node: Node){
        if(!children.contains(node)){
            logE("This container does not contain a child: $node")
            return
        }
        children.remove(node)
    }

    fun show(){isVisible = true}
    fun hide(){isVisible = false}

    abstract fun drawAllChildren(canvas: Canvas)
}