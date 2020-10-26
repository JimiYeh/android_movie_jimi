package com.example

import android.app.Application
import com.example.movie.koin.viewModelModule
import com.facebook.stetho.Stetho
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ＭovieApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@ＭovieApplication)
            modules(listOf(viewModelModule))
        }

        Stetho.initializeWithDefaults(this)
    }
}