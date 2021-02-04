package com.example.myapplicationwork

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplicationwork.entity.ActorEntity
import com.example.myapplicationwork.entity.GenreEntity
import com.example.myapplicationwork.entity.MovieEntity

@Database(
    entities = [MovieEntity::class, ActorEntity::class, GenreEntity::class], version = 1
)
abstract class DataBase: RoomDatabase() {
    abstract val moviesDao: MoviesDao
    abstract val genresDao: GenresDao
    abstract val actorsDao: ActorsDao

    companion object {
        fun create(applicationContext: Context): DataBase = Room.databaseBuilder(
            applicationContext,
            DataBase::class.java,
            "movieDB"
        )
            .fallbackToDestructiveMigration()
            .build()
    }
}