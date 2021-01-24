package com.example.myapplicationwork.util

import com.example.myapplicationwork.GetInfoFromApi
import com.example.myapplicationwork.data.Movie

class ResProvider() : Provider {
    override suspend fun loadFilms(): List<Movie> {
        val getInfoFromApi = GetInfoFromApi()
        return getInfoFromApi.loadMoviesApi()
    }
}
