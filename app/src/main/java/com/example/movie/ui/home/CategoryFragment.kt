package com.example.movie.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.paging.map
import com.example.movie.R
import com.example.movie.ui.home.adapter.MovieComparator
import com.example.movie.ui.home.adapter.MoviesAdapter
import com.example.movie.ui.home.vo.MovieCategory
import kotlinx.android.synthetic.main.fragment_category_movies.*
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import java.lang.RuntimeException

class CategoryFragment: Fragment() {

    companion object {
        private const val BUNDLE_CATEGORY = "BUNDLE_CATEGORY"
        fun newInstance(category: MovieCategory) = CategoryFragment()
            .apply {
                    val bundle = Bundle().apply {
                        putSerializable(BUNDLE_CATEGORY, category)
                    }
                    arguments = bundle
                }
    }

    private val viewModel: CategoryViewModel by viewModel{ parametersOf(arguments?.getSerializable(BUNDLE_CATEGORY) as? MovieCategory
        ?: throw RuntimeException("null argument"))}
    private val adapter by lazy { MoviesAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = LayoutInflater.from(context).inflate(R.layout.fragment_category_movies, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvMovies.adapter = adapter

        lifecycleScope.launch {

            viewModel.flow.collectLatest {
                adapter.submitData(it)
            }
        }
    }
}