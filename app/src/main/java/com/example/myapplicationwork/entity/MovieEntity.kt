package com.example.myapplicationwork.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey


@Entity(
    tableName = "movies",
    indices = [Index("id")]
)
data class MovieEntity(

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    val id: Long = 0,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "overview")
    val overview: String,
    @ColumnInfo(name = "poster")
    val poster: String,
    @ColumnInfo(name = "backdrop")
    val backdrop: String,
    @ColumnInfo(name = "ratings")
    val ratings: Float,
    @ColumnInfo(name = "numberOfRatings")
    val numberOfRatings: Int,
    @ColumnInfo(name = "minimumAge")
    val minimumAge: Int,
    @ColumnInfo(name = "runtime")
    val runtime: Int,

    @ColumnInfo(name = "id_genres")
    val genreId: String,

    @ColumnInfo(name = "id_actors")
    val actorsId: String,

    @ColumnInfo(name = "like")
    val like: Boolean
)


