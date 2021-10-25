package com.soomgo.movieinfoapplication.data.network

import com.soomgo.movieinfoapplication.data.dto.DetailResponse
import com.soomgo.movieinfoapplication.data.dto.MovieResponse
import com.soomgo.movieinfoapplication.data.dto.UpcomingResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface tmdbAPI {

    @GET("/3/movie/popular")
    suspend fun getPopularMovies() : MovieResponse

    @GET("/3/movie/top_rated")
    suspend fun getTopRatedMovies() : MovieResponse

    @GET("3/movie/upcoming")
    suspend fun getUpcomingMovies() : UpcomingResponse

    @GET("/3/movie/{id}")
    suspend fun getDetailMovies(@Path("id") id : String) : DetailResponse
}