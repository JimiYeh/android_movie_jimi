package com.example.movie.ui.home

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.movie.R
import com.example.movie.ui.home.adapter.CategoryPageAdapter
import com.example.movie.ui.home.vo.MovieCategory
import com.example.movie.util.dpToPixel
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_movie_list.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_list)

        val categoryList = listOf(
            MovieCategory.CategoryNowPlaying,
            MovieCategory.CategoryUpcoming,
            MovieCategory.CategoryTopRated,
            MovieCategory.CategoryPopular,
        )

        movieCategoryViewPager.adapter =
            CategoryPageAdapter(
                this,
                categoryList)


        movieCategoryTabLayout.addOnTabSelectedListener(
            object: TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    val title = tab?.customView as? TextView
                    title?.textSize = dpToPixel(this@MainActivity, 16f)
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {

                    val title = tab?.customView as? TextView
                    title?.textSize = dpToPixel(this@MainActivity, 10f)
                }

                override fun onTabReselected(tab: TabLayout.Tab?) {

                }

            }
        )

        TabLayoutMediator(movieCategoryTabLayout, movieCategoryViewPager) { tab, position ->
            val title = TextView(this).apply {
                text = getString(categoryList[position].strResId)
            }
            tab.customView = title
        }.attach()


    }
}