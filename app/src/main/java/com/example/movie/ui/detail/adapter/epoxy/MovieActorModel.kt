package com.example.movie.ui.detail.adapter.epoxy

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.movie.R

@EpoxyModelClass
abstract class MovieActorModel : EpoxyModelWithHolder<MovieActorModel.Holder>() {

    @EpoxyAttribute
    lateinit var photoUrl: String
    @EpoxyAttribute
    lateinit var name: String


    override fun getDefaultLayout(): Int = R.layout.item_movie_detail_actor

    override fun bind(holder: Holder) {
        super.bind(holder)

        Glide.with(holder.photo)
            .load(photoUrl)
            .transform(CenterCrop(), RoundedCorners(16))
            .into(holder.photo)

        holder.name.text = name
    }

    class Holder : EpoxyHolder() {

        lateinit var photo: ImageView
        lateinit var name: TextView

        override fun bindView(itemView: View) {
            photo = itemView.findViewById(R.id.photo)
            name = itemView.findViewById(R.id.name)
        }

    }
}