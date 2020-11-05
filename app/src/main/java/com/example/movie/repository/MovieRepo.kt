package com.example.movie.repository


import androidx.paging.PagingSource
import com.example.movie.BuildConfig
import com.example.movie.model.response.MoviesResp
import com.example.movie.service.MovieService
import com.example.movie.ui.home.vo.MovieCategory
import retrofit2.Response
import java.lang.RuntimeException

class MovieRepo(private val service: MovieService) {

    var sourceMap = mutableMapOf<String, MoviePagingSource>()

    fun getCategoryMovies(category: MovieCategory): MoviePagingSource {
        return sourceMap[category.type] ?: MoviePagingSource(getMovieApiByCategory(category)).also {
            sourceMap[category.type] = it
        }
    }

    private fun getMovieApiByCategory(category: MovieCategory): suspend (String, Int) -> Response<MoviesResp> {

        return when (category) {

            MovieCategory.CategoryNowPlaying -> { language, pageNumber ->
                service.getNowPlayingMovies(
                    language,
                    pageNumber
                )
            }
            MovieCategory.CategoryUpcoming -> { language, pageNumber ->
                service.getUpcomingMovies(
                    language,
                    pageNumber
                )
            }
            MovieCategory.CategoryTopRated -> { language, pageNumber ->
                service.getNowPlayingMovies(
                    language,
                    pageNumber
                )
            }
            MovieCategory.CategoryPopular -> { language, pageNumber ->
                service.getPopularMovies(
                    language,
                    pageNumber
                )
            }
        }
    }


    suspend fun getMovieDetail(id: Int) = callApi { service.getMovieDetail(id) }

    suspend fun getMovieReviews(id: Int) = callApi { service.getMovieReviews(id) }


    class MoviePagingSource(val func: suspend (String, Int) -> Response<MoviesResp>) :
        PagingSource<Int, MoviesResp.Movie>() {

        override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MoviesResp.Movie> {
            try {
                val pageNumber = params.key ?: 1
                val response = func(BuildConfig.LANGUAGE, pageNumber)
                if (response.isSuccessful) {

                    val resp = response.body()
                        ?: return LoadResult.Error(RuntimeException("null movie list response"))

                    resp.totalPages?.let {
                        return LoadResult.Page(
                            data = resp.results ?: listOf(),
                            prevKey = null,
                            nextKey = if (pageNumber == resp.totalPages) null else pageNumber + 1
                        )
                    } ?: return LoadResult.Page(
                        data = resp.results ?: listOf(),
                        prevKey = null,
                        nextKey = null
                    )
                } else {
                    return LoadResult.Error(RuntimeException("api fail"))
                }
            } catch (e: Exception) {
                return LoadResult.Error(e)
            }
        }
    }
}