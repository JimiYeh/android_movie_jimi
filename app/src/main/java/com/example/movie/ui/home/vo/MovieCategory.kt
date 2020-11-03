package com.example.movie.ui.home.vo

import androidx.annotation.StringRes
import com.example.movie.R

enum class MovieCategory(@StringRes val strResId: Int, val type: String) {
    CategoryNowPlaying(R.string.category_now_playing, "Now Playing"),
    CategoryUpcoming(R.string.category_upcoming, "Upcoming"),
    CategoryTopRated(R.string.category_top_rated, "Top Rated"),
    CategoryPopular(R.string.category_popular, "Popular"),
}
