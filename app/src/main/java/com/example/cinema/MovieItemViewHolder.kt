package com.example.cinema;

import android.graphics.Color
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class MovieItemViewHolder(itemView:View): RecyclerView.ViewHolder(itemView) {
    val movieTitle = itemView.findViewById<TextView>(R.id.movieTitle)
    val movieImage = itemView.findViewById<ImageView>(R.id.imageView)
    val detailsBtn = itemView.findViewById<TextView>(R.id.movieDetailsBtn)
    val likeBtn = itemView.findViewById<ImageView>(R.id.buttonLike)
        //val favoritesBtn = itemView.findViewById<View>(R.id.buttonFavorites)

    fun bind(item: MovieItem, clickListener: OnItemClickListener){
        movieTitle.text = item.title
        movieImage.setImageResource(item.image)

        detailsBtn.setOnClickListener {
            clickListener.onItemClicked(item)
            movieTitle.setTextColor(Color.GREEN)


        }

        updateLike(item.liked)

        likeBtn.setOnClickListener{
            clickListener.onLikeClicked(item)
            item.liked = !item.liked
            updateLike(item.liked)


            /*if(!item.liked){
                likeBtn.setImageResource(R.drawable.filled_heart)
                item.liked = true
                Data.favMoviesList.add(item)
            }
            else{
                likeBtn.setImageResource(R.drawable.empty_heart)
                item.liked = false
                Data.favMoviesList.remove(item)
            }*/

        }

    }
    private fun updateLike(liked:Boolean){
        if(liked){
            likeBtn.setImageResource(R.drawable.filled_heart)
                        }
        else{likeBtn.setImageResource(R.drawable.empty_heart)
            }
    }
}

