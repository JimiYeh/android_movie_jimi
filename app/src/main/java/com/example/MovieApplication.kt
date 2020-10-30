package com.example

import android.app.Application
import com.airbnb.epoxy.Carousel
import com.example.movie.koin.repositoryModule
import com.example.movie.koin.serviceModule
import com.example.movie.koin.viewModelModule
import com.facebook.stetho.Stetho
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MovieApplication : Application() {


    companion object {
        var instance: MovieApplication? = null
    }


    override fun onCreate() {
        super.onCreate()

        instance = this

        startKoin {
            androidContext(this@MovieApplication)
            modules(listOf(serviceModule, repositoryModule, viewModelModule))
        }

        Stetho.initializeWithDefaults(this)

        Carousel.setDefaultGlobalSnapHelperFactory(null)
    }
}