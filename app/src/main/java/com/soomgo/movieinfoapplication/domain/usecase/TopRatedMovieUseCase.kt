package com.soomgo.movieinfoapplication.domain.usecase

import com.soomgo.movieinfoapplication.common.Resource
import com.soomgo.movieinfoapplication.data.dto.toMovie
import com.soomgo.movieinfoapplication.domain.model.Movie
import com.soomgo.movieinfoapplication.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class TopRatedMovieUseCase(private val repository : MovieRepository) {

    operator fun invoke() : Flow<Resource<List<Movie>>> = flow {
        try {
            emit(Resource.Loading())
            val movies = repository.fetchTopRatedMovie().results.map { it.toMovie() }
            emit(Resource.Success(movies))
        } catch (e : HttpException){
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e : HttpException){
            emit(Resource.Error(e.localizedMessage ?: "Couldn't reach server. Check your internet connection."))
        }
    }
}