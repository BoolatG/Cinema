package com.example.cinema.fragments

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cinema.Data
import com.example.cinema.FavoritesAdapter
import com.example.cinema.MainActivity.Companion.EXTRA
import com.example.cinema.MovieItem
import com.example.cinema.R

class FragmentFavourites:Fragment() {
    companion object{
        const val MOV = "MOV"
    }
    private lateinit var favRecycler: RecyclerView
    private lateinit var emptyListTextView: TextView
    val favList = Data.itemsMain.filter { it.liked }.toMutableList()
//


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_favorites, container,false)
        initFields(view)
        initRecycler(view)
        return view
    }

    private fun initFields(view: View) {
        favRecycler = view.findViewById(R.id.recycler_fav)
        emptyListTextView = view.findViewById(R.id.empty_fav_list_text)

    }

    private fun initRecycler(view: View) {
        if (this.resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            favRecycler.layoutManager = LinearLayoutManager(view.context)
        } else {
            favRecycler.layoutManager = GridLayoutManager(view.context, 2)
        }
        favRecycler.adapter = FavoritesAdapter(
            favList ,emptyListTextView,
            object : FavouriteItemClickListener {
                override fun detailsClickListener(movie: MovieItem) {
                    openFragmentDescription(movie)
                    favRecycler.adapter?.notifyDataSetChanged()

                }

                override fun deleteClickListener(movie: MovieItem, position: Int) {
                    movie.liked= false
                    favRecycler.adapter?.notifyItemChanged(position)
                    favRecycler.adapter?.notifyItemRemoved(position)

                    Toast.makeText(activity,"deleted",Toast.LENGTH_LONG).show()
                }
            })
    }



    interface FavouriteItemClickListener {
     fun detailsClickListener(movie: MovieItem)
     fun deleteClickListener(movie:MovieItem,position: Int)
    }

    private fun openFragmentDescription(movie: MovieItem){
        val bundle = Bundle()
        bundle.putParcelable(EXTRA, movie)

        val fragmentDescription = FragmentDescription()
        fragmentDescription.arguments = bundle

        (activity as AppCompatActivity).supportFragmentManager.beginTransaction()
            .replace(R.id.fragments_container, fragmentDescription)
            .addToBackStack("FragmentDescription")
            .commit()
    }
}