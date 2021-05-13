package com.example.cinema

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MovieDescriptionActivity : AppCompatActivity() {

    companion object{
        const val EXTRA = "EXTRA"

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_description)




            intent.getParcelableExtra<MovieItem>(EXTRA)?.let{
            findViewById<TextView>(R.id.textView2).text = it.details
            findViewById<ImageView>(R.id.imageView2).setImageResource(it.image)

        }


    }
}