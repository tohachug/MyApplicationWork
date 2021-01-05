package com.example.myapplicationwork.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplicationwork.R
import com.example.myapplicationwork.adapers.ActorListAdapter
import com.example.myapplicationwork.data.Movie
import com.example.myapplicationwork.listeners.ClickListener

class FragmentMoviesDetails : Fragment(R.layout.fragment_movies_details) {
    private var listener: ClickListener? = null
    private var recycler: RecyclerView? = null
    private var movie: Movie? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val movieImg = view.findViewById<ImageView>(R.id.imageViewBackground)
        var titleMovie = view.findViewById<TextView>((R.id.textViewNameMovie))
        var rating = view.findViewById<RatingBar>(R.id.ratingBar)
        var tags = view.findViewById<TextView>(R.id.textViewTag)
        var storyline = view.findViewById<TextView>(R.id.textViewStory)
        var textRewiews = view.findViewById<TextView>(R.id.textViewReview)
        var age = view.findViewById<TextView>(R.id.textViewAge)
        var cast = view.findViewById<TextView>(R.id.textViewCast)

        view.findViewById<TextView>(R.id.textViewBack).apply {
            setOnClickListener { listener?.showList() }
        }

        movie = this.arguments?.getParcelable<Movie>("movie")

        recycler = view.findViewById<RecyclerView>(R.id.list_actors)
        var actorAdapter = ActorListAdapter(movie!!.actors)
        recycler?.adapter = actorAdapter

        movie?.let {
            Glide.with(view.context).load(it.backdrop).into(movieImg)
            titleMovie?.text = it.title
            rating?.rating = it.ratings / 2
            tags?.text = it.genres.joinToString { genre -> genre.name }
            storyline?.text = it.overview
            textRewiews?.text = StringBuilder().append(it.numberOfRatings).append(" REVIEWS").toString()
            age?.text = StringBuilder().append(it.minimumAge.toString()).append("+").toString()
            if (it.actors.isEmpty()) {
                cast?.visibility = View.GONE
                recycler?.visibility = View.GONE
            }
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