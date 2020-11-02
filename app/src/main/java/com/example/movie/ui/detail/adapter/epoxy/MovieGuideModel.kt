package com.example.movie.ui.detail.adapter.epoxy

import android.view.View
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.example.movie.R

@EpoxyModelClass
abstract class MovieGuideModel : EpoxyModelWithHolder<MovieGuideModel.Holder>() {

    @EpoxyAttribute
    var guide: String = ""

    override fun getDefaultLayout(): Int = R.layout.item_movie_guide

    override fun bind(holder: Holder) {
        super.bind(holder)
        holder.guide.text = guide
    }

    class Holder : EpoxyHolder() {

        lateinit var guide: TextView

        override fun bindView(itemView: View) {
            guide = itemView.findViewById(R.id.guide)
        }

    }
}