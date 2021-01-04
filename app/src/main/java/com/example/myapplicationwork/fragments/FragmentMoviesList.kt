package com.example.myapplicationwork.fragments

//import com.example.myapplicationwork.modelsClass.Movie
import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationwork.R
import com.example.myapplicationwork.adapers.MoviesListAdapter
import com.example.myapplicationwork.adapers.OnRecyclerItemClicked
import com.example.myapplicationwork.data.Movie
import com.example.myapplicationwork.data.loadMovies
import com.example.myapplicationwork.listeners.ClickListenerOnList
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class FragmentMoviesList : Fragment(R.layout.fragment_movies_list) {
  //  private var listener: ClickListener? = null
    private var listenerList: ClickListenerOnList? = null
    private var recycler: RecyclerView? = null
    private val scope = CoroutineScope(Dispatchers.Main);
    private var moveList: List<Movie>? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler = view.findViewById<RecyclerView>(R.id.list_movies)
        var moviesAdapter: MoviesListAdapter? = null;
        scope.launch {
            moveList = loadMovies(view.context)
            moviesAdapter = MoviesListAdapter (moveList!!, clickListener)
            recycler?.layoutManager = GridLayoutManager(requireContext(), 2)
            recycler?.adapter = moviesAdapter
        }
    }

    private fun updateData() {
        (recycler?.adapter as? MoviesListAdapter)?.apply {
            moveList?.let {
                bindMovies(it)
            }
        }
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
                    movie.title,// titleMovie,
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

