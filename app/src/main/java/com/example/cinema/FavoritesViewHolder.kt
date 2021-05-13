package com.example.cinema

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FavoritesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val favMovieTitle = itemView.findViewById<TextView>(R.id.favMovieTitle)
    val favMovieImage = itemView.findViewById<ImageView>(R.id.favImageView)
    val favMovieDetailsBtn = itemView.findViewById<Button>(R.id.favDetailsBtn)
    val favDeleteBtn = itemView.findViewById<ImageView>(R.id.deleteBtn)

    fun bind(item: MovieItem){
        favMovieTitle.text = item.title
        favMovieImage.setImageResource(item.image)
        }
}