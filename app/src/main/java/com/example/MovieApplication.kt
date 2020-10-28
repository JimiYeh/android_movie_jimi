package com.example

import android.app.Application
import com.example.movie.koin.repositoryModule
import com.example.movie.koin.serviceModule
import com.example.movie.koin.viewModelModule
import com.facebook.stetho.Stetho
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MovieApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MovieApplication)
            modules(listOf(serviceModule, repositoryModule, viewModelModule))
        }

        Stetho.initializeWithDefaults(this)
    }
}