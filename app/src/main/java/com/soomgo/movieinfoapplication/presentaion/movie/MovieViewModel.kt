package com.soomgo.movieinfoapplication.presentaion.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.soomgo.movieinfoapplication.domain.model.Movie
import com.soomgo.movieinfoapplication.domain.usecase.PopularMovieUseCase
import com.soomgo.movieinfoapplication.domain.usecase.TopRatedMovieUseCase
import com.soomgo.movieinfoapplication.domain.usecase.UpcomingMovieUseCase
import kotlinx.coroutines.flow.collectLatest

class MovieViewModel(private val upcomingMovieUseCase: UpcomingMovieUseCase,
                     private val topRatedMovieUseCase: TopRatedMovieUseCase,
                     private val popularMovieUseCase: PopularMovieUseCase) : ViewModel() {


      val popularMovies : LiveData<List<Movie>?> = liveData {
          popularMovieUseCase.invoke().collectLatest {
                emit(it.data)
          }
      }

    val topRatedMovies : LiveData<List<Movie>?> = liveData {
        topRatedMovieUseCase.invoke().collectLatest {
            emit(it.data)
        }
    }

    val upcomingMovies : LiveData<List<Movie>?> = liveData {
        upcomingMovieUseCase.invoke().collectLatest {
            emit(it.data)
        }
    }

}