package com.example.movie.model.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class Subject(
    @Json(name = "alt")
    val alt: String = "",
    @Json(name = "casts")
    val casts: List<Cast> = listOf(),
    @Json(name = "collect_count")
    val collectCount: Int = 0,
    @Json(name = "directors")
    val directors: List<Director> = listOf(),
    @Json(name = "durations")
    val durations: List<String> = listOf(),
    @Json(name = "genres")
    val genres: List<String> = listOf(),
    @Json(name = "has_video")
    val hasVideo: Boolean = false,
    @Json(name = "id")
    val id: String = "",
    @Json(name = "images")
    val images: Images = Images(),
    @Json(name = "mainland_pubdate")
    val mainlandPubdate: String = "",
    @Json(name = "original_title")
    val originalTitle: String = "",
    @Json(name = "pubdates")
    val pubdates: List<String> = listOf(),
    @Json(name = "rating")
    val rating: Rating = Rating(),
    @Json(name = "subtype")
    val subtype: String = "",
    @Json(name = "title")
    val title: String = "",
    @Json(name = "year")
    val year: String = ""
) {
    @JsonClass(generateAdapter = true)
    data class Cast(
        @Json(name = "alt")
        val alt: String? = null,
        @Json(name = "avatars")
        val avatars: Avatars? = null,
        @Json(name = "id")
        val id: String? = null,
        @Json(name = "name")
        val name: String = "",
        @Json(name = "name_en")
        val nameEn: String = ""
    ) {
        @JsonClass(generateAdapter = true)
        data class Avatars(
            @Json(name = "large")
            val large: String = "",
            @Json(name = "medium")
            val medium: String = "",
            @Json(name = "small")
            val small: String = ""
        )
    }

    @JsonClass(generateAdapter = true)
    data class Director(
        @Json(name = "alt")
        val alt: String? = null,
        @Json(name = "avatars")
        val avatars: Avatars? = null,
        @Json(name = "id")
        val id: String? = null,
        @Json(name = "name")
        val name: String = "",
        @Json(name = "name_en")
        val nameEn: String = ""
    ) {
        @JsonClass(generateAdapter = true)
        data class Avatars(
            @Json(name = "large")
            val large: String = "",
            @Json(name = "medium")
            val medium: String = "",
            @Json(name = "small")
            val small: String = ""
        )
    }

    @JsonClass(generateAdapter = true)
    data class Images(
        @Json(name = "large")
        val large: String = "",
        @Json(name = "medium")
        val medium: String = "",
        @Json(name = "small")
        val small: String = ""
    )

    @JsonClass(generateAdapter = true)
    data class Rating(
        @Json(name = "average")
        val average: Double = 0.0,
        @Json(name = "details")
        val details: Details = Details(),
        @Json(name = "max")
        val max: Int = 0,
        @Json(name = "min")
        val min: Int = 0,
        @Json(name = "stars")
        val stars: String = ""
    ) {
        @JsonClass(generateAdapter = true)
        data class Details(
            @Json(name = "1")
            val x1: Double = 0.0,
            @Json(name = "2")
            val x2: Double = 0.0,
            @Json(name = "3")
            val x3: Double = 0.0,
            @Json(name = "4")
            val x4: Double = 0.0,
            @Json(name = "5")
            val x5: Double = 0.0
        )
    }
}


@JsonClass(generateAdapter = true)
data class NewMoviesResp(
    @Json(name = "subjects")
    val subjects: List<Subject> = listOf(),
    @Json(name = "title")
    val title: String = ""
)

@JsonClass(generateAdapter = true)
data class WeeklyMoviesResp(
    @Json(name = "subjects")
    val subjects: List<WeeklySubject>,
    @Json(name = "title")
    val title: String = ""
) {
    @JsonClass(generateAdapter = true)
    data class WeeklySubject(
        @Json(name = "delta")
        val delta: Int = 0,
        @Json(name = "rank")
        val rank: Int = 0,
        @Json(name = "subject")
        val subject: Subject = Subject()
    )
}


@JsonClass(generateAdapter = true)
data class USBoxMoviesResp(
    @Json(name = "date")
    val date: String = "",
    @Json(name = "subjects")
    val subjects: List<USBoxSubject> = listOf(),
    @Json(name = "title")
    val title: String = ""
) {
    @JsonClass(generateAdapter = true)
    data class USBoxSubject(
        @Json(name = "box")
        val box: Int = 0,
        @Json(name = "new")
        val new: Boolean = false,
        @Json(name = "rank")
        val rank: Int = 0,
        @Json(name = "subject")
        val subject: Subject = Subject()
    )
}

@JsonClass(generateAdapter = true)
data class ComingSoonMoviesResp(
    @Json(name = "start")
    val start: Int = 0,
    @Json(name = "count")
    val count: Int = 0,
    @Json(name = "subjects")
    val comingSoonSubjects: List<ComingSoonSubject> = listOf(),
    @Json(name = "title")
    val title: String = ""
) {
    @JsonClass(generateAdapter = true)
    data class ComingSoonSubject(
        @Json(name = "subject")
        val subject: Subject = Subject()
    )
}

@JsonClass(generateAdapter = true)
data class InTheatersMoviesResp(
    @Json(name = "start")
    val start: Int = 0,
    @Json(name = "count")
    val count: Int = 0,
    @Json(name = "subjects")
    val inTheatersSubjects: List<InTheatersSubject> = listOf(),
    @Json(name = "title")
    val title: String = ""
) {
    @JsonClass(generateAdapter = true)
    data class InTheatersSubject(
        @Json(name = "subject")
        val subject: Subject = Subject()
    )
}

