package com.example.movie.ui.home

import androidx.fragment.app.Fragment

class CategoryFragment: Fragment() {

    companion object {
        private const val BUNDLE_CATEGORY = "BUNDLE_CATEGORY"
        fun newInstance(category: String) = CategoryFragment()
            .apply {
                    arguments?.putString(BUNDLE_CATEGORY, category)
                }
    }
}