package com.example.movie.repository

import com.example.movie.model.response.ConfigurationResp
import com.example.movie.service.ConfigService
import org.koin.java.KoinJavaComponent.get


object APIConfig {

    private var config: ConfigurationResp? = null

    @Synchronized
    suspend fun getConfig(): ConfigurationResp? {
        if (config != null)
            return config

        val configService: ConfigService = get(ConfigService::class.java)
        val resp = callApi { configService.getConfiguration() }
        return if (resp is ApiResponse.Success<ConfigurationResp>) {
            config = resp.data
            config
        } else
            null
    }
}