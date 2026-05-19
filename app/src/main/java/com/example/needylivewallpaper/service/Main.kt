package com.example.needylivewallpaper.service

import com.example.needylivewallpaper.comp.Background
import com.example.needylivewallpaper.graphx.Renderer

class Main {


    companion object{
      fun main(){

          val background = Background()



          background.show()








          Renderer.addQueue(background)
      }
    }
}