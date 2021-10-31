package com.example.cinema

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FavoritesAdapter(val items: List<MovieItem>, private val emptyListTextView: TextView, private val clickListener: (movie: MovieItem) -> Unit):RecyclerView.Adapter<FavoritesViewHolder>() {

    private val movies = items.toMutableList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritesViewHolder {
        val holder = LayoutInflater.from(parent.context)
        val view = holder.inflate(R.layout.item_movie_favorites, parent, false)
        return FavoritesViewHolder(view)
    }



    override fun onBindViewHolder(holder: FavoritesViewHolder, position: Int) {
        holder.bind(movies[position])
        setOnClickListenerForDetailsBtn(holder, movies[position])
        setOnClickListenerForDeleteBtn(holder, movies[position], position)
    }

    override fun getItemCount(): Int {
        return movies.size
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
            movies.remove(movie)
//            Data.favMoviesList.removeAt(position)
            notifyItemRemoved(position)


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