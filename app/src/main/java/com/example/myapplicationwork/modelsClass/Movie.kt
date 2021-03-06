package com.example.myapplicationwork.modelsClass

import com.example.myapplicationwork.R

data class Movie(
        val urlImgMovie: Int,
        val age: String,
        val urlLike: Int,
        val tags: String,
        val rating: Float,
        val textRewiews: String,
        val titleMovie: String,
        val durationMovie: String
)

object MoviesGenerator{
    fun generatorMovies(): List<Movie>{
        return listOf(
                Movie(R.drawable.movie_avengers,"13+", R.drawable.like,"Action, Adventure, Fantasy",4F,"125 Reviews", "Avengers: End Game","137 min"),
                Movie(R.drawable.movie_tenet,"16+",R.drawable.like,"Action, Sci-Fi, Thriller", 5F,"98 Reviews", "Tenet","97 min"),
                Movie(R.drawable.movie_black_widow,"13+",R.drawable.like,"Action, Adventure, Sci-Fi",4F,"38 Reviews", "Black Widow","102 min"),
                Movie(R.drawable.movie_wonder_woman,"13+",R.drawable.like,"Action, Adventure, Fantasy",5F,"74 Reviews", "Wonder Woman 1984","120 min")
        )
    }
}