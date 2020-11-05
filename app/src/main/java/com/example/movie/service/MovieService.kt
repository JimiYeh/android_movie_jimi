package com.example.movie.service

import com.example.movie.model.response.MovieDetailResp
import com.example.movie.model.response.MovieReviewResp
import com.example.movie.model.response.MoviesResp
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {

    @GET("/3/movie/now_playing")
    suspend fun getNowPlayingMovies(
        @Query("language") language: String,
        @Query("page") page: Int = 1
    ): Response<MoviesResp>

    @GET("/3/movie/popular")
    suspend fun getPopularMovies(
        @Query("language") language: String,
        @Query("page") page: Int = 1
    ): Response<MoviesResp>

    @GET("/3/movie/top_rated")
    suspend fun getTopRatedMovies(
        @Query("language") language: String,
        @Query("page") page: Int = 1
    ): Response<MoviesResp>

    @GET("/3/movie/upcoming")
    suspend fun getUpcomingMovies(
        @Query("language") language: String,
        @Query("page") page: Int = 1
    ): Response<MoviesResp>


    @GET("/3/movie/{id}")
    suspend fun getMovieDetail(@Path("id") id: Int): Response<MovieDetailResp>


    @GET("/3/movie/{id}/reviews")
    suspend fun getMovieReviews(@Path("id") id: Int): Response<MovieReviewResp>
}