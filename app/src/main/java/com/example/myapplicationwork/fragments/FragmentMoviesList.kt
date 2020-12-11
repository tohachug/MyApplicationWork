package com.example.myapplicationwork.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationwork.listeners.ClickListener
import com.example.myapplicationwork.R
import com.example.myapplicationwork.adapers.MoviesListAdapter
import com.example.myapplicationwork.adapers.OnRecyclerItemClicked
import com.example.myapplicationwork.listeners.ClickListenerOnList
import com.example.myapplicationwork.modelsClass.Movie
import com.example.myapplicationwork.modelsClass.MoviesGenerator
import com.google.android.material.snackbar.Snackbar


class FragmentMoviesList : Fragment(R.layout.fragment_movies_list) {
    private var listener: ClickListener? = null
    private var listenerList: ClickListenerOnList? = null
    private var recycler: RecyclerView? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler = view.findViewById<RecyclerView>(R.id.list_movies)
        val moviesAdapter = MoviesListAdapter (MoviesGenerator.generatorMovies(), clickListener)
        recycler?.layoutManager = GridLayoutManager(requireContext(), 2)
        recycler?.adapter = moviesAdapter
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is ClickListenerOnList) {
            listenerList = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        listenerList = null
    }

    private fun doOnClick(movie: Movie) {
        recycler?.let { rv ->
            Snackbar.make(
                    rv,
                    movie.titleMovie,
                    Snackbar.LENGTH_SHORT)
                    .show()
        }
        listenerList?.showDetail()
    }

    private val clickListener = object : OnRecyclerItemClicked {
        override fun onClick(movie: Movie) {
            doOnClick(movie)
        }
    }

}

