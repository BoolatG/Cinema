package com.example.cinema

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cinema.Data.itemsMain
import com.example.cinema.fragments.FragmentFavourites

class FavoritesAdapter(val items: List<MovieItem>, private val emptyListTextView: TextView, private val clickListener: FragmentFavourites.FavouriteItemClickListener):RecyclerView.Adapter<FavoritesViewHolder>() {

    val movies = itemsMain.filter{it.liked}.toMutableList()

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

    private fun setOnClickListenerForDeleteBtn(holder: FavoritesViewHolder, movie: MovieItem, position: Int) {
        holder.favDeleteBtn.setOnClickListener {
           //movie.liked = false
            movies.remove(movie)
            clickListener.deleteClickListener(movie,position)

            notifyDataSetChanged()
            notifyItemRemoved(position)







        }
    }

    private fun setOnClickListenerForDetailsBtn(holder: FavoritesViewHolder, movie: MovieItem) {
        holder.favMovieDetailsBtn.setOnClickListener {
            clickListener.detailsClickListener(movie)
            notifyDataSetChanged()

        }
    }
}