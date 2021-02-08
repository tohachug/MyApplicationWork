package com.example.myapplicationwork

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.myapplicationwork.util.ResProvider

class MyWorker(context: Context, workerParameters: WorkerParameters): CoroutineWorker(context, workerParameters) {
    override suspend fun doWork(): Result {
        val resProvider = ResProvider()
        if (ConnectionChecker.isOnline()) {
            val moviesApi = resProvider.loadFilms()
            val moviesDb = MoviesEntityRepository()
            moviesDb.saveMovies(moviesApi)
            return Result.success()
        }
        else
            return  Result.failure()
    }

}