package com.example.movie.ui.detail.adapter.epoxy

import com.airbnb.epoxy.Carousel
import com.airbnb.epoxy.TypedEpoxyController
import com.airbnb.epoxy.carousel
import com.example.MovieApplication
import com.example.movie.R
import com.example.movie.model.response.Subject
import com.example.movie.util.toFormat
import java.util.*

class MovieDetailController : TypedEpoxyController<Subject>() {
    override fun buildModels(data: Subject?) {

        val context = MovieApplication.instance!!.applicationContext

        data?.let { subject ->

            movieDetailHeader {
                id("header")
                info(MovieDetailHeaderModel.Info(subject))
            }

            movieGuide {
                id("guide")
                guide(context.getString(R.string.test_guide))
            }

            movieDetailLabel {
                id("label_actor")
                label(context.getString(R.string.movie_detail_label_actor))
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
                label(context.getString(R.string.movie_detail_label_comment))
            }

            val comments = (0..100).mapIndexed { _, i ->
                movieComment {
                    id(i)
                    photoUrl("")
                    name("Jimi$i")
                    commentDate(Calendar.getInstance().time.toFormat())
                    likesCount(String.format(context.getString(R.string.movie_detail_comment_likes_format), i))
                    comment(context.getString(R.string.test_guide))
                }
            }
        }
    }
}