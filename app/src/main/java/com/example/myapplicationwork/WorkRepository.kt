package com.example.myapplicationwork

import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequest
import java.util.concurrent.TimeUnit


class WorkRepository {
    var constraintsChardge: Constraints = Constraints.Builder()
        .setRequiresCharging(true)
        .build()

    var constraintsWiFi: Constraints = Constraints.Builder()
        .setRequiredNetworkType(NetworkType.UNMETERED)
        .build()

    var myWorkRequest = PeriodicWorkRequest.Builder(MyWorker::class.java, 8, TimeUnit.HOURS)
        .setConstraints(constraintsChardge)
        .setConstraints(constraintsWiFi)
        .build()
}