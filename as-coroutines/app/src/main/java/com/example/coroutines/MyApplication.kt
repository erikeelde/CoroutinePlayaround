package com.example.coroutines

import android.app.Application
import android.os.StrictMode

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
    }
}