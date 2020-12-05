package com.example.moviesapplication.data.model


import com.google.gson.annotations.SerializedName

data class MoviesResponse(
    @SerializedName("page")
    var page: Int?,
    @SerializedName("pages")
    var pages: Int?,
    @SerializedName("total")
    var total: String?,
    @SerializedName("tv_shows")
    var tvShows: List<TvShow>?
)

data class TvShow(
    @SerializedName("country")
    var country: String?,
    @SerializedName("end_date")
    var endDate: Any?,
    @SerializedName("id")
    var id: Int?,
    @SerializedName("image_thumbnail_path")
    var imageThumbnailPath: String?,
    @SerializedName("name")
    var name: String?,
    @SerializedName("network")
    var network: String?,
    @SerializedName("permalink")
    var permalink: String?,
    @SerializedName("start_date")
    var startDate: String?,
    @SerializedName("status")
    var status: String?
)