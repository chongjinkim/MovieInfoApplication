package com.soomgo.movieinfoapplication.domain.usecase

import com.soomgo.movieinfoapplication.domain.model.Movie
import com.soomgo.movieinfoapplication.domain.repository.MovieRepository

class InsertMovieUseCase(private val repository: MovieRepository) {

    suspend operator fun invoke(movie : Movie) = repository.insertMovie(movie)
}