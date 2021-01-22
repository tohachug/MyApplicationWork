package com.example.myapplicationwork.modelsClass

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

    @Serializable
    data class MovieDetailsJson (
        val adult: Boolean,

        @SerialName("backdrop_path")
        val backdropPath: String,

        @SerialName("belongs_to_collection")
        val belongsToCollection: CollectionJson? = null,

        val budget: Long,
        val genres: List<GenresJson>,
        val homepage: String,
        val id: Long,

        @SerialName("imdb_id")
        val imdbID: String,

        @SerialName("original_language")
        val originalLanguage: String,

        @SerialName("original_title")
        val originalTitle: String,

        val overview: String,
        val popularity: Double,

        @SerialName("poster_path")
        val posterPath: String? = null,

        @SerialName("production_companies")
        val productionCompanies: List<ProductionCompanysJson>,

        @SerialName("production_countries")
        val productionCountries: List<ProductionCountrysJson>,

        @SerialName("release_date")
        val releaseDate: String,

        val revenue: Long,
        val runtime: Long,

        @SerialName("spoken_languages")
        val spokenLanguages: List<SpokenLanguagesJson>,

        val status: String,
        val tagline: String,
        val title: String,
        val video: Boolean,

        @SerialName("vote_average")
        val voteAverage: Double,

        @SerialName("vote_count")
        val voteCount: Long
    )


    @Serializable
    data class CollectionJson (
        val id: Long,
        val name: String,

        @SerialName("poster_path")
        val posterPath: String,

        @SerialName("backdrop_path")
        val backdropPath: String
    )

    @Serializable
    data class GenresJson (
        val id: Long,
        val name: String
    )

    @Serializable
    data class ProductionCompanysJson (
        val id: Long,

        @SerialName("logo_path")
        val logoPath: String? = null,

        val name: String,

        @SerialName("origin_country")
        val originCountry: String
    )

    @Serializable
    data class ProductionCountrysJson (
        @SerialName("iso_3166_1")
        val iso3166_1: String,

        val name: String
    )

    @Serializable
    data class SpokenLanguagesJson (
        @SerialName("iso_639_1")
        val iso639_1: String,

        val name: String
    )
