package com.example.myapplicationwork.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationwork.listeners.ClickListener
import com.example.myapplicationwork.R
import com.example.myapplicationwork.adapers.ActorListAdapter
import com.example.myapplicationwork.adapers.MoviesListAdapter
import com.example.myapplicationwork.modelsClass.ActorGenerator
import com.example.myapplicationwork.modelsClass.MoviesGenerator

class FragmentMoviesDetails : Fragment(R.layout.fragment_movies_details) {
    private var listener: ClickListener?  = null
    private var recycler: RecyclerView? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler = view.findViewById<RecyclerView>(R.id.list_actors)
        val actorAdapter = ActorListAdapter (ActorGenerator.generatorActors())
       // recycler?.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(requireContext())
        recycler?.adapter = actorAdapter

        view.findViewById<TextView>(R.id.textViewBack).apply {
            setOnClickListener { listener?.showList()  }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ClickListener)
            listener = context
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }
}