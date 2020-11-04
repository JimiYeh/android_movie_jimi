package com.example.movie.model.response


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ConfigurationResp(
    @Json(name = "change_keys")
    val changeKeys: List<String>? = null,
    val images: Images? = null
) {
    @JsonClass(generateAdapter = true)
    data class Images(
        @Json(name = "backdrop_sizes")
        val backdropSizes: List<String>? = null,
        @Json(name = "base_url")
        val baseUrl: String? = null,
        @Json(name = "logo_sizes")
        val logoSizes: List<String>? = null,
        @Json(name = "poster_sizes")
        val posterSizes: List<String>? = null,
        @Json(name = "profile_sizes")
        val profileSizes: List<String>? = null,
        @Json(name = "secure_base_url")
        val secureBaseUrl: String? = null,
        @Json(name = "still_sizes")
        val stillSizes: List<String>? = null
    )

    fun getBackdropUrl(backdropPath: String?): String? {
        if (backdropPath == null)
            return null

        val baseUrl = images?.secureBaseUrl ?: return null
        val backdropSizes = images.backdropSizes?.get(0) ?: return null
        return "$baseUrl$backdropSizes$backdropPath"
    }
}