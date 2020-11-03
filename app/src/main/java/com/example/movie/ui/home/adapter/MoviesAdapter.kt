package com.example.movie.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movie.R
import com.example.movie.model.response.MoviesResp
import com.example.movie.ui.detail.MovieDetailActivity
import kotlinx.android.synthetic.main.item_movies.view.*

object MovieComparator : DiffUtil.ItemCallback<MoviesAdapter.MovieInfoWrapper>() {
    override fun areItemsTheSame(
        oldItem: MoviesAdapter.MovieInfoWrapper,
        newItem: MoviesAdapter.MovieInfoWrapper
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: MoviesAdapter.MovieInfoWrapper,
        newItem: MoviesAdapter.MovieInfoWrapper
    ): Boolean {
        return oldItem == newItem
    }

}

class MoviesAdapter(diffCallback: DiffUtil.ItemCallback<MovieInfoWrapper>) : PagingDataAdapter<MoviesAdapter.MovieInfoWrapper, MoviesAdapter.ViewHolder>(diffCallback) {

    private val movies = mutableListOf<MovieInfoWrapper>()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(movieInfoWrapper: MovieInfoWrapper?) {

            val context = itemView.context

            Glide.with(context)
                .load(movieInfoWrapper?.banner ?: "")
                .centerCrop()
                .into(itemView.movieCover)


            itemView.movieName.text = movieInfoWrapper?.name ?: ""
            itemView.movieGenres.text = String.format(
                context.getString(R.string.movie_adapter_genres_format),
                movieInfoWrapper?.genres ?: ""
            )

            itemView.pubDate.text = String.format(
                context.getString(R.string.movie_adapter_pub_date_format),
                movieInfoWrapper?.pubDate ?: ""
            )

            itemView.movieDuration.text = String.format(
                context.getString(R.string.movie_adapter_duration_format),
                bindingAdapterPosition.toString()
            )

            itemView.setOnClickListener {
                context.startActivity(MovieDetailActivity.newIntent(context))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_movies, parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    data class MovieInfoWrapper(
        val id: Int,
        val banner: String,
        val name: String,
        val genres: String,
        val pubDate: String,
        val duration: String,
    ) {
        constructor(movie: MoviesResp.Movie) : this(
            movie.id!!,
            movie.posterPath ?: "",
            movie.title ?: "",
            "",
            movie.releaseDate ?: "",
            "",
        )
    }
}