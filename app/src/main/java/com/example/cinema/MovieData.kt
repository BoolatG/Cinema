package com.example.cinema
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
class MovieData(val details:String, val image:Int):Parcelable {
}