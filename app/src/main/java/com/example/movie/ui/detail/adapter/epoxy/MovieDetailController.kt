package com.example.movie.ui.detail.adapter.epoxy

import com.airbnb.epoxy.TypedEpoxyController
import com.example.movie.R
import com.example.movie.model.response.MovieDetailResp
import com.example.movie.model.response.MovieReviewResp

class MovieDetailController : TypedEpoxyController<MovieDetailController.Data>() {
    override fun buildModels(data: MovieDetailController.Data?) {

        data?.let {

            it.detail?.let {

                movieDetailRating {
                    id("rating")
                    voteAverage(it.voteAverage)
                }

                movieDetailLabel {
                    id("label_guide")
                    resIdLabel(R.string.movie_detail_label_guide)
                }


                movieGuide {
                    id("guide")
                    guide(it.overview ?: "")
                }
            }

            movieDetailLabel {
                id("comment")
                resIdLabel(R.string.movie_detail_label_comment)
            }

            it.reviews?.results?.let {  results ->

                results.mapIndexed { index, result ->
                    movieComment {
                        id(index)
                        photoUrl("")
                        name(result?.author ?: "")
                        comment(result?.content ?: "")
                    }
                }
            }

        }
    }


    data class Data(val detail: MovieDetailResp?, val reviews: MovieReviewResp?)
}