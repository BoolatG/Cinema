package com.example.cinema
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class MovieItem(val title:String, val details:String, val image:Int):Parcelable {
     var liked = false

}