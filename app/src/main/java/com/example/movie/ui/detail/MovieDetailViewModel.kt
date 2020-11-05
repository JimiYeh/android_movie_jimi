package com.example.movie.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.movie.model.response.MovieDetailResp
import com.example.movie.model.response.MovieReviewResp
import com.example.movie.repository.ApiResponse
import com.example.movie.repository.MovieRepo

class MovieDetailViewModel(private val id: Int, private val movieRepo: MovieRepo) : ViewModel() {

    val detail = liveData {
        val resp = movieRepo.getMovieDetail(id)
        if (resp is ApiResponse.Success<MovieDetailResp>)
            emit(resp.data)
        else
            emit(null)
    }

    val reviews = liveData {
        val resp = movieRepo.getMovieReviews(id)
        if (resp is ApiResponse.Success<MovieReviewResp>)
            emit(resp.data)
        else
            emit(null)
    }

}