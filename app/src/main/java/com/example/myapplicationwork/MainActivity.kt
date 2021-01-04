package com.example.myapplicationwork

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplicationwork.data.Movie
import com.example.myapplicationwork.fragments.FragmentMoviesDetails
import com.example.myapplicationwork.fragments.FragmentMoviesList
import com.example.myapplicationwork.listeners.ClickListener
import com.example.myapplicationwork.listeners.ClickListenerOnList


class MainActivity : AppCompatActivity() , ClickListener, ClickListenerOnList {

    private val moviesListFragment = FragmentMoviesList()
    private val moviesDetailsFragment = FragmentMoviesDetails()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    override fun showDetail(movie: Movie) {
        val bundle = Bundle()
        bundle.putParcelable("movie", movie)
        moviesDetailsFragment.arguments = bundle
        supportFragmentManager.beginTransaction()
            .apply {
                replace(R.id.main_container, moviesDetailsFragment)
                    .addToBackStack(null)
                commit()
            }
    }

    override fun showList() {
        supportFragmentManager.popBackStack()
    }
}