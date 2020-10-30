package com.example.movie.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movie.R
import com.example.movie.model.response.Subject
import com.example.movie.ui.detail.MovieDetailActivity
import kotlinx.android.synthetic.main.item_movies.view.*

class MoviesAdapter : RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    private val movies = mutableListOf<MovieInfoWrapper>()

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(movieInfoWrapper: MovieInfoWrapper) {

            val context = itemView.context

            Glide.with(context)
                .load(movieInfoWrapper.banner)
                .centerCrop()
                .into(itemView.movieCover)


            itemView.movieName.text = movieInfoWrapper.name
            itemView.movieGenres.text = String.format(
                context.getString(R.string.movie_adapter_genres_format),
                movieInfoWrapper.genres
            )

            itemView.pubDate.text = String.format(
                context.getString(R.string.movie_adapter_pub_date_format),
                movieInfoWrapper.pubDate
            )

            itemView.movieDuration.text = String.format(
                context.getString(R.string.movie_adapter_duration_format),
                movieInfoWrapper.duration
            )

            itemView.setOnClickListener {
                context.startActivity(MovieDetailActivity.newIntent(context, movies[adapterPosition].subject))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_movies, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    fun setMovies(list: List<Subject>?) {
        movies.clear()
        list?.let { movieList ->
            movies.addAll(movieList.map { MovieInfoWrapper(it) })
        }
        notifyDataSetChanged()
    }


    data class MovieInfoWrapper(
        val banner: String,
        val name: String,
        val genres: String,
        val pubDate: String,
        val duration: String,
        val subject: Subject
    ) {
        constructor(subject: Subject) : this(
            subject.images.small,
            subject.title,
            subject.genres.joinToString(separator = "/"),
            subject.mainlandPubdate,
            if (subject.durations.isNotEmpty()) subject.durations[0] else "",
            subject
        )
    }
}