package com.example.myapplicationwork.modelsClass

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CreditsJson (
    val id: Long,
    val cast: List<CastJson>,
    val crew: List<CastJson>
)

@Serializable
data class CastJson (
    val adult: Boolean,
    val gender: Long,
    val id: Long,

    @SerialName("known_for_department")
    val knownForDepartment: String,

    val name: String,

    @SerialName("original_name")
    val originalName: String,

    val popularity: Double,

    @SerialName("profile_path")
    val profilePath: String? = null,

    @SerialName("cast_id")
    val castID: Long? = null,

    val character: String? = null,

    @SerialName("credit_id")
    val creditID: String,

    val order: Long? = null,
    val department: String? = null,
    val job: String? = null
)