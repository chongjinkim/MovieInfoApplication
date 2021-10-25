package com.soomgo.movieinfoapplication.data.repository

import com.soomgo.movieinfoapplication.data.dto.DetailResponse
import com.soomgo.movieinfoapplication.data.dto.MovieResponse
import com.soomgo.movieinfoapplication.data.dto.UpcomingResponse
import com.soomgo.movieinfoapplication.data.local.MovieDAO
import com.soomgo.movieinfoapplication.data.network.Client
import com.soomgo.movieinfoapplication.domain.model.Movie
import com.soomgo.movieinfoapplication.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow

class MovieRepositoryImpl(val client : Client, val dao : MovieDAO) : MovieRepository {

    override suspend fun fetchPopulartMovie(): MovieResponse  = client.TmdbAPI.getPopularMovies()

    override suspend fun fetchTopRatedMovie(): MovieResponse = client.TmdbAPI.getTopRatedMovies()

    override suspend fun fetchDetailMovie(id: String): DetailResponse = client.TmdbAPI.getDetailMovies(id)

    override suspend fun fetchUpComingMovie(): UpcomingResponse = client.TmdbAPI.getUpcomingMovies()

    override fun queryMovies(): Flow<List<Movie>> = dao.getMovies()

    override suspend fun queryMovie(movie: Movie): Flow<Movie>  = dao.getMovie(movie.id)

    override suspend fun insertMovie(movie: Movie) = dao.insertMovie(movie)

    override suspend fun deleteMovie(movie: Movie) = dao.deleteMovie(movie)


}

