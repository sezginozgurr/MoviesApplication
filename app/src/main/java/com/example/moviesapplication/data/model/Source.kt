package com.example.moviesapplication.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Source(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("name")
    val name: String?
) : Parcelable