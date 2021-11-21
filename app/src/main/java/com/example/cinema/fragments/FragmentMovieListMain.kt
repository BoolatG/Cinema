package com.example.cinema.fragments

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cinema.*
import com.example.cinema.MainActivity.Companion.EXTRA

class FragmentMovieListMain:Fragment()
{


    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_movie_list_main, container, false)

        recyclerView = view.findViewById(R.id.recycler_view_movie_list_main)
       initRecycler(view)

        return view
    }

    private fun initRecycler(view: View) {
        if (this.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            recyclerView.layoutManager = GridLayoutManager(view.context, 2)
        } else {
            recyclerView.layoutManager =
                LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
        }

        recyclerView.adapter = MovieAdapter(Data.itemsMain, object:OnItemClickListener{
            override fun onItemClicked(item: MovieItem) {
                openFragmentDescription(item)
            }

            override fun onLikeClicked(item: MovieItem) {
                if(item.liked){
                    Data.favMoviesList.add(item)
                    Toast.makeText(activity,"deleted", Toast.LENGTH_SHORT).show()
                    }
                else{Toast.makeText(activity,"in favourites", Toast.LENGTH_SHORT).show()}
            }

        })

        val itemDecoration = DividerItemDecoration(view.context, DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(itemDecoration)
    }
    private fun openFragmentDescription(movie: MovieItem){
        val bundle = Bundle()
        bundle.putParcelable( EXTRA, movie)

        val fragmentDescription = FragmentDescription()
        fragmentDescription.arguments = bundle

        (activity as AppCompatActivity).supportFragmentManager.beginTransaction()
            .replace(R.id.fragments_container, fragmentDescription)
            .addToBackStack("FragmentDescription")
            .commit()
    }

}