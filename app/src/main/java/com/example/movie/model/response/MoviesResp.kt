package com.example.movie.model.response


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MoviesResp(
    val dates: Dates = Dates(),
    val page: Int = 0,
    val results: List<Movie> = listOf(),
    @Json(name = "total_pages")
    val totalPages: Int = 0,
    @Json(name = "total_results")
    val totalResults: Int = 0
) {
    @JsonClass(generateAdapter = true)
    data class Dates(
        val maximum: String = "",
        val minimum: String = ""
    )

    @JsonClass(generateAdapter = true)
    data class Movie(
        val adult: Boolean = false,
        @Json(name = "backdrop_path")
        val backdropPath: String = "",
        @Json(name = "genre_ids")
        val genreIds: List<Int> = listOf(),
        val id: Int = 0,
        @Json(name = "original_language")
        val originalLanguage: String = "",
        @Json(name = "original_title")
        val originalTitle: String = "",
        val overview: String = "",
        val popularity: Double = 0.0,
        @Json(name = "poster_path")
        val posterPath: String = "",
        @Json(name = "release_date")
        val releaseDate: String = "",
        val title: String = "",
        val video: Boolean = false,
        @Json(name = "vote_average")
        val voteAverage: Double = 0.0,
        @Json(name = "vote_count")
        val voteCount: Int = 0
    )
}