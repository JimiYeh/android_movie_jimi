package com.example.movie.model.response
import com.google.gson.annotations.SerializedName



//import com.squareup.moshi.Json
//import com.squareup.moshi.JsonClass
//
//@JsonClass(generateAdapter = true)
//data class MovieList(
//    @Json(name = "subjects")
//    val subjects: List<Subject>,
//    @Json(name = "title")
//    val title: String
//) {
//    @JsonClass(generateAdapter = true)
//    data class Subject(
//        @Json(name = "alt")
//        val alt: String,
//        @Json(name = "casts")
//        val casts: List<Cast>,
//        @Json(name = "collect_count")
//        val collectCount: Int,
//        @Json(name = "directors")
//        val directors: List<Director>,
//        @Json(name = "durations")
//        val durations: List<String>,
//        @Json(name = "genres")
//        val genres: List<String>,
//        @Json(name = "has_video")
//        val hasVideo: Boolean,
//        @Json(name = "id")
//        val id: String,
//        @Json(name = "images")
//        val images: Images,
//        @Json(name = "mainland_pubdate")
//        val mainlandPubdate: String,
//        @Json(name = "original_title")
//        val originalTitle: String,
//        @Json(name = "pubdates")
//        val pubdates: List<String>,
//        @Json(name = "rating")
//        val rating: Rating,
//        @Json(name = "subtype")
//        val subtype: String,
//        @Json(name = "title")
//        val title: String,
//        @Json(name = "year")
//        val year: String
//    ) {
//        @JsonClass(generateAdapter = true)
//        data class Cast(
//            @Json(name = "alt")
//            val alt: String,
//            @Json(name = "avatars")
//            val avatars: Avatars,
//            @Json(name = "id")
//            val id: String,
//            @Json(name = "name")
//            val name: String,
//            @Json(name = "name_en")
//            val nameEn: String
//        ) {
//            @JsonClass(generateAdapter = true)
//            data class Avatars(
//                @Json(name = "large")
//                val large: String,
//                @Json(name = "medium")
//                val medium: String,
//                @Json(name = "small")
//                val small: String
//            )
//        }
//
//        @JsonClass(generateAdapter = true)
//        data class Director(
//            @Json(name = "alt")
//            val alt: String,
//            @Json(name = "avatars")
//            val avatars: Avatars,
//            @Json(name = "id")
//            val id: String,
//            @Json(name = "name")
//            val name: String,
//            @Json(name = "name_en")
//            val nameEn: String
//        ) {
//            @JsonClass(generateAdapter = true)
//            data class Avatars(
//                @Json(name = "large")
//                val large: String,
//                @Json(name = "medium")
//                val medium: String,
//                @Json(name = "small")
//                val small: String
//            )
//        }
//
//        @JsonClass(generateAdapter = true)
//        data class Images(
//            @Json(name = "large")
//            val large: String,
//            @Json(name = "medium")
//            val medium: String,
//            @Json(name = "small")
//            val small: String
//        )
//
//        @JsonClass(generateAdapter = true)
//        data class Rating(
//            @Json(name = "average")
//            val average: Double,
//            @Json(name = "details")
//            val details: Details,
//            @Json(name = "max")
//            val max: Int,
//            @Json(name = "min")
//            val min: Int,
//            @Json(name = "stars")
//            val stars: String
//        ) {
//            @JsonClass(generateAdapter = true)
//            data class Details(
//                @Json(name = "1")
//                val x1: Double,
//                @Json(name = "2")
//                val x2: Double,
//                @Json(name = "3")
//                val x3: Double,
//                @Json(name = "4")
//                val x4: Double,
//                @Json(name = "5")
//                val x5: Double
//            )
//        }
//    }
//}

data class Subject(
    @SerializedName("alt")
    val alt: String = "",
    @SerializedName("casts")
    val casts: List<Cast> = listOf(),
    @SerializedName("collect_count")
    val collectCount: Int = 0,
    @SerializedName("directors")
    val directors: List<Director> = listOf(),
    @SerializedName("durations")
    val durations: List<String> = listOf(),
    @SerializedName("genres")
    val genres: List<String> = listOf(),
    @SerializedName("has_video")
    val hasVideo: Boolean = false,
    @SerializedName("id")
    val id: String = "",
    @SerializedName("images")
    val images: Images = Images(),
    @SerializedName("mainland_pubdate")
    val mainlandPubdate: String = "",
    @SerializedName("original_title")
    val originalTitle: String = "",
    @SerializedName("pubdates")
    val pubdates: List<String> = listOf(),
    @SerializedName("rating")
    val rating: Rating = Rating(),
    @SerializedName("subtype")
    val subtype: String = "",
    @SerializedName("title")
    val title: String = "",
    @SerializedName("year")
    val year: String = ""
) {
    data class Cast(
        @SerializedName("alt")
        val alt: String = "",
        @SerializedName("avatars")
        val avatars: Avatars = Avatars(),
        @SerializedName("id")
        val id: String = "",
        @SerializedName("name")
        val name: String = "",
        @SerializedName("name_en")
        val nameEn: String = ""
    ) {
        data class Avatars(
            @SerializedName("large")
            val large: String = "",
            @SerializedName("medium")
            val medium: String = "",
            @SerializedName("small")
            val small: String = ""
        )
    }

    data class Director(
        @SerializedName("alt")
        val alt: String = "",
        @SerializedName("avatars")
        val avatars: Avatars = Avatars(),
        @SerializedName("id")
        val id: String = "",
        @SerializedName("name")
        val name: String = "",
        @SerializedName("name_en")
        val nameEn: String = ""
    ) {
        data class Avatars(
            @SerializedName("large")
            val large: String = "",
            @SerializedName("medium")
            val medium: String = "",
            @SerializedName("small")
            val small: String = ""
        )
    }

    data class Images(
        @SerializedName("large")
        val large: String = "",
        @SerializedName("medium")
        val medium: String = "",
        @SerializedName("small")
        val small: String = ""
    )

    data class Rating(
        @SerializedName("average")
        val average: Double = 0.0,
        @SerializedName("details")
        val details: Details = Details(),
        @SerializedName("max")
        val max: Int = 0,
        @SerializedName("min")
        val min: Int = 0,
        @SerializedName("stars")
        val stars: String = ""
    ) {
        data class Details(
            @SerializedName("1")
            val x1: Double = 0.0,
            @SerializedName("2")
            val x2: Double = 0.0,
            @SerializedName("3")
            val x3: Double = 0.0,
            @SerializedName("4")
            val x4: Double = 0.0,
            @SerializedName("5")
            val x5: Double = 0.0
        )
    }
}

data class NewMoviesResp(
    @SerializedName("subjects")
    val subjects: List<Subject> = listOf(),
    @SerializedName("title")
    val title: String = ""
)


data class WeeklyMoviesResp(
    @SerializedName("subjects")
    val weeklySubjects: List<WeeklySubject> = listOf(),
    @SerializedName("title")
    val title: String = ""
) {
    data class WeeklySubject(
        @SerializedName("delta")
        val delta: Int = 0,
        @SerializedName("rank")
        val rank: Int = 0,
        @SerializedName("subject")
        val subject: Subject = Subject()
    )
}

data class USBoxMoviesResp(
    @SerializedName("date")
    val date: String = "",
    @SerializedName("subjects")
    val subjects: List<USBoxSubject> = listOf(),
    @SerializedName("title")
    val title: String = ""
) {
    data class USBoxSubject(
        @SerializedName("box")
        val box: Int = 0,
        @SerializedName("new")
        val new: Boolean = false,
        @SerializedName("rank")
        val rank: Int = 0,
        @SerializedName("subject")
        val subject: Subject = Subject()
    )
}

data class ComingSoonMoviesResp(
    @SerializedName("start")
    val start: Int = 0,
    @SerializedName("count")
    val count: Int = 0,
    @SerializedName("subjects")
    val comingSoonSubjects: List<ComingSoonSubject> = listOf(),
    @SerializedName("title")
    val title: String = ""
) {
    data class ComingSoonSubject(
        @SerializedName("subject")
        val subject: Subject = Subject()
    )
}

data class InTheatersMoviesResp(
    @SerializedName("start")
    val start: Int = 0,
    @SerializedName("count")
    val count: Int = 0,
    @SerializedName("subjects")
    val inTheatersSubjects: List<InTheatersSubject> = listOf(),
    @SerializedName("title")
    val title: String = ""
) {
    data class InTheatersSubject(
        @SerializedName("subject")
        val subject: Subject = Subject()
    )
}