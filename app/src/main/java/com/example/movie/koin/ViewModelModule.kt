package com.example.movie.koin

import com.example.movie.ui.home.CategoryViewModel
import com.example.movie.ui.home.MainViewModel
import com.example.movie.ui.home.vo.MovieCategory
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { MainViewModel() }

    viewModel { (category: MovieCategory) -> CategoryViewModel(category, get()) }
}