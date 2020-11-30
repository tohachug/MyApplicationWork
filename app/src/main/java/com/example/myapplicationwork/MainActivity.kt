package com.example.myapplicationwork

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() , ClickListener {

    private val moviesListFragment = FragmentMoviesList()
    private val moviesDetailsFragment = FragmentMoviesDetails()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    override fun showDetail() {
        supportFragmentManager.beginTransaction()
            .apply {
                replace(R.id.main_container, moviesDetailsFragment).addToBackStack(null)
                commit()
            }
    }

    override fun showList() {
        supportFragmentManager.popBackStack()
    }

}