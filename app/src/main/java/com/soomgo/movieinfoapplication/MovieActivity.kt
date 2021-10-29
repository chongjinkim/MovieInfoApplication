package com.soomgo.movieinfoapplication

import android.app.Application
import com.soomgo.movieinfoapplication.di.applicationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MovieActivity : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(applicationModule)
        }
    }
}