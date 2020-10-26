package com.example.movie.koin

import com.example.movie.ui.MovieListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { MovieListViewModel() }
}