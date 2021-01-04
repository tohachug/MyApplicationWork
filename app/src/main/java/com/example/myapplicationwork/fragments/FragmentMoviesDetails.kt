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
    private var listener: ClickListener?  = null
    private var recycler: RecyclerView? = null

    private var movieImg: ImageView? = null
    private var titleMovie: TextView? = null
    private var rating: RatingBar? = null
    private var tags: TextView? = null
    private var storyline: TextView? = null
    private var textRewiews: TextView? = null
    private var age: TextView? = null
    private var cast: TextView? = null

    private var movie: Movie? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //val movie = this.arguments?.getParcelable<Movie>("currentMovie")

//        recycler = view.findViewById<RecyclerView>(R.id.list_actors)
//        val actorAdapter = ActorListAdapter (movie!!.actors)
//        recycler?.adapter = actorAdapter

        view.findViewById<TextView>(R.id.textViewBack).apply {
            setOnClickListener { listener?.showList()  }
        }
        movieImg = view.findViewById(R.id.imageViewBackground)
        titleMovie = view.findViewById((R.id.textViewNameMovie))
        rating = view.findViewById(R.id.ratingBar)
        tags = view.findViewById(R.id.textViewTag)
        storyline = view.findViewById(R.id.textViewStory)
        textRewiews = view.findViewById(R.id.textViewReview)
        age = view.findViewById(R.id.textViewAge)
        cast = view.findViewById(R.id.textViewCast)

        movie = this.arguments?.getParcelable<Movie>("movie")

        recycler = view.findViewById<RecyclerView>(R.id.list_actors)
        var actorAdapter = ActorListAdapter (movie!!.actors)
        recycler?.adapter = actorAdapter

        movie?.let {
            Glide.with(view.context).load(it.backdrop).into(movieImg)
            titleMovie?.text = it.title
            rating?.rating = it.ratings/2
            tags?.text = it.genres.joinToString { genre -> genre.name }
            storyline?.text = it.overview
            textRewiews?.text = StringBuilder().append(it.numberOfRatings).append(" REVIEWS").toString()
            age?.text = StringBuilder().append(it.minimumAge.toString()).append("+").toString()
            if(it.actors.isEmpty()) {
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