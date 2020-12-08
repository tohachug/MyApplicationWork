package com.example.myapplicationwork.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationwork.listeners.ClickListener
import com.example.myapplicationwork.R
import com.example.myapplicationwork.adapers.MoviesListAdapter
import com.example.myapplicationwork.listeners.ClickListenerOnList
import com.example.myapplicationwork.modelsClass.Movie
import com.example.myapplicationwork.modelsClass.MoviesGenerator


class FragmentMoviesList : Fragment(R.layout.fragment_movies_list) {
    private var listener: ClickListener? = null
    private var recycler: RecyclerView? = null
    private var listenerList: ClickListenerOnList? = null

    //под вопросом нужно ли?
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_movies_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        recycler = view.findViewById(R.id.list_movies)
//        val moviesAdapter = MoviesListAdapter (MoviesGenerator.generatorMovies())
//        recycler?.adapter = moviesAdapter

        view.findViewById<View>(R.id.imageViewMovieBG).apply {
            setOnClickListener { listener?.showDetail()  }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        //if (context is ClickListener)
            //listener = context
            if(context is ClickListenerOnList) {
                listenerList = context
            }
    }

    override fun onDetach() {
        super.onDetach()
        //listener = null
        listenerList = null
        recycler = null
    }

//    private val clickListener = object : OnRecyclerItemClicked {
//        override fun onClick(movie: Movie) {
//            onClick(movie)
//        }
//    }

}

