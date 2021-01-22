package com.example.myapplicationwork.util

import android.content.Context
import com.example.myapplicationwork.data.Actor
import com.example.myapplicationwork.data.Genre
import com.example.myapplicationwork.data.Movie
import com.example.myapplicationwork.modelsClass.BaseResponse
import com.example.myapplicationwork.modelsClass.CreditsJson
import com.example.myapplicationwork.modelsClass.ModelMovieJson
import com.example.myapplicationwork.modelsClass.MovieDetailsJson
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


class ResProvider(val context: Context) : Provider {
    var moviesList: MutableList<Movie> = mutableListOf()
    var genresList: MutableList<Genre> = mutableListOf()
    var actorsList: MutableList<Actor> = mutableListOf()
    override suspend fun loadFilms(): List<Movie> {
        return loadMovies()
        //return loadMovies(context)
    }

    var coroutineScope = CoroutineScope(Job() + Dispatchers.IO)

    private suspend fun loadMovies(): List<Movie> {
        coroutineScope.launch() {
            val moviesApi = RetrofitModule.moviesApi.getMovies()
            println("Вывожу список")
            

            for (it in moviesApi.movies) {
                val detailsMovie = RetrofitModule.moviesApi.getMovieDetails(it.id)
                //println("DETAIL" + detailsMovie)
                val creditsMovie = RetrofitModule.moviesApi.getMovieCredits(it.id)
               // println("CREDIT" + creditsMovie)

                genresList.clear()
                for (it in detailsMovie.genres) {
                    genresList.add(
                        Genre(
                            it.id.toInt(),
                            it.name
                        )
                    )
                }

                actorsList.clear()
              //  println("Размер actorsList" + actorsList.size)
              //  println("Размер creditsMovie.cast" + creditsMovie.cast.size)
                for (it in creditsMovie.cast) {
                    actorsList.add(
                        Actor(
                            it.id.toInt(),
                            it.name,
                            BASE_URL_IMG + it.profilePath
                        )
                    )
                   // println("СПИСОК АКТЕРОВ!!!! "+actorsList)
                }
                //println("СПИСОК АКТЕРОВ!!!! "+actorsList)

                moviesList.add(
                    Movie(
                        it.id,
                        it.title,
                        it.overview,
                        BASE_URL_IMG + it.poster_path,
                        BASE_URL_IMG + it.backdropPath,
                        it.vote_average.toFloat(),
                        it.voteCount,
                        if (it.adult) 16 else 13,
                        detailsMovie.runtime.toInt(),
                        genresList,
                        actorsList,
                        true
                    )
                )
              //  println("Сам фильм "+moviesList)
            }
           // println(moviesList)

        }
        return moviesList
    }

    private interface ApiService {
        @GET("3/movie/popular?language=en-US&page=1")
        suspend fun getMovies(@Query("api_key") apikey: String = apiKey): BaseResponse<ModelMovieJson>

        @GET("3/movie/{movie_id}?language=en-US&page=1")
        suspend fun getMovieDetails(
            @Path("movie_id") movieId: Int,
            @Query("api_key") apikey: String = apiKey
        ): MovieDetailsJson

        @GET("3/movie/{movie_id}/credits?language=en-US&page=1")
        suspend fun getMovieCredits(
            @Path("movie_id") movieId: Int,
            @Query("api_key") apikey: String = apiKey
        ): CreditsJson
    }

    private object RetrofitModule {
        private val json = Json {
            ignoreUnknownKeys = true
        }

        @Suppress("EXPERIMENTAL_API_USAGE")
        private val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .build()

        val moviesApi: ApiService = retrofit.create()
    }
}

const val apiKey = "9c4b23fcec415560b874dddfdc65d849"
const val BASE_URL = "https://api.themoviedb.org/"
const val BASE_URL_IMG = "https://image.tmdb.org/t/p/w780"