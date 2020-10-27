package com.example.movie.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.movie.R
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_movie_list.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MovieListViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_list)

        vpMovie.adapter = CategoryPageAdapter(this, viewModel.categoryList.map { it.apiPath })


        TabLayoutMediator(tlCategory, vpMovie) { tab, position ->
            tab.text = getString(viewModel.categoryList[position].strResId)
        }.attach()
    }

    class CategoryPageAdapter(fragmentActivity: FragmentActivity, private val list: List<String>) : FragmentStateAdapter(fragmentActivity) {
        override fun getItemCount(): Int = list.size

        override fun createFragment(position: Int): Fragment = CategoryFragment.newInstance(list[position])

    }
}