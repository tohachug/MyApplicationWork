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
import com.example.myapplicationwork.modelsClass.Actor
import com.example.myapplicationwork.modelsClass.Movie

class ActorListAdapter(
        private var contextData: List<Actor>,
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class ViewHolderActor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val actorImg: ImageView = itemView.findViewById(R.id.imageView1)
        private val nameActor: TextView = itemView.findViewById(R.id.nameActorText)

        fun onBind(actor: Actor) {
            actorImg.setImageDrawable(ContextCompat.getDrawable(actorImg.context,actor.urlImgMovie))
            nameActor.text = actor.nameActor
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderActor {
        val view: View = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.view_holder_actor, parent, false)
        return ViewHolderActor(view)
    }

    override fun getItemCount(): Int = contextData.size

    fun bindActors(newMovies: List<Actor>) {
        contextData = newMovies
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ViewHolderActor -> {
                holder.onBind(contextData[position])
            }
        }
    }
}

private val RecyclerView.ViewHolder.context
    get() = this.itemView.context

