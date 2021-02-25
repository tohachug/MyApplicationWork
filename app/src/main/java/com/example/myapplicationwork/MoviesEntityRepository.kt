package com.example.myapplicationwork

import com.example.myapplicationwork.data.Actor
import com.example.myapplicationwork.data.Genre
import com.example.myapplicationwork.data.Movie
import com.example.myapplicationwork.entity.ActorEntity
import com.example.myapplicationwork.entity.GenreEntity
import com.example.myapplicationwork.entity.MovieEntity

class MoviesEntityRepository() {

    private val moviesDb = DataBase.create(PersistencyApp.getContext())

    suspend fun parseToMovieList(movieEntityList: List<MovieEntity>): List<Movie>{
        val moviesConvert : MutableList<Movie> = mutableListOf()

        for (movieEntity in movieEntityList) {
              val genres = movieEntity.genreId.split(",").filter {
                it.isNotEmpty()
            }.map {
                moviesDb.genresDao.getById(it.toLong())
            }.map {
                Genre(
                    id = it.id.toInt(),
                    name = it.name
                )
            }

            val actors = movieEntity.actorsId.split(",").filter {
                it.isNotEmpty()
            }.map {
                moviesDb.actorsDao.getById(it.toLong())
            }.map {
                Actor(
                    id = it.id.toInt(),
                    name = it.name,
                    picture = it.picture
                )
            }

            moviesConvert.add(Movie (
                id = movieEntity.id.toInt(),
                title = movieEntity.title,
                overview = movieEntity.overview,
                poster = movieEntity.poster,
                backdrop = movieEntity.backdrop,
                ratings = movieEntity.ratings,
                numberOfRatings = movieEntity.numberOfRatings,
                minimumAge = movieEntity.minimumAge,
                runtime = movieEntity.runtime,
                genres = genres,
                actors = actors,
                like = movieEntity.like
            ))
        }
    return moviesConvert
    }

    suspend fun saveMovies(inMovies: List<Movie>){
        moviesDb.moviesDao.deleteAll()

        for (movie in inMovies) {
            moviesDb.genresDao.insertAll(movie.genres.map { GenreEntity(id = it.id.toLong(), name = it.name) })
            moviesDb.actorsDao.insertAll(movie.actors.map { ActorEntity(id = it.id.toLong(), name = it.name, picture = it.picture) })
            moviesDb.moviesDao.insert(
                MovieEntity (
                id = movie.id.toLong(),
                title = movie.title,
                overview = movie.overview,
                poster = movie.poster,
                backdrop = movie.backdrop,
                ratings = movie.ratings,
                numberOfRatings = movie.numberOfRatings,
                minimumAge = movie.minimumAge,
                runtime = movie.runtime,
                genreId = movie.genres.joinToString(separator = ",", transform = { it.id.toString() }),
                actorsId = movie.actors.joinToString(separator = ",", transform = { it.id.toString() }),
                like = movie.like
            )
            )
        }

    }
}