package com.example.myapplicationwork

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationwork.adapers.MoviesListAdapter
import com.example.myapplicationwork.fragments.FragmentMoviesDetails
import com.example.myapplicationwork.fragments.FragmentMoviesList
import com.example.myapplicationwork.listeners.ClickListener
import com.example.myapplicationwork.listeners.ClickListenerOnList
import com.example.myapplicationwork.modelsClass.MoviesGenerator


class MainActivity : AppCompatActivity() , ClickListener, ClickListenerOnList {

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