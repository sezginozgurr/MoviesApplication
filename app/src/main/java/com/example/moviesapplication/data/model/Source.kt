package com.example.moviesapplication.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Source(
    val id: Int? = null,
    val name: String?
) : Parcelable