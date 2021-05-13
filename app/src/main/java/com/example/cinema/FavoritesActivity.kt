package com.example.cinema

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cinema.MovieDescriptionActivity.Companion.EXTRA

class FavoritesActivity : AppCompatActivity() {
    companion object{const val MOVIE = "MOVIE"}

    lateinit var favRecycler: RecyclerView
    private lateinit var noFavItemTextView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorites)
        favRecycler = findViewById(R.id.recycler_fav)

        initFields()
        initRecycler()
    }

    private fun openFavoritesActivity(movie: MovieItem) {
        val intent = Intent(this, MovieDescriptionActivity::class.java).apply {
            putExtra(EXTRA, movie)
        }
        startActivity(intent)
    }
    private fun initFields() {

        noFavItemTextView = findViewById(R.id.empty_fav_list_text)
            }

   private fun initRecycler() {
       val itemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
       favRecycler.addItemDecoration(itemDecoration)
        if (this.resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
        favRecycler.layoutManager = LinearLayoutManager(this)

    } else {
        favRecycler.layoutManager = GridLayoutManager(this, 2)
    }
        favRecycler.adapter = FavoritesAdapter(Data.favMoviesList, noFavItemTextView) { movie ->
            openFavoritesActivity(movie)
        }
        if (Data.favMoviesList.isEmpty()) {
        noFavItemTextView.visibility = View.VISIBLE

       } else {
       noFavItemTextView.visibility = View.GONE
    }
}
}