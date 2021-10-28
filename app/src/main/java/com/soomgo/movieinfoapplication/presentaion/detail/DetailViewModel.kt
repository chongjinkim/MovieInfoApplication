package com.soomgo.movieinfoapplication.presentaion.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.soomgo.movieinfoapplication.domain.model.Movie
import com.soomgo.movieinfoapplication.domain.model.MovieDetail
import com.soomgo.movieinfoapplication.domain.usecase.DetailiMovieUseCase
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class DetailViewModel(private val detailiMovieUseCase: DetailiMovieUseCase) :  ViewModel(){

    private val _movieDetail = MutableLiveData<MovieDetail>()
    val movieDetail : LiveData<MovieDetail>
        get() = _movieDetail

    private val _movieFavorite = MutableLiveData(false)
    val movieFavorite : LiveData<Boolean>
        get() = _movieFavorite

}