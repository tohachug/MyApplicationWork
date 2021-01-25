package com.example.myapplicationwork.modelsClass

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BaseResponse<T> (

    val page: Long,

    @SerialName("results")
    val movies: List<T>,

    @SerialName("total_pages")
    val totalPages: Long,

    @SerialName("total_results")
    val totalResults: Long
)