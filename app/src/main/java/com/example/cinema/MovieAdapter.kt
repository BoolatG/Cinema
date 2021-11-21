package com.example.cinema

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MovieAdapter( val items: List<MovieItem>, val itemClickListener: OnItemClickListener) : RecyclerView.Adapter<MovieItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieItemViewHolder {
        val holder = LayoutInflater.from(parent.context)
        val view = holder.inflate(R.layout.item_movie_main, parent, false)
        return MovieItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: MovieItemViewHolder, position: Int) {
        holder.movieImage.setImageResource(items[position].image)
        holder.movieTitle.text = items[position].title
        holder.bind(items[position],itemClickListener)

    }



    }
    //написал интерфейс, чтобы реализовать клики на кнопки по методу https://medium.com/android-gate/recyclerview-item-click-listener-the-right-way-daecc838fbb9
    interface OnItemClickListener{
        fun onItemClicked(item: MovieItem)
        fun onLikeClicked(item: MovieItem)


}
