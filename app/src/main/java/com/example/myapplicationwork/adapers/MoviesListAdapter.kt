package com.example.myapplicationwork.adapers

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationwork.R
import com.example.myapplicationwork.modelsClass.Movie

class MoviesListAdapter(
        private var contextData: List<Movie>,
        private val clickListener: OnRecyclerItemClicked
        //): RecyclerView.Adapter<MoviesListAdapter.ViewHolderMovies>() {
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class ViewHolderMovies(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val movieImg: ImageView = itemView.findViewById(R.id.imageViewMovie)
        private val age: TextView = itemView.findViewById(R.id.age)
        private val likeImg: ImageView = itemView.findViewById(R.id.imageViewLike)
        private val tags: TextView = itemView.findViewById(R.id.tag)
        private val rating: RatingBar = itemView.findViewById(R.id.ratingBar)
        private val textRewiews: TextView = itemView.findViewById(R.id.textViewReview)
        private val titleMovie: TextView = itemView.findViewById(R.id.textViewNameMovie)
        private val durationMovie: TextView = itemView.findViewById(R.id.textViewMin)

        fun onBind(movie: Movie) {
            movieImg.setImageDrawable(ContextCompat.getDrawable(movieImg.context,movie.urlImgMovie))
            likeImg.setImageDrawable(ContextCompat.getDrawable(movieImg.context, movie.urlLike))
            age.text = movie.age
            tags.text = movie.tags
            rating.rating = movie.rating
            textRewiews.text = movie.textRewiews
            titleMovie.text = movie.titleMovie
            durationMovie.text = movie.durationMovie
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderMovies {
        val view: View = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.view_holder_movie, parent, false)
        return ViewHolderMovies(view)
    }

//    override fun onBindViewHolder(holder: ViewHolderMovies, position: Int) {
//        when (holder) {
//            is ViewHolderMovies -> {
//                holder.onBind(contextData[position])
//                holder.itemView.setOnClickListener {
//                    clickListener.onClick(contextData[position])
//                }
//            }
//        }
//    }

    override fun getItemCount(): Int = contextData.size

    fun bindMovies(newMovies: List<Movie>) {
        contextData = newMovies
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ViewHolderMovies -> {
                holder.onBind(contextData[position])
                holder.itemView.setOnClickListener {
                    clickListener.onClick(contextData[position])
                }
            }
        }
    }

}

private val RecyclerView.ViewHolder.context
    get() = this.itemView.context

interface OnRecyclerItemClicked {
    fun onClick(movie: Movie)
}