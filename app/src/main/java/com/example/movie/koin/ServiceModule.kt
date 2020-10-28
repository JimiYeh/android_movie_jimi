package com.example.movie.koin

import com.example.movie.BuildConfig
import com.example.movie.BuildConfig.SERVER_URL
import com.example.movie.service.MovieService
import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

val serviceModule = module {
    single { createOkHttpClient() }

    single<MovieService> { createService(get()) }
}

fun createOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
    .addNetworkInterceptor(StethoInterceptor())
    .addInterceptor {
        val url = it.request().url
            .newBuilder()
            .addQueryParameter("apikey", "0b2bdeda43b5688921839c8ecb20399b")
            .build()

        val request = it.request().newBuilder().url(url).build()
        it.proceed(request)
    }
    .connectTimeout(20, TimeUnit.SECONDS)
    .readTimeout(20, TimeUnit.SECONDS)
    .build()

inline fun <reified T> createService(okHttpClient: OkHttpClient): T {
    val retrofit = Retrofit.Builder()
        .baseUrl(SERVER_URL)
        .client(okHttpClient)
//        .addConverterFactory(MoshiConverterFactory.create().asLenient())
            .addConverterFactory(GsonConverterFactory.create())
        .build()

    return retrofit.create(T::class.java)
}