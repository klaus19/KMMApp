package com.example.kmmapp

import android.app.Application

class App:Application() {

    override fun onCreate() {
        super.onCreate()
        initContextForSharedAndroidCode()
    }

    private fun initContextForSharedAndroidCode() {
        // Variable from the Context.kt file
        appContext = this
    }

}