package com.example.movie.ui.detail

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.setPadding
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.movie.R
import com.example.movie.repository.APIConfig
import com.example.movie.ui.detail.adapter.epoxy.MovieDetailController
import com.example.movie.util.toDate
import com.example.movie.util.toFormat
import kotlinx.android.synthetic.main.activity_movie_detail.*
import kotlinx.android.synthetic.main.movie_detail_header.*
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.core.parameter.parametersOf


class MovieDetailActivity : AppCompatActivity() {

    companion object {

        private const val BUNDLE_MOVIE_ID = "BUNDLE_ID"

        fun newIntent(context: Context, id: Int) =
            Intent(context, MovieDetailActivity::class.java).apply {
                putExtra(BUNDLE_MOVIE_ID, id)
            }
    }

    private val id: Int by lazy { intent.getIntExtra(BUNDLE_MOVIE_ID, -1) }
    private lateinit var viewModel: MovieDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = Color.TRANSPARENT

        setContentView(R.layout.activity_movie_detail)

        if (id == -1) throw RuntimeException("null movie id")

        back.setOnClickListener {
            onBackPressed()
        }

        viewModel = getViewModel { parametersOf(id) }

        val controller = MovieDetailController()
        content.setController(controller)


        viewModel.detail.observe(this, Observer { movieDetailResp ->
            controller.setData(MovieDetailController.Data(movieDetailResp, viewModel.reviews.value))

            movieDetailResp?.let {

                lifecycleScope.launch {
                    val url = APIConfig.getConfig()?.getBackdropUrl(it.backdropPath)
                    url.let { imageUrl ->
                        Glide.with(banner)
                            .load(imageUrl)
                            .centerCrop()
                            .into(banner)
                    }
                }
                movieTitle.text = it.title ?: ""

                it.releaseDate?.toDate("yyyy-MM-dd")?.toFormat("yyyy")?.let { date ->
                    pubYear.text =
                        String.format(getString(R.string.movie_detail_pub_year_format), date)
                }

                it.genres?.filterNotNull()?.mapNotNull { genre ->
                    genre.name
                }?.take(2)?.forEach { genreName ->
                    genresContainer.addView(TextView(this).apply {
                        text = genreName
                        setTextColor(getColor(android.R.color.white))
                        setBackgroundResource(R.drawable.movie_detail_genre_background)
                        layoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                            .apply {
                                setPadding(20)
                                marginEnd = 40
                            }
                    })
                }
            }

        })

        viewModel.reviews.observe(this, Observer {
            controller.setData(MovieDetailController.Data(viewModel.detail.value, it))
        })
    }


}