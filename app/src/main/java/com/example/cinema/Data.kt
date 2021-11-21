package com.example.cinema

object Data {
     val itemsMain = mutableListOf<MovieItem>(
        MovieItem(
            "Шрек",
            "Фильм о Шреке",
            R.drawable.sh
        ), MovieItem(
            "Вверх",
            "Фильм о старике и малыше",
            R.drawable.up
        ), MovieItem(
            "Ранго",
            "Фильм о Ранго",
            R.drawable.rango
        ), MovieItem(
            "Кот в сапогах",
            "Фильм о коте в сапогах",
            R.drawable.sapog
        ), MovieItem(
            "Кунг-фу панда",
            "Фильм о Шреке",
            R.drawable.panda
        )
    )
    val favMoviesList:MutableList<MovieItem> =  mutableListOf<MovieItem>()


}