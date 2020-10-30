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
        holder.guideLabel.text = holder.guideLabel.context.getString(R.string.movie_detail_label_guide)
        holder.guide.text = guide
    }

    class Holder : EpoxyHolder() {

        lateinit var guideLabel: TextView
        lateinit var guide: TextView

        override fun bindView(itemView: View) {
            guideLabel = itemView.findViewById(R.id.label)
            guide = itemView.findViewById(R.id.guide)
        }

    }
}