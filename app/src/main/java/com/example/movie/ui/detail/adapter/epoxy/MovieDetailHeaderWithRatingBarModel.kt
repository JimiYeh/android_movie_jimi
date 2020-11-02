package com.example.movie.ui.detail.adapter.epoxy

import android.view.View
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.bumptech.glide.Glide
import com.example.movie.R
import com.example.movie.model.response.Subject
import com.example.movie.util.toDecimalFormat

@EpoxyModelClass
abstract class MovieDetailHeaderWithRatingBarModel : EpoxyModelWithHolder<MovieDetailHeaderWithRatingBarModel.Holder>() {

    @EpoxyAttribute
    lateinit var info: Info

    override fun getDefaultLayout(): Int = R.layout.item_movie_detail_header_with_rating_bar

    override fun bind(holder: Holder) {
        super.bind(holder)
        with(info) {

            val context = holder.movieCover.context

            Glide.with(context)
                .load(cover)
                .centerCrop()
                .into(holder.movieCover)

            holder.director.text = String.format(context.getString(R.string.movie_detail_director_format), director)
            holder.actor.text = String.format(context.getString(R.string.movie_detail_actor_format), actor)
            holder.genres.text = String.format(context.getString(R.string.movie_detail_genres_format), genres)
            holder.pubYear.text = String.format(context.getString(R.string.movie_detail_pub_year_format), pubYear)
            holder.country.text = String.format(context.getString(R.string.movie_detail_country_format), country)
            holder.score.text = String.format(context.getString(R.string.movie_detail_score_format), score.toDecimalFormat())
            holder.ratingBar.rating = (score/2).toFloat()
        }
    }

    class Holder : EpoxyHolder() {

        lateinit var movieCover: ImageView
        lateinit var director: TextView
        lateinit var actor: TextView
        lateinit var genres: TextView
        lateinit var pubYear: TextView
        lateinit var country: TextView
        lateinit var score: TextView
        lateinit var ratingBar: RatingBar

        override fun bindView(itemView: View) {
            movieCover = itemView.findViewById(R.id.movieCover)
            director = itemView.findViewById(R.id.director)
            actor = itemView.findViewById(R.id.actor)
            genres = itemView.findViewById(R.id.genres)
            pubYear = itemView.findViewById(R.id.pubYear)
            country = itemView.findViewById(R.id.country)
            score = itemView.findViewById(R.id.label)
            ratingBar = itemView.findViewById(R.id.ratingBar)
        }
    }

    data class Info(
        val cover: String,
        val director: String,
        val actor: String,
        val genres: String,
        val pubYear: String,
        val country: String = "",
        val score: Double,
    ) {
        constructor(subject: Subject): this(
            cover = subject.images.small,
            director = if (subject.directors.isNotEmpty()) subject.directors[0].name else "",
            actor = subject.casts.joinToString(separator = "/") { it.name },
            genres = subject.genres.joinToString(separator = "/"),
            pubYear = subject.year,
            score = subject.rating.average
        )
    }
}