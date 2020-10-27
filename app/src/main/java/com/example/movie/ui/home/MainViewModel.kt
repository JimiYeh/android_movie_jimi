package com.example.movie.ui.home

import androidx.lifecycle.ViewModel
import com.example.movie.ui.home.vo.MovieCategory

class MainViewModel : ViewModel() {

    val categoryList = listOf(
        MovieCategory.CategoryInTheaters,
        MovieCategory.CategoryComingSoon,
        MovieCategory.CategoryWeekly,
        MovieCategory.CategoryUSBox,
        MovieCategory.CategoryNewMovie,
    )
}