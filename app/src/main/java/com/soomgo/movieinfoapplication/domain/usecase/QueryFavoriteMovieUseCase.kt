package com.soomgo.movieinfoapplication.domain.usecase

import com.soomgo.movieinfoapplication.domain.model.Movie
import com.soomgo.movieinfoapplication.domain.repository.MovieRepository

class QueryFavoriteMovieUseCase(private val repository: MovieRepository) {

    suspend operator fun invoke(movie : Movie) = repository.queryMovie(movie)
}