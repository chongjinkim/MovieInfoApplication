package com.soomgo.movieinfoapplication.presentaion.my

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.soomgo.movieinfoapplication.domain.model.Movie
import com.soomgo.movieinfoapplication.domain.usecase.QueryFavoritesMovieUseCase
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class MyViewModel(private val queryFavoritesMovieUseCase: QueryFavoritesMovieUseCase) : ViewModel() {

    init {
        viewModelScope.launch {
            getMovies()
        }
    }

    private val _movieList = MutableLiveData<List<Movie>>()
    val movieList : LiveData<List<Movie>>
        get() = _movieList


    private suspend fun getMovies(){
        queryFavoritesMovieUseCase().onEach {
            _movieList.value = it
        }.launchIn(viewModelScope)
    }
}