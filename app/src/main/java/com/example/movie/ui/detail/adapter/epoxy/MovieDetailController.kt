package com.example.movie.ui.detail.adapter.epoxy

import com.airbnb.epoxy.Carousel
import com.airbnb.epoxy.TypedEpoxyController
import com.airbnb.epoxy.carousel
import com.example.movie.R
import com.example.movie.model.response.Subject
import com.example.movie.util.toFormat
import java.util.*

class MovieDetailController : TypedEpoxyController<Subject>() {
    override fun buildModels(data: Subject?) {

        data?.let { subject ->

            movieDetailHeaderWithRatingBar {
                id("header")
                info(MovieDetailHeaderWithRatingBarModel.Info(subject))
            }

            movieDetailLabel {
                id("label_guide")
                resIdLabel(R.string.movie_detail_label_guide)
            }

            movieGuide {
                id("guide")
                guide("劇情描述27歲上班族黃雨萱，因對前男友的思念，意外靈魂穿越回到1998年台南，變成17歲的女高中生陳韻如，卻遇見和前男友長得一模一樣的李子維，以及始終暗戀著陳韻如的暖男莫俊傑，展開一連串浪漫虐心又懸疑難解的故事。")
            }

            movieDetailLabel {
                id("label_actor")
                resIdLabel(R.string.movie_detail_label_actor)
            }

            val models = subject.casts.map {
                MovieActorModel_()
                    .id(it.name)
                    .name(it.name)
                    .photoUrl(it.avatars?.small ?: "")
            }

            carousel {
                id("actors")
                padding(Carousel.Padding.dp(8, 8, 8, 8, 4))
                hasFixedSize(true)
                models(models)
            }

            movieDetailLabel {
                id("comment")
                resIdLabel(R.string.movie_detail_label_comment)
            }

            val comments = (0..100).mapIndexed { _, i ->
                movieComment {
                    id(i)
                    photoUrl("")
                    name("Jimi$i")
                    commentDate(Calendar.getInstance().time.toFormat())
                    likesCount(i)
                    comment("劇情描述27歲上班族黃雨萱，因對前男友的思念，意外靈魂穿越回到1998年台南，變成17歲的女高中生陳韻如，卻遇見和前男友長得一模一樣的李子維，以及始終暗戀著陳韻如的暖男莫俊傑，展開一連串浪漫虐心又懸疑難解的故事。")
                }
            }
        }
    }
}