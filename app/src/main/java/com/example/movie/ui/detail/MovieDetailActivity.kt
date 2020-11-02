package com.example.movie.ui.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.movie.R
import com.example.movie.model.response.Subject
import com.example.movie.ui.detail.adapter.epoxy.MovieDetailController
import kotlinx.android.synthetic.main.activity_movie_detail.*
import java.lang.RuntimeException

class MovieDetailActivity : AppCompatActivity() {

    companion object {

        private const val BUNDLE_SUBJECT = "BUNDLE_SUBJECT"

        fun newIntent(context: Context, subject: Subject) = Intent(context, MovieDetailActivity::class.java).apply {
            putExtra(BUNDLE_SUBJECT, subject)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_movie_detail)

        val subject = intent.getSerializableExtra(BUNDLE_SUBJECT) as? Subject ?: throw RuntimeException("null subject !")

        supportActionBar?.apply {
            title = subject.title
            setDisplayHomeAsUpEnabled(true)
            setHomeButtonEnabled(true)
            setDisplayShowHomeEnabled(true)
        }


        val controller = MovieDetailController()
        container.setController(controller)
        controller.setData(subject)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else ->
                super.onOptionsItemSelected(item)
        }
    }
}