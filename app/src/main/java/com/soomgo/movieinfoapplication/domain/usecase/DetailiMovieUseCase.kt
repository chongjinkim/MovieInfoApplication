package com.soomgo.movieinfoapplication.domain.usecase

import com.soomgo.movieinfoapplication.common.Resource
import com.soomgo.movieinfoapplication.data.dto.toMovieDetail
import com.soomgo.movieinfoapplication.domain.model.Movie
import com.soomgo.movieinfoapplication.domain.model.MovieDetail
import com.soomgo.movieinfoapplication.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class DetailiMovieUseCase(private val repository : MovieRepository) {

    operator fun invoke(movie : Movie) : Flow<Resource<MovieDetail>> = flow {

        try {
            emit(Resource.Loading())
            val movieDetail = repository.fetchDetailMovie(movie.id.toString()).toMovieDetail()
            emit(Resource.Success(movieDetail))
        } catch (e : HttpException){
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e : HttpException){
            emit(Resource.Error(e.localizedMessage ?: "Couldn't reach server. Check your internet connection."))
        }
    }
}