package com.example.myapplicationwork.modelsClass

import com.example.myapplicationwork.R

data class Actor(
        val urlImgMovie: Int,
        val nameActor: String
)

object ActorGenerator{
    fun generatorActors(): List<Actor>{
        return listOf(
                Actor(R.drawable.robert_downey,"Robert Downey Jr."),
                Actor(R.drawable.chris_evans,"Chris Evans"),
                Actor(R.drawable.mark_ruffalo,"Mark Ruffalo"),
                Actor(R.drawable.chris_hemsworth,"Chris Hemsworth")
        )
    }
}