package com.soomgo.movieinfoapplication.presentaion.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.soomgo.movieinfoapplication.domain.model.Movie
import com.soomgo.movieinfoapplication.domain.model.MovieDetail
import com.soomgo.movieinfoapplication.domain.usecase.DeleteMovieUseCase
import com.soomgo.movieinfoapplication.domain.usecase.DetailiMovieUseCase
import com.soomgo.movieinfoapplication.domain.usecase.InsertMovieUseCase
import com.soomgo.movieinfoapplication.domain.usecase.QueryFavoriteMovieUseCase
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class DetailViewModel(private val detailiMovieUseCase: DetailiMovieUseCase,
                      private val queryFavoriteMovieUseCase: QueryFavoriteMovieUseCase,
                      private val insertMovieUseCase: InsertMovieUseCase,
                      private val deleteMovieUseCase: DeleteMovieUseCase) :  ViewModel(){

    private val _movieDetail = MutableLiveData<MovieDetail>()
    val movieDetail : LiveData<MovieDetail>
        get() = _movieDetail

    private val _movieFavorite = MutableLiveData(false)
    val movieFavorite : LiveData<Boolean>
        get() = _movieFavorite


    fun fetchDetail(movie : Movie){
        viewModelScope.launch {
            launch {
                queryFavoriteMovieUseCase.invoke(movie).collectLatest {
                    it?.let {
                       _movieFavorite.value = true
                    }
                }
            }

            detailiMovieUseCase.invoke(movie).collectLatest { movieDetail ->
                movieDetail.data?.let {
                    _movieDetail.value = it
                }
            }
        }
    }

    fun updateMovie(movie : Movie){
        viewModelScope.launch {
            if(_movieFavorite.value == false){
                insertMovieUseCase.invoke(movie)
                _movieFavorite.value == true
            } else{
                deleteMovieUseCase.invoke(movie)
                _movieFavorite.value = false
            }
        }
    }

}