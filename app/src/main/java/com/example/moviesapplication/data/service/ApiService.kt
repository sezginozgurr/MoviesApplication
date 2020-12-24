package com.example.moviesapplication.data.service

import com.example.moviesapplication.Util.Constant
import com.example.moviesapplication.data.model.NewsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService { //TODO Base urlden sonra yapılacak işlem ve gidilecek endpointleri topladığımız interface

    @GET("top-headlines")
    fun getNews(
        @Query("country") country: String = "tr",
        @Query("apiKey") apiKey: String = Constant.API_KEY
    ): Call<NewsResponse>
}