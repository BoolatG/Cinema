package com.example.cinema

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    companion object{
    private const  val TAGi = "MainActivity-Caramba!"
    private const val EXTRA_SHREK = "EXTRA_SHREK"
    private const val EXTRA_MX = "EXTRA_MX"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val shrekDetails = "Описание фильма про Шрека"
        val mxDetails = "Описание фильма про Нео"




        //что происходит при нажатии кнопки "детали"
        findViewById<View>(R.id.buttonShrek).setOnClickListener(){
             findViewById<TextView>(R.id.textShrek).setTextColor(Color.RED)
            val intent = Intent(this, DescriptionActivity::class.java)
            intent.putExtra(DescriptionActivity.EXTRA_NAME_SHREK, MovieData(shrekDetails, R.drawable.sh))
            startActivity(intent)
        }
        findViewById<Button>(R.id.buttonMx).setOnClickListener(){
            findViewById<TextView>(R.id.textMx).setTextColor(Color.GREEN)
            val intent = Intent(this, DescriptionActivity::class.java)
            intent.putExtra(DescriptionActivity.EXTRA_NAME_MX, MovieData(mxDetails, R.drawable.ma))
            startActivity(intent)
        }


        //вызов сохраненного состояния при уничтожении активити
        savedInstanceState?.getInt(EXTRA_SHREK)?.let{
            findViewById<TextView>(R.id.textShrek).setTextColor(it)
            }
        savedInstanceState?.getInt(EXTRA_MX)?.let{
            findViewById<TextView>(R.id.textMx).setTextColor(it)
        }

        //кнопка "Пригласить друга"
        findViewById<Button>(R.id.buttonInvite).setOnClickListener{
            val inviteIntent = Intent(Intent.ACTION_SEND)
            inviteIntent.setType("message/rfc822")
            startActivity(inviteIntent)
        }


    }
    //сохранение цвета названия фильма после нажатия кнопки
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAGi, "savedInstanceState called AAA")
        outState.putInt(EXTRA_SHREK, findViewById<TextView>(R.id.textShrek).currentTextColor)
        outState.putInt(EXTRA_MX, findViewById<TextView>(R.id.textMx).currentTextColor)
    }


}
