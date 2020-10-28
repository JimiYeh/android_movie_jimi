package com.example.movie.koin

import com.example.movie.repository.MovieRepo
import org.koin.dsl.module

val repositoryModule = module {
    factory { MovieRepo(get()) }
}