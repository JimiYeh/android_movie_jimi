package com.example.movie.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.movie.R
import com.example.movie.ui.home.adapter.CategoryPageAdapter
import com.example.movie.ui.home.vo.MovieCategory
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_movie_list.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_list)

        val categoryList = listOf(
            MovieCategory.CategoryInTheaters,
            MovieCategory.CategoryComingSoon,
            MovieCategory.CategoryWeekly,
            MovieCategory.CategoryUSBox,
            MovieCategory.CategoryNewMovie,
        )

        movieCategoryViewPager.adapter =
            CategoryPageAdapter(
                this,
                categoryList)


        TabLayoutMediator(movieCategoryTabLayout, movieCategoryViewPager) { tab, position ->
            tab.text = getString(categoryList[position].strResId)
        }.attach()
    }


}