package com.example.movie.ui.detail.adapter.epoxy

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.bumptech.glide.Glide
import com.example.movie.R

@EpoxyModelClass
abstract class MovieCommentModel : EpoxyModelWithHolder<MovieCommentModel.Holder>() {

    @EpoxyAttribute
    lateinit var photoUrl: String

    @EpoxyAttribute
    lateinit var name: String

    @EpoxyAttribute
    lateinit var commentDate: String

    @EpoxyAttribute
    lateinit var likesCount: String

    @EpoxyAttribute
    lateinit var comment: String


    override fun getDefaultLayout(): Int = R.layout.item_movie_detail_comment

    override fun bind(holder: Holder) {
        super.bind(holder)

        Glide.with(holder.photo)
            .load(photoUrl)
            .centerCrop()
            .placeholder(R.drawable.ic_baseline_android_24)
            .into(holder.photo)

        holder.name.text = name
        holder.date.text = commentDate
        holder.likes.text = likesCount
        holder.comment.text = comment
    }


    class Holder : EpoxyHolder() {

        lateinit var photo: ImageView
        lateinit var name: TextView
        lateinit var date: TextView
        lateinit var likes: TextView
        lateinit var comment: TextView

        override fun bindView(itemView: View) {
            photo = itemView.findViewById(R.id.photo)
            name = itemView.findViewById(R.id.name)
            date = itemView.findViewById(R.id.date)
            likes = itemView.findViewById(R.id.likes)
            comment = itemView.findViewById(R.id.comment)
        }

    }
}