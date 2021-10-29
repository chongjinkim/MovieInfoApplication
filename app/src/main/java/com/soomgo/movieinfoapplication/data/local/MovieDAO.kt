package com.soomgo.movieinfoapplication.data.local

import androidx.room.*
import com.soomgo.movieinfoapplication.domain.model.Movie
import kotlinx.coroutines.flow.Flow


@Dao
interface MovieDAO {

    @Query("SELECT * FROM Movie")
    fun getMovies() : Flow<List<Movie>>

    @Query("SELECT * FROM Movie WHERE ID = :id")
    fun getMovie(id : Int) : Flow<Movie>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movie : Movie)

    @Delete
    suspend fun deleteMovie(movie : Movie)

    @Update
    suspend fun updateMovie(movie : Movie)


}