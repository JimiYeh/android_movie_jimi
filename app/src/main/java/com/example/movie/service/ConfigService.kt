package com.example.movie.service

import com.example.movie.model.response.ConfigurationResp
import retrofit2.Response
import retrofit2.http.GET

interface ConfigService {

    @GET("/3/configuration")
    suspend fun getConfiguration(): Response<ConfigurationResp>
}