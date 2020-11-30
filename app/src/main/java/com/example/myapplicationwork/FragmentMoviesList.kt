package com.example.myapplicationwork

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.content.Context


class FragmentMoviesList : Fragment(R.layout.fragment_movies_list) {
    private var listener: ClickListener? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<View>(R.id.imageViewMovieBG).apply {
            setOnClickListener { listener?.showDetail()  }
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