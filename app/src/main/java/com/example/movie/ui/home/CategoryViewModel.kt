package com.example.movie.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.movie.repository.MovieRepo
import com.example.movie.ui.home.vo.MovieCategory

class CategoryViewModel(private val category: MovieCategory, private val movieRepo: MovieRepo) : ViewModel() {

    val movies = liveData {
        emit(movieRepo.getCategoryMovies(category))
    }
}