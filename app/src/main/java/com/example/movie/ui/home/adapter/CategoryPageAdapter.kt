package com.example.movie.ui.home.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.movie.ui.home.CategoryFragment
import com.example.movie.ui.home.vo.MovieCategory

class CategoryPageAdapter(fragmentActivity: FragmentActivity, private val list: List<MovieCategory>) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = list.size

    override fun createFragment(position: Int): Fragment = CategoryFragment.newInstance(list[position])

}