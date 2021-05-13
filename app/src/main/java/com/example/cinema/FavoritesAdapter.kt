package com.example.cinema

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FavoritesAdapter(val items: List<MovieItem>, private val emptyListTextView: TextView, private val clickListener: (movie: MovieItem) -> Unit):RecyclerView.Adapter<FavoritesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritesViewHolder {
        val holder = LayoutInflater.from(parent.context)
        val view = holder.inflate(R.layout.item_movie_favorites, parent, false)
        return FavoritesViewHolder(view)
    }



    override fun onBindViewHolder(holder: FavoritesViewHolder, position: Int) {
        holder.bind(items[position])
        setOnClickListenerForDetailsBtn(holder, items[position])
        setOnClickListenerForDeleteBtn(holder, items[position], position)
    }

    override fun getItemCount(): Int {
        return items.size
    }
  /*  private fun showStubIfListEmpty() {
        if (items.isEmpty()) {
            emptyListTextView.visibility = View.VISIBLE
        } else {
            emptyListTextView.visibility = View.GONE
        }
    }*/
    private fun setOnClickListenerForDeleteBtn(holder: FavoritesViewHolder, movie: MovieItem, position: Int) {
        holder.favDeleteBtn.setOnClickListener {
            movie.liked = false
            Data.favMoviesList.removeAt(position)
            notifyItemRemoved(position)
            notifyItemChanged(position)
            notifyDataSetChanged()
            //showStubIfListEmpty()
        }
    }

    private fun setOnClickListenerForDetailsBtn(holder: FavoritesViewHolder, movie: MovieItem) {
        holder.favMovieDetailsBtn.setOnClickListener {
            notifyDataSetChanged()
            clickListener(movie)
        }
    }
}