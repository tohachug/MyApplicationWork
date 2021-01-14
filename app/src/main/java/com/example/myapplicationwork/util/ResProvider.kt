package com.example.myapplicationwork.util

import android.content.Context
import com.example.myapplicationwork.data.Movie
import com.example.myapplicationwork.data.loadMovies

class ResProvider(val context: Context): Provider {
    override suspend fun loadFilms(): List<Movie> {
        return loadMovies(context)
    }

}