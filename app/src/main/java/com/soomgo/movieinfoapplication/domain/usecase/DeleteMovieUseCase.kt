package com.soomgo.movieinfoapplication.domain.usecase

import com.soomgo.movieinfoapplication.domain.model.Movie
import com.soomgo.movieinfoapplication.domain.repository.MovieRepository

class DeleteMovieUseCase(private val repository: MovieRepository) {

    suspend operator fun invoke(movie : Movie) = repository.deleteMovie(movie)
}