package com.example.movie.ui

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.movie.R

class MovieListViewModel : ViewModel() {

    val categoryList = listOf(
        Pair(R.string.category_in_theaters, "in_theaters"),
        Pair(R.string.category_coming_soon, "coming_soon"),
        Pair(R.string.category_weekly, "weekly"),
        Pair(R.string.category_us_box, "us_box"),
        Pair(R.string.category_new_movies, "new_movies"),
    )
}