 package com.example.moviesapplication.data.model


import com.google.gson.annotations.SerializedName

data class MoviesResponse( //TODO Bir istek(request) işlemi sonucunda sana dönecek olan datalar Response'dir.. Her model birebir aynı olmalıdır
    @SerializedName("page")
    var page: Int?,
    @SerializedName("pages")
    var pages: Int?,
    @SerializedName("total")
    var total: String?,
    @SerializedName("tv_shows")
    var tvShows: ArrayList<TvShow>?
)