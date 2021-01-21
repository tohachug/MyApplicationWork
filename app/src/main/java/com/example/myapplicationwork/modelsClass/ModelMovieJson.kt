package com.example.myapplicationwork.modelsClass

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
class ModelMovieJson(
    val poster_path : String?,
    val adult : Boolean,
    val overview : String,
    @SerialName("release_date")
    val releaseDate : String,
    @SerialName("genre_ids")
    val genreIds : List<Int>,
    val id : Int,
    @SerialName("original_title")
    val originalTitle : String,
    @SerialName("original_language")
    val originalLanguage : String,
    val title : String,
    @SerialName("backdrop_path")
    val backdropPath : String?,
    val popularity : Double,
    @SerialName("vote_count")
    val voteCount : Int,
    val video : Boolean,
    val vote_average : Double
): Parcelable