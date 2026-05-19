package com.example.needylivewallpaper.service

import android.content.Intent
import android.content.IntentFilter
import android.content.res.AssetManager
import android.graphics.Canvas
import android.os.Handler
import android.os.Looper
import android.service.wallpaper.WallpaperService
import android.view.SurfaceHolder
import com.example.needylivewallpaper.graphx.Renderer
import com.example.needylivewallpaper.utils.Logger.logI
import com.example.needylivewallpaper.utils.phone.Screen
import com.example.needylivewallpaper.utils.phone.Time

class NeedyWallpaperService : WallpaperService() {
    
    companion object{
        lateinit var assets: AssetManager
    }
    
    override fun onCreateEngine(): Engine {
        return NeedyEngine()
    }

    inner class NeedyEngine : Engine(){
        
        init {
            NeedyWallpaperService.assets = assets
        }
        private var isVisible = false;
        private val handler = Handler(Looper.getMainLooper())

        private val myRunnable = object : Runnable {
            override fun run() {
                startDrawing()
                handler.postDelayed(this, 16L)
            }
        }

        override fun onVisibilityChanged(visible: Boolean) {
            isVisible = true
            if(visible){
                val filter = IntentFilter().apply {
                    addAction(Intent.ACTION_TIME_TICK)
                    addAction(Intent.ACTION_TIME_CHANGED)
                }

                handler.post(myRunnable)
                Time.updateState()
                registerReceiver(Time.timeReceiver, filter)
            }else{
                handler.removeCallbacks(myRunnable)
            }
        }

        override fun onSurfaceChanged(
            holder: SurfaceHolder?,
            format: Int,
            width: Int,
            height: Int
        ) {
            Screen.width = width.toFloat()
            Screen.height = height.toFloat()
            Main.main()
        }


        fun startDrawing(){
            val holder = surfaceHolder
            var canvas: Canvas ?= null

            try{
                canvas = holder.lockCanvas()
                if(canvas != null) draw(canvas)
            }finally {
                if(canvas != null) holder.unlockCanvasAndPost(canvas)
            }
        }

        fun draw(canvas: Canvas){
            Renderer.render(canvas)
        }
    }
}