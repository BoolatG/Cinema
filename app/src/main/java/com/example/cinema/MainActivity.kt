package com.example.cinema

import android.app.AlertDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.cinema.fragments.FragmentFavourites
import com.example.cinema.fragments.FragmentMovieListMain
import com.example.cinema.fragments.ShareFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    companion object {
        const val EXTRA = "EXTRA"
    }
private lateinit var bottomNavigationView: BottomNavigationView
private val recyclerView by lazy { findViewById<RecyclerView>(R.id.recycler_view_movie_list_main) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_bottom_navigation)

        bottomNavigationView = findViewById(R.id.nav_view)

        if (supportFragmentManager.backStackEntryCount == 0) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragments_container, FragmentMovieListMain())
                .addToBackStack("FragmentMovieListMain()")
                .commit()
        }
//        clicklistener для меню управления внизу экрана
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            supportFragmentManager.popBackStack()
            when (item.itemId) {
                R.id.navigation_home -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragments_container, FragmentMovieListMain())
                        .addToBackStack("FilmsListFragment")
                        .commit()
                }
                R.id.navigation_favourites -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragments_container, FragmentFavourites())
                        .addToBackStack("FavouriteFilmsListFragment")
                        .commit()
                }
                R.id.navigation_share -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragments_container, ShareFragment())
                        .addToBackStack("InfoFragment")
                        .commit()
                }
            }
            true

    }}

    //вызов диалогового окна "Выход из приложения"
    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 1) {
        super.onBackPressed()
    } else {


        AlertDialog.Builder(this)
            .setIcon(android.R.drawable.ic_dialog_alert)
            .setTitle("Closing Activity")
            .setMessage("Are you sure you want to close this application?")
            .setPositiveButton("Yes", { dialog, which -> finish() })
            .setNegativeButton("No", null)
            .show()
    }
    }
}










