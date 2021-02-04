package com.example.myapplicationwork.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationwork.MainViewModel
import com.example.myapplicationwork.MainViewModelFactory
import com.example.myapplicationwork.R
import com.example.myapplicationwork.adapers.MoviesListAdapter
import com.example.myapplicationwork.adapers.OnRecyclerItemClicked
import com.example.myapplicationwork.data.Movie
import com.example.myapplicationwork.listeners.ClickListenerOnList
import com.example.myapplicationwork.util.ResProvider
import com.google.android.material.snackbar.Snackbar

class FragmentMoviesList : Fragment(R.layout.fragment_movies_list) {

    private var listenerList: ClickListenerOnList? = null
    private var recycler: RecyclerView? = null
    private var moviesAdapter: MoviesListAdapter? = null
    private lateinit var viewModel: MainViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        moviesAdapter = MoviesListAdapter(clickListener)

        val resProvider = ResProvider()
        val factory = MainViewModelFactory(resProvider, applicationContext = requireContext().applicationContext)
        viewModel = ViewModelProviders.of(this, factory).get(MainViewModel::class.java)
        viewModel.liveData.observe(this.viewLifecycleOwner, Observer {
             moviesAdapter?.bindMovies(it)
        })

        recycler = view.findViewById<RecyclerView>(R.id.list_movies)
        recycler?.layoutManager = GridLayoutManager(requireContext(), 2)
        recycler?.adapter = moviesAdapter
    }

     override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ClickListenerOnList) {
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
                    movie.title,
                    Snackbar.LENGTH_SHORT)
                    .show()
        }
        listenerList?.showDetail(movie)
    }

    private val clickListener = object : OnRecyclerItemClicked {
        override fun onClick(movie: Movie) {
            doOnClick(movie)
        }
    }
}

