package com.example.myapplicationwork

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.myapplicationwork.entity.MovieEntity

@Dao
interface MoviesDao {
    @Query("SELECT * FROM movies")
    suspend fun getAll(): List<MovieEntity>

    @Query("SELECT * FROM movies")
    fun getAllLiveData(): LiveData<List<MovieEntity>>

    @Insert
    suspend fun insert(location: MovieEntity)

    @Query("DELETE FROM movies WHERE id = :id")
    suspend fun deleteById(id: Long)

    @Query("DELETE FROM movies")
    suspend fun deleteAll()

}