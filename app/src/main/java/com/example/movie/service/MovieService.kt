package com.example.movie.service

import com.example.movie.model.response.*
import retrofit2.Response
import retrofit2.http.GET

interface MovieService {

    @GET("/v2/movie/new_movies")
    suspend fun getNewMovies(): Response<NewMoviesResp>

    @GET("/v2/movie/in_theaters")
    suspend fun getInTheatersMovies(): Response<InTheatersMoviesResp>

    @GET("/v2/movie/coming_soon")
    suspend fun getComingSoonMovies(): Response<ComingSoonMoviesResp>

    @GET("/v2/movie/weekly")
    suspend fun getWeeklyMovies(): Response<WeeklyMoviesResp>

    @GET("/v2/movie/us_box")
    suspend fun getUSBoxMovies(): Response<USBoxMoviesResp>
}