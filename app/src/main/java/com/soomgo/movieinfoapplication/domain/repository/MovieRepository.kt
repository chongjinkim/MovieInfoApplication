package com.soomgo.movieinfoapplication.domain.repository

import com.soomgo.movieinfoapplication.data.dto.DetailResponse
import com.soomgo.movieinfoapplication.data.dto.MovieResponse
import com.soomgo.movieinfoapplication.data.dto.UpcomingResponse
import com.soomgo.movieinfoapplication.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    suspend fun fetchPopulartMovie() : MovieResponse

    suspend fun fetchTopRatedMovie() : MovieResponse

    suspend fun fetchDetailMovie(id : String) : DetailResponse

    suspend fun fetchUpComingMovie() : UpcomingResponse


    //dao 쪽으로 repositoryimpl에 return으로 넣을거기 때문에 함수 파라미터로 movie를 넣었다.
    fun queryMovies() : Flow<List<Movie>>

    suspend fun queryMovie(movie : Movie) : Flow<Movie>

    suspend fun insertMovie(movie : Movie)

    suspend fun deleteMovie(movie : Movie)


}