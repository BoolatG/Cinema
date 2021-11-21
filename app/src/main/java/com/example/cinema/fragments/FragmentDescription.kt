package com.example.cinema.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.cinema.MainActivity.Companion.EXTRA
import com.example.cinema.MovieItem
import com.example.cinema.R

class FragmentDescription : Fragment() {

    private lateinit var imageView: ImageView
    private lateinit var toolbar: Toolbar
    private lateinit var descriptionView: TextView
    private lateinit var movie: MovieItem

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_description, container, false)
        initFields(view)
        getBundleWithFilmInfo()
        fillFieldsWithData()
        return view
    }

    private fun initFields(view: View) {
        toolbar = view.findViewById(R.id.toolbar_description)
        imageView = view.findViewById(R.id.image_view)
        descriptionView = view.findViewById(R.id.tv_description_film)
    }

    private fun getBundleWithFilmInfo() {
        val bundle = arguments
        movie = bundle?.getParcelable(EXTRA)!!
    }

    private fun fillFieldsWithData() {
        imageView.setImageResource(movie.image)
        toolbar.title = movie.title
        descriptionView.text = movie.details
    }
}