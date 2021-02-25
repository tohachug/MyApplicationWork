package com.example.myapplicationwork

import android.app.Application
import android.content.Context
import androidx.work.WorkManager

class PersistencyApp: Application() {

    override fun onCreate() {
        super.onCreate()
        appContext = this
        WorkManager.getInstance(appContext).enqueue(WorkRepository().myWorkRequest)
    }

    companion object {
        private lateinit var appContext: PersistencyApp

        fun getContext() :Context{
            return appContext
        }
        }
}
