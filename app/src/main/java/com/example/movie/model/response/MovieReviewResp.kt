package com.example.movie.model.response


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MovieReviewResp(
    val id: Int? = null,
    val page: Int? = null,
    val results: List<Result?>? = null,
    @Json(name = "total_pages")
    val totalPages: Int? = null,
    @Json(name = "total_results")
    val totalResults: Int? = null
) {
    @JsonClass(generateAdapter = true)
    data class Result(
        val author: String? = null,
        val content: String? = null,
        val id: String? = null,
        val url: String? = null
    )
}