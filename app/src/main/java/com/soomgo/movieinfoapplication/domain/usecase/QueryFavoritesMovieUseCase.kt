package com.soomgo.movieinfoapplication.domain.usecase

import com.soomgo.movieinfoapplication.domain.repository.MovieRepository

class QueryFavoritesMovieUseCase(private val repository : MovieRepository) {

    suspend operator fun invoke() = repository.queryMovies()

}