package com.example.moviesapplication.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NewsResponse(
    val articles: List<Article>?,
    val status: String?,
    val totalResults: Long?
) : Parcelable
