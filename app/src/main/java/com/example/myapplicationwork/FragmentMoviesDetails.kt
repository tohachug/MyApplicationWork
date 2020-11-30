package com.example.myapplicationwork

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment

class FragmentMoviesDetails : Fragment(R.layout. fragment_movies_details) {
    private var listener: ClickListener?  = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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