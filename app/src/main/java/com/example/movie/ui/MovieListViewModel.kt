package com.example.movie.ui

import androidx.lifecycle.ViewModel
import com.example.movie.ui.vo.MovieCategory

class MovieListViewModel : ViewModel() {

    val categoryList = listOf(
        MovieCategory.CategoryInTheaters,
        MovieCategory.CategoryComingSoon,
        MovieCategory.CategoryWeekly,
        MovieCategory.CategoryUSBox,
        MovieCategory.CategoryNewMovie
    )
}