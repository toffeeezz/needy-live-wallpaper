package com.example.needylivewallpaper.comp

import com.example.needylivewallpaper.graphx.SimpleLayer
import com.example.needylivewallpaper.graphx.StaticNode
import com.example.needylivewallpaper.service.NeedyWallpaperService
import com.example.needylivewallpaper.utils.Logger.logD
import com.example.needylivewallpaper.utils.ResourceManager
import com.example.needylivewallpaper.utils.phone.Time

class Background : LayerManager() {

    companion object {
        const val DEFAULT = "backgrounds/desktop_wallpaper.png"
        const val MORNING_BAR = "sidebar/morning.png"
        const val AFTERNOON_BAR = "sidebar/afternoon.png"
        const val EVENING_BAR = "sidebar/evening.png"

        fun barAssetFor(state: Time.State) = when (state) {
            Time.State.MORNING -> MORNING_BAR
            Time.State.AFTERNOON -> AFTERNOON_BAR
            Time.State.EVENING -> EVENING_BAR
        }
    }

    private var currentState = Time.currentState
    private val layer0 = SimpleLayer(0)
    private val backgroundImg = StaticNode(
        layer0,
        ResourceManager.load(NeedyWallpaperService.assets, DEFAULT)
    )

    private val sideBar = StaticNode(
        layer0,
        ResourceManager.load(NeedyWallpaperService.assets, barAssetFor(Time.currentState))
    )



    init {
        sideBar.id = "Sidebar"
        backgroundImg.id = "Background"

        Time.onStateChanged = { state -> updateBars(state) }

        layers.add(layer0)
    }

    private fun updateBars(state: Time.State) {
        if (state == currentState) return

        val oldBitmap = sideBar.bitmap
        val newBitmap = ResourceManager.load(NeedyWallpaperService.assets, barAssetFor(state))


        sideBar.bitmap = newBitmap
        if (sideBar.bitmap !== oldBitmap)
            ResourceManager.removeFromCache(oldBitmap)


        currentState = state
        logD("Current state is: $currentState")
    }
}