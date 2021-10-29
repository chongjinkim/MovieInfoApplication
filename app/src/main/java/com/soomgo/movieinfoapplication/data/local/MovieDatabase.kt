package com.soomgo.movieinfoapplication.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.soomgo.movieinfoapplication.domain.model.Movie


@Database(entities = [Movie::class], version = 2)

abstract class MovieDatabase : RoomDatabase() {

    abstract val movieDao : MovieDAO

    companion object{

        const val data_base_name = "movie_db"
    }

}