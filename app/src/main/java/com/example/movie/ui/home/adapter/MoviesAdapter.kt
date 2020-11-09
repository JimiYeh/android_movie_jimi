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

class MoviesAdapter(diffCallback: DiffUtil.ItemCallback<MovieInfoWrapper> = MovieComparator) : PagingDataAdapter<MoviesAdapter.MovieInfoWrapper, MoviesAdapter.ViewHolder>(diffCallback) {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(movieInfoWrapper: MovieInfoWrapper?) {

            val context = itemView.context

            Glide.with(context)
                .load(movieInfoWrapper?.banner ?: "")
                .centerCrop()
                .into(itemView.movieCover)


            itemView.movieName.text = movieInfoWrapper?.name ?: ""

            itemView.pubDate.text = movieInfoWrapper?.pubDate ?: ""

            itemView.overview.text = movieInfoWrapper?.overview

            itemView.rate.rating = movieInfoWrapper?.score?.toFloat() ?: 0f


            itemView.setOnClickListener {
                movieInfoWrapper?.id?.let {
                    context.startActivity(MovieDetailActivity.newIntent(context, it))
                }

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
        val score: Double?,
        val pubDate: String,
        val overview: String,
    ) {
        constructor(movie: MoviesResp.Movie) : this(
            movie.id!!,
            movie.backdropPath ?: "",
            movie.title ?: "",
            movie.voteAverage,
            movie.releaseDate ?: "",
            movie.overview ?: "",
        )
    }
}