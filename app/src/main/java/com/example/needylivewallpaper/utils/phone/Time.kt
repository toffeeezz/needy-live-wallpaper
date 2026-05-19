package com.example.needylivewallpaper.utils.phone

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import java.time.LocalTime
import kotlin.properties.Delegates

object Time {

    enum class State{
        MORNING, AFTERNOON, EVENING
    }

    var currentState: State by Delegates.observable(State.MORNING) {_,_, newValue ->
        run {
            onStateChanged?.invoke(newValue)
        }
    }

    var onStateChanged: ((State) -> Unit)? = null

    val timeReceiver = object : BroadcastReceiver() {
        override fun onReceive(p0: Context?, p1: Intent?) {
            when(p1?.action){
                Intent.ACTION_TIME_TICK -> updateState()
                Intent.ACTION_TIME_CHANGED -> updateState()
            }
        }
    }


    fun updateState(){
        val now = LocalTime.now()

        currentState = when {
            now >= LocalTime.of(19, 0) -> State.EVENING
            now >= LocalTime.of(16, 0) -> State.AFTERNOON
            now >= LocalTime.of(6, 0) -> State.MORNING
            else -> State.EVENING //Midnight
        }
        Log.i("Time", "It is now $currentState" )
    }
}