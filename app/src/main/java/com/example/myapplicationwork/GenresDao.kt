package com.example.myapplicationwork

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplicationwork.entity.GenreEntity

@Dao
interface GenresDao {
    @Query("SELECT * FROM genres")
    suspend fun getAll(): List<GenreEntity>

    @Query("SELECT * FROM genres where id= :id")
    suspend fun getById(id: Long): GenreEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(genre: GenreEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(genre: List<GenreEntity>)

    @Query("DELETE FROM genres WHERE id = :id")
    suspend fun deleteById(id: Long)

    @Query("DELETE FROM genres")
    suspend fun deleteAll()

}