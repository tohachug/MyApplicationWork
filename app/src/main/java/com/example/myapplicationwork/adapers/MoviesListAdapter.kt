package com.example.myapplicationwork.adapers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplicationwork.R
import com.example.myapplicationwork.data.Movie

class MoviesListAdapter(
        private val clickListener: OnRecyclerItemClicked
) : RecyclerView.Adapter<MoviesListAdapter.ViewHolderMovies>() {

    private val contextData = mutableListOf<Movie>()

    class ViewHolderMovies(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val movieImg: ImageView = itemView.findViewById(R.id.imageViewMovie)
        private val age: TextView = itemView.findViewById(R.id.age)
        private val likeImg: ImageView = itemView.findViewById(R.id.imageViewLike)
        private val tags: TextView = itemView.findViewById(R.id.tag)
        private val rating: RatingBar = itemView.findViewById(R.id.ratingBar)
        private val textRewiews: TextView = itemView.findViewById(R.id.textViewReview)
        private val titleMovie: TextView = itemView.findViewById(R.id.textViewNameMovie)
        private val durationMovie: TextView = itemView.findViewById(R.id.textViewMin)

        //fun onBind(movie: Movie) {
         fun onBind(movie: Movie) {
            context?.let {
                Glide.with(context)
                        .load(movie.poster)
                        .into(movieImg)
            }
            if (movie.like) {
                likeImg.setImageDrawable(ContextCompat.getDrawable(movieImg.context, R.drawable.like))
            } else {
                likeImg.setImageDrawable(ContextCompat.getDrawable(movieImg.context, R.drawable.like))
            }
            age.text = movie.minimumAge.toString().plus(" +")
            tags.text = movie.genres.joinToString { it -> it.name }
            rating.rating = movie.ratings / 2
            textRewiews.text = movie.numberOfRatings.toString().plus(" REVIEWS")
            titleMovie.text = movie.title
            durationMovie.text = movie.runtime.toString().plus(" MIN")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderMovies {
        val view: View = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.view_holder_movie, parent, false)
        return ViewHolderMovies(view)
    }

    override fun getItemCount(): Int = contextData.size

    fun bindMovies(newMovies: List<Movie>) {
        contextData.clear()
        contextData.addAll(newMovies)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolderMovies, position: Int) {
        holder.onBind(contextData[position])
        holder.itemView.setOnClickListener {
            clickListener.onClick(contextData[position])
        }
    }
}

private val MoviesListAdapter.ViewHolderMovies.context
    get() = this.itemView.context

interface OnRecyclerItemClicked {
    fun onClick(movie: Movie)
}