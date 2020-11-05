package com.example.movie.ui.detail.adapter.epoxy

import android.view.View
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.example.movie.R
import com.example.movie.util.toDecimalFormat

@EpoxyModelClass
abstract class MovieDetailRatingModel : EpoxyModelWithHolder<MovieDetailRatingModel.Holder>(){

    @EpoxyAttribute
    var voteAverage: Double? = null

    override fun getDefaultLayout(): Int = R.layout.item_movie_detail_score

    override fun bind(holder: Holder) {
        super.bind(holder)
        holder.voteAverage.text = voteAverage?.toDecimalFormat() ?: ""
    }


    class Holder : EpoxyHolder() {

        lateinit var voteAverage: TextView

        override fun bindView(itemView: View) {
            voteAverage = itemView.findViewById(R.id.voteAverage)
        }


    }
}