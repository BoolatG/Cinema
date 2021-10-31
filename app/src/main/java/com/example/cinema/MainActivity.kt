package com.example.cinema

import android.app.AlertDialog
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity(),OnItemClickListener {
    companion object {
        //private const  val TAGi = "MainActivity-Caramba!"
        private const val EXTRA = "EXTRA"
        //private const val FAV = "FAV"
        private const val REQ = 1
    }

    private val recyclerView by lazy { findViewById<RecyclerView>(R.id.recycler_view_main) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie_list_main)
        initRecycler()
        //кнопка "Пригласить друга"
        findViewById<Button>(R.id.buttonInvite).setOnClickListener {
            val inviteIntent = Intent(Intent.ACTION_SEND)
            inviteIntent.setType("message/rfc822")
            startActivity(inviteIntent)
        }
        //кнопка "Избранное"
        findViewById<Button>(R.id.buttonFavorites).setOnClickListener {
            val intent = Intent(this, FavoritesActivity::class.java).apply {
            }
            startActivityForResult(intent, REQ)
        }

    }

    private fun initRecycler() {
        if (this.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            recyclerView.layoutManager = GridLayoutManager(this, 2)
        } else {
            recyclerView.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        }

        recyclerView.adapter = MovieAdapter(Data.itemsMain, this)

        val itemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(itemDecoration)
    }

    //вызов диалогового окна "Выход из приложения"
    override fun onBackPressed() {
        AlertDialog.Builder(this)
            .setIcon(android.R.drawable.ic_dialog_alert)
            .setTitle("Closing Activity")
            .setMessage("Are you sure you want to close this application?")
            .setPositiveButton("Yes", { dialog, which -> finish() })
            .setNegativeButton("No", null)
            .show()
    }


    //реализация клика в MainActivity для кнопки Детали
    override fun onItemClicked(item: MovieItem) {
        val intent = Intent(this, MovieDescriptionActivity::class.java).apply {
            putExtra(EXTRA, item)
        }
        startActivity(intent)
//        recyclerView.adapter?.notifyDataSetChanged()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode == REQ){
            recyclerView.adapter?.notifyDataSetChanged()
        }
        else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

    //реализация клика в MainActivity для лайка
    override fun onLikeClicked(item: MovieItem) {
        if (!item.liked) {
            Toast.makeText(this, "Сохранено в избранное!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Удалено из избранного!", Toast.LENGTH_SHORT).show()
        }
        recyclerView.adapter?.notifyDataSetChanged()
    }
//    override fun onResume() {
//        super.onResume()
//        recyclerView.adapter?.notifyDataSetChanged()
//    }
}










//val shrekDetails = "Описание фильма про Шрека"
//val mxDetails = "Описание фильма про Нео"}}


//что происходит при нажатии кнопки
// findViewById<View>(R.id.buttonShrek).setOnClickListener(){
// findViewById<TextView>(R.id.textShrek).setTextColor(Color.RED)
// val intent = Intent(this, SecondActivity::class.java)
// intent.putExtra(SecondActivity.EXTRA_NAME_SHREK, MovieItem("Shrek",shrekDetails, R.drawable.sh))
// startActivity(intent)
// }
// /*findViewById<Button>(R.id.buttonMx).setOnClickListener(){
// findViewById<TextView>(R.id.textMx).setTextColor(Color.GREEN)
// val intent = Intent(this, SecondActivity::class.java)
// intent.putExtra(SecondActivity.EXTRA_NAME_MX, MovieItem(mxDetails, R.drawable.ma))
// startActivity(intent)
// }
//
//
// //вызов сохраненного состояния при уничтожении активити
// savedInstanceState?.getInt(EXTRA_SHREK)?.let{
// findViewById<TextView>(R.id.textShrek).setTextColor(it)
// }
// savedInstanceState?.getInt(EXTRA_MX)?.let{
// findViewById<TextView>(R.id.textMx).setTextColor(it)
// }
//
// //кнопка "Пригласить друга"
//findViewById<Button>(R.id.buttonInvite).setOnClickListener{
//val inviteIntent = Intent(Intent.ACTION_SEND)
// inviteIntent.setType("message/rfc822")
//startActivity(inviteIntent)
// }
//
//
// }
// //сохранение цвета названия фильма после нажатия кнопки
// override fun onSaveInstanceState(outState: Bundle) {
// super.onSaveInstanceState(outState)
// Log.d(TAGi, "savedInstanceState called AAA")
// outState.putInt(EXTRA_SHREK, findViewById<TextView>(R.id.textShrek).currentTextColor)
// outState.putInt(EXTRA_MX, findViewById<TextView>(R.id.textMx).currentTextColor)
// }