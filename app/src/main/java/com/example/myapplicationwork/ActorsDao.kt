package com.example.myapplicationwork

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplicationwork.entity.ActorEntity

@Dao
interface ActorsDao {
    @Query("SELECT * FROM actors")
    suspend fun getAll(): List<ActorEntity>

    @Query("SELECT * FROM actors")
    suspend fun getAllLiveData(): LiveData<List<ActorEntity>>

    @Query("SELECT * FROM actors where id= :id")
    suspend fun getById(id: Long): ActorEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(actor: ActorEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(actor: List<ActorEntity>)

    @Query("DELETE FROM actors WHERE id = :id")
    suspend fun deleteById(id: Long)

    @Query("DELETE FROM actors")
    suspend fun deleteAll()

}