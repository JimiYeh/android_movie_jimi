package com.example.movie.ui.detail.adapter.epoxy

import android.view.View
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.example.movie.R

@EpoxyModelClass
abstract class MovieDetailLabel : EpoxyModelWithHolder<MovieDetailLabel.Holder>() {

    @EpoxyAttribute
    lateinit var label: String

    override fun getDefaultLayout(): Int = R.layout.item_movie_detail_label

    override fun bind(holder: Holder) {
        super.bind(holder)
        holder.label.text = label
    }

    class Holder : EpoxyHolder() {
        lateinit var label: TextView
        override fun bindView(itemView: View) {
            label = itemView.findViewById(R.id.label)
        }
    }
}