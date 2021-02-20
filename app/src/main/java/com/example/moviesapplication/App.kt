package com.example.moviesapplication

import android.app.Application
import com.example.moviesapplication.di.appModule
import com.example.moviesapplication.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

open class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(listOf(appModule, networkModule))
        }
    }
}