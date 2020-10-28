package com.example.movie.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movie.R
import com.example.movie.model.response.NewMoviesResp
import com.example.movie.model.response.Subject
import kotlinx.android.synthetic.main.adapter_movies.view.*

class MoviesAdapter : RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    private val movies = mutableListOf<MovieInfoWrapper>()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(movieInfoWrapper: MovieInfoWrapper) {

            val context = itemView.context


            Glide.with(context)
                .load(movieInfoWrapper.banner)
                .centerCrop()
                .into(itemView.ivMovieBanner)


            itemView.tvMovieName.text = movieInfoWrapper.name
            itemView.tvMovieGenres.text = String.format(
                context.getString(R.string.movie_adapter_genres),
                movieInfoWrapper.genres
            )

            itemView.tvPubDate.text = String.format(
                context.getString(R.string.movie_adapter_pub_date),
                movieInfoWrapper.pubDate
            )

            itemView.tvMovieDuration.text = String.format(
                context.getString(R.string.movie_adapter_duration),
                movieInfoWrapper.duration
            )
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.adapter_movies, parent, false)
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
        val duration: String
    ) {
        constructor(subject: Subject) : this(
            subject.images.small,
            subject.title,
            if (subject.genres.isNotEmpty()) subject.genres.reduce { result, element -> "$result/$element" } else "",
            subject.mainlandPubdate,
            if (subject.durations.isNotEmpty()) subject.durations[0] else ""
        )
    }
}