package com.example.needylivewallpaper.graphx

import android.graphics.Canvas
import com.example.needylivewallpaper.utils.Logger.logD
import com.example.needylivewallpaper.utils.Logger.logE

abstract class Container {
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

    fun drawAllChildren(canvas: Canvas){
        if(!isVisible) return

        for(child in children){
            //logD("Drawing: ${child.id}")
            canvas.drawBitmap(child.bitmap, child.position.x, child.position.y, null)
        }
    }
}