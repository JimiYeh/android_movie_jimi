package com.example.movie.model.response

import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class Subject(
    val alt: String = "",
    val casts: List<Cast> = listOf(),
    val collectCount: Int = 0,
    val directors: List<Director> = listOf(),
    val durations: List<String> = listOf(),
    val genres: List<String> = listOf(),
    val hasVideo: Boolean = false,
    val id: String = "",
    val images: Images = Images(),
    val mainlandPubdate: String = "",
    val originalTitle: String = "",
    val pubdates: List<String> = listOf(),
    val rating: Rating = Rating(),
    val subtype: String = "",
    val title: String = "",
    val year: String = ""
) {
    @JsonClass(generateAdapter = true)
    data class Cast(
        val alt: String? = null,
        val avatars: Avatars? = null,
        val id: String? = null,
        val name: String = "",
        val nameEn: String = ""
    ) {
        @JsonClass(generateAdapter = true)
        data class Avatars(
            val large: String = "",
            val medium: String = "",
            val small: String = ""
        )
    }

    @JsonClass(generateAdapter = true)
    data class Director(
        val alt: String? = null,
        val avatars: Avatars? = null,
        val id: String? = null,
        val name: String = "",
        val nameEn: String = ""
    ) {
        @JsonClass(generateAdapter = true)
        data class Avatars(
            val large: String = "",
            val medium: String = "",
            val small: String = ""
        )
    }

    @JsonClass(generateAdapter = true)
    data class Images(
        val large: String = "",
        val medium: String = "",
        val small: String = ""
    )

    @JsonClass(generateAdapter = true)
    data class Rating(
        val average: Double = 0.0,
        val details: Details = Details(),
        val max: Int = 0,
        val min: Int = 0,
        val stars: String = ""
    ) {
        @JsonClass(generateAdapter = true)
        data class Details(
            val x1: Double = 0.0,
            val x2: Double = 0.0,
            val x3: Double = 0.0,
            val x4: Double = 0.0,
            val x5: Double = 0.0
        )
    }
}


@JsonClass(generateAdapter = true)
data class NewMoviesResp(
    val subjects: List<Subject> = listOf(),
    val title: String = ""
)

@JsonClass(generateAdapter = true)
data class WeeklyMoviesResp(
    val subjects: List<WeeklySubject>,
    val title: String = ""
) {
    @JsonClass(generateAdapter = true)
    data class WeeklySubject(
        val delta: Int = 0,
        val rank: Int = 0,
        val subject: Subject = Subject()
    )
}


@JsonClass(generateAdapter = true)
data class USBoxMoviesResp(
    val date: String = "",
    val subjects: List<USBoxSubject> = listOf(),
    val title: String = ""
) {
    @JsonClass(generateAdapter = true)
    data class USBoxSubject(
        val box: Int = 0,
        val new: Boolean = false,
        val rank: Int = 0,
        val subject: Subject = Subject()
    )
}

@JsonClass(generateAdapter = true)
data class ComingSoonMoviesResp(
    val start: Int = 0,
    val count: Int = 0,
    val subjects: List<ComingSoonSubject> = listOf(),
    val title: String = ""
) {
    @JsonClass(generateAdapter = true)
    data class ComingSoonSubject(
        val subject: Subject = Subject()
    )
}

@JsonClass(generateAdapter = true)
data class InTheatersMoviesResp(
    val start: Int = 0,
    val count: Int = 0,
    val subjects: List<InTheatersSubject> = listOf(),
    val title: String = ""
) {
    @JsonClass(generateAdapter = true)
    data class InTheatersSubject(
        val subject: Subject = Subject()
    )
}

