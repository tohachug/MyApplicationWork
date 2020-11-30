package com.example.myapplicationwork

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() , ClickListener {

    private val moviesListFragment = FragmentMoviesList();
    private val moviesDetailsFragment = FragmentMoviesDetails();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        if(savedInstanceState == null)
//            supportFragmentManager.beginTransaction()
//                .apply {
//                    add(R.id.main_container, moviesListFragment)
//                    commit()
//                }
    }


    override fun showDetail() {
        supportFragmentManager.beginTransaction()
            .apply {
                replace(R.id.main_container, moviesDetailsFragment).addToBackStack(null)
                commit()
            }
    }

    override fun showList() {
        supportFragmentManager.beginTransaction()
            .apply {
                replace(R.id.main_container, moviesListFragment).addToBackStack(null)
                commit()
            }
    }
}