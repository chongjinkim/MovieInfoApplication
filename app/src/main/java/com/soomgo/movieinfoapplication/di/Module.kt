package com.soomgo.movieinfoapplication.di

import android.app.Application
import androidx.room.Room
import com.google.gson.GsonBuilder
import com.soomgo.movieinfoapplication.data.local.MovieDatabase
import com.soomgo.movieinfoapplication.data.network.Client
import com.soomgo.movieinfoapplication.data.repository.MovieRepositoryImpl
import com.soomgo.movieinfoapplication.domain.repository.MovieRepository
import com.soomgo.movieinfoapplication.domain.usecase.*
import com.soomgo.movieinfoapplication.presentaion.detail.DetailViewModel
import com.soomgo.movieinfoapplication.presentaion.movie.MovieViewModel
import com.soomgo.movieinfoapplication.presentaion.my.MyViewModel
import org.koin.dsl.module

val utilModule = module {
    single { GsonBuilder().setPrettyPrinting().create()}
}
val localDataModule = module {

    fun provideDatabase(application : Application) = Room
        .databaseBuilder(application, MovieDatabase::class.java, "movies")
        .fallbackToDestructiveMigration()
        .build()

    fun provideMovieDao(database: MovieDatabase) = database.movieDao
        single { provideDatabase(get()) }
        single { provideMovieDao(get()) }
}

val remoteDataModule = module {
    single { Client(get()) }
    single<MovieRepository> {MovieRepositoryImpl(get(), get())}
}

val viewModelModule = module {
    single { MyViewModel(get()) }
    single { MovieViewModel(get(), get(), get()) }
    single { DetailViewModel(get(), get(), get(), get()) }
}

val useCaseModule = module {
    single { DeleteMovieUseCase(get()) }
    single { DetailiMovieUseCase(get()) }
    single {InsertMovieUseCase(get())}
    single { PopularMovieUseCase(get()) }
    single { QueryFavoriteMovieUseCase(get()) }
    single { QueryFavoritesMovieUseCase(get()) }
    single { TopRatedMovieUseCase(get()) }
    single { UpcomingMovieUseCase(get()) }
}

val applicationModule = listOf(
    utilModule,
    localDataModule,
    remoteDataModule,
    viewModelModule,
    useCaseModule
)
