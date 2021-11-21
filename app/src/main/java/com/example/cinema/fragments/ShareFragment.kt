package com.example.cinema.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.cinema.R

class ShareFragment:Fragment()
{

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_share, container, false)

        view?.findViewById<Button>(R.id.btn_share)?.setOnClickListener {
            val inviteIntent = Intent(Intent.ACTION_SEND)
            inviteIntent.setType("message/rfc822")
            startActivity(inviteIntent)
        }
        return view
    }
}
