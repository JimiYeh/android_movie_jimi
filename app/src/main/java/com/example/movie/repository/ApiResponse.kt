package com.example.movie.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import java.lang.Exception

sealed class ApiResponse<out T> {
    data class Success<out T>(val data: T?) : ApiResponse<T>()
    data class Error(val statusCode: Int): ApiResponse<Nothing>()
    data class Exception(val exception: java.lang.Exception): ApiResponse<Nothing>()
}

suspend inline fun <reified T> callApi(crossinline api: suspend () -> Response<T>): ApiResponse<T> = withContext(Dispatchers.IO) {

    try {
        val response = api.invoke()

        if (response.isSuccessful) {
            ApiResponse.Success(response.body())
        } else {
            ApiResponse.Error(response.code())
        }
    } catch (e: Exception) {
        ApiResponse.Exception(e)
    }
}