package com.example.movie.ui.home.vo

import androidx.annotation.StringRes
import com.example.movie.R

enum class MovieCategory(@StringRes val strResId: Int, val apiPath: String) {
    CategoryInTheaters(R.string.category_in_theaters, "in_theaters"),
    CategoryComingSoon(R.string.category_coming_soon, "coming_soon"),
    CategoryWeekly(R.string.category_weekly, "weekly"),
    CategoryUSBox(R.string.category_us_box, "us_box"),
    CategoryNewMovie(R.string.category_new_movies, "new_movies"),
}
