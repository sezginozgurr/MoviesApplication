package com.example.moviesapplication.data.service

import com.example.moviesapplication.data.model.NewsResponse
import com.example.moviesapplication.util.Constant
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("top-headlines")
    fun getNews(
        @Query("country") country: String = "tr",
        @Query("apiKey") apiKey: String = Constant.API_KEY
    ): Flowable<NewsResponse>
}