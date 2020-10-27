package com.example.movie.service

import retrofit2.http.GET
import retrofit2.http.Path

interface MovieService {

    @GET("/v2/movie/{category}")
    suspend fun getCategoryMovies(@Path("category") category: String)
}