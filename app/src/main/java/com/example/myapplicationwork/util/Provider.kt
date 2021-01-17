package com.example.myapplicationwork.util

import com.example.myapplicationwork.data.Movie

interface Provider {
   suspend fun loadFilms() : List<Movie>
}