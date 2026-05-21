package com.example.needylivewallpaper.service

import com.example.needylivewallpaper.comp.Background
import com.example.needylivewallpaper.graphx.render.Renderer

class Main {

    lateinit var background: Background



    fun start(){
        background = Background()

        Renderer.addQueue(background)
    }
}