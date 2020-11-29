package com.example.myapplicationwork

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() , FragmentMoviesList.TransactionsFragmentClicks {

    private val moviesListFragment = FragmentMoviesList().apply { setClickListener(this@MainActivity) };
    private val moviesDetailsFragment = FragmentMoviesDetails();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(savedInstanceState == null)
            supportFragmentManager.beginTransaction()
                .apply {
                    //add(R.id.main_container, moviesDetailsFragment)
                    add(R.id.main_container, moviesListFragment)
                    commit()
                }
    }

    override fun addDetailsFragment() {
         supportFragmentManager.beginTransaction()
            .apply {
                replace(R.id.main_container, FragmentMoviesDetails.newInstance("1","1")).addToBackStack(null)
                commit()
            }
    }
}