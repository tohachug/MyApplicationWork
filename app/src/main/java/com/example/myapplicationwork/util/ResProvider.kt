package com.example.myapplicationwork.util

import com.example.myapplicationwork.GetInfoFromApi
import com.example.myapplicationwork.data.Movie

class ResProvider() : Provider {
    val getInfoFromApi = GetInfoFromApi()

    override suspend fun loadFilms(): List<Movie> {
        return getInfoFromApi.loadMoviesApi()
    }
}
