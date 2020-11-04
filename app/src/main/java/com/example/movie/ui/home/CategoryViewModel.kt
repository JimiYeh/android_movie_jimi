package com.example.movie.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.example.movie.repository.APIConfig
import com.example.movie.repository.MovieRepo
import com.example.movie.ui.home.adapter.MoviesAdapter
import com.example.movie.ui.home.vo.MovieCategory
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach

class CategoryViewModel(private val category: MovieCategory, private val movieRepo: MovieRepo) :
    ViewModel() {

    val flow = Pager(
        PagingConfig(pageSize = 20)
    ) {
        movieRepo.getCategoryMovies(category)
    }.flow
        .map { pagingData ->
            pagingData.filter { movie -> movie.id != null }
                .map {
                    MoviesAdapter.MovieInfoWrapper(it.copy(backdropPath = APIConfig.getConfig()?.getBackdropUrl(it.backdropPath)))
                }
        }.cachedIn(viewModelScope)
}