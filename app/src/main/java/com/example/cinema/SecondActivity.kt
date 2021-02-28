package com.example.cinema

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_NAME_SHREK = "EXTRA_NAME_SHREK"
        const val EXTRA_NAME_MX = "EXTRA_NAME_MX"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)




            intent.getParcelableExtra<MovieData>(EXTRA_NAME_SHREK)?.let{
            findViewById<TextView>(R.id.textView2).text = it.details
            findViewById<ImageView>(R.id.imageView2).setImageResource(it.image)
        }

            intent.getParcelableExtra<MovieData>(EXTRA_NAME_MX)?.let{
            findViewById<TextView>(R.id.textView2).text = it.details
            findViewById<ImageView>(R.id.imageView2).setImageResource(it.image)
        }
    }
}