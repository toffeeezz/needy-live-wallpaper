package com.example.needylivewallpaper.graphx.render

import android.graphics.Canvas
import android.util.Size
import com.example.needylivewallpaper.graphx.Node
import com.example.needylivewallpaper.utils.Logger.logE
import com.example.needylivewallpaper.utils.phone.Screen
import kotlin.properties.Delegates

abstract class Layer(size: Size ?= null, var zOrder: Int) {

    var size: Size by Delegates.vetoable(Size(0, 0)){
        _, _, new ->
        new.width in 0..Screen.width && new.height in 0..Screen.height
    }

    init {
        this.size = size ?: Size(Screen.width, Screen.height)
    }


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