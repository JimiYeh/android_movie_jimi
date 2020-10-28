package com.example.movie.repository

import com.example.movie.model.response.*
import com.example.movie.service.MovieService
import com.example.movie.ui.home.vo.MovieCategory

class MovieRepo(val service: MovieService) {

    suspend fun getCategoryMovies(category: MovieCategory): ApiResponse<List<Subject>> {

        return when(category) {
            MovieCategory.CategoryInTheaters -> getInTheatersMovies()
            MovieCategory.CategoryComingSoon -> getComingSoonMovies()
            MovieCategory.CategoryWeekly -> getWeeklyMovies()
            MovieCategory.CategoryUSBox -> getUSBoxMovies()
            MovieCategory.CategoryNewMovie -> getNewMovies()
        }
    }

    private suspend fun getInTheatersMovies(): ApiResponse<List<Subject>> {
        return when(val resp = callApi { service.getInTheatersMovies() }) {
            is ApiResponse.Success<InTheatersMoviesResp> -> {
                val list = mutableListOf<Subject>()
                resp.data?.inTheatersSubjects?.map {
                    it.subject
                }?.forEach {
                    list.add(it)
                }
                ApiResponse.Success(list)
            }
            is ApiResponse.Error -> resp
            is ApiResponse.Exception -> resp
        }
    }

    private suspend fun getNewMovies(): ApiResponse<List<Subject>> {
        return when(val resp = callApi { service.getNewMovies() }) {
            is ApiResponse.Success<NewMoviesResp> -> {
                val list = mutableListOf<Subject>()
                resp.data?.subjects?.let {
                    list.addAll(it)
                }
                ApiResponse.Success(list)
            }
            is ApiResponse.Error -> resp
            is ApiResponse.Exception -> resp
        }
    }

    private suspend fun getComingSoonMovies(): ApiResponse<List<Subject>> {
        return when(val resp = callApi { service.getComingSoonMovies() }) {
            is ApiResponse.Success<ComingSoonMoviesResp> -> {
                val list = mutableListOf<Subject>()
                resp.data?.comingSoonSubjects?.map {
                    it.subject
                }?.forEach {
                    list.add(it)
                }
                ApiResponse.Success(list)
            }
            is ApiResponse.Error -> resp
            is ApiResponse.Exception -> resp
        }
    }

    private suspend fun getWeeklyMovies(): ApiResponse<List<Subject>> {
        return when(val resp = callApi { service.getWeeklyMovies() }) {
            is ApiResponse.Success<WeeklyMoviesResp> -> {
                val list = mutableListOf<Subject>()
                resp.data?.weeklySubjects?.map {
                    it.subject
                }?.forEach {
                    list.add(it)
                }
                ApiResponse.Success(list)
            }
            is ApiResponse.Error -> resp
            is ApiResponse.Exception -> resp
        }
    }

    private suspend fun getUSBoxMovies(): ApiResponse<List<Subject>> {
        return when(val resp = callApi { service.getUSBoxMovies() }) {
            is ApiResponse.Success<USBoxMoviesResp> -> {
                val list = mutableListOf<Subject>()
                resp.data?.subjects?.map {
                    it.subject
                }?.forEach {
                    list.add(it)
                }
                ApiResponse.Success(list)
            }
            is ApiResponse.Error -> resp
            is ApiResponse.Exception -> resp
        }
    }
}