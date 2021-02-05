package com.example.myapplicationwork

import android.app.Application
import android.content.Context

class PersistencyApp: Application() {

    override fun onCreate() {
        super.onCreate()
        appContext = this
    }

    companion object {
        private lateinit var appContext: PersistencyApp

        fun getContext() :Context{
            return appContext
        }
        }
}
