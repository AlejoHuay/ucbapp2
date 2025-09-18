package com.calyrsoft.ucbapp

import android.app.Application
import com.calyrsoft.ucbapp.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin { // agreamos dependencias de koin
            androidContext(this@App)
            modules(appModule)
        }
    }
}