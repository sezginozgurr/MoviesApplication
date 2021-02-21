package com.example.moviesapplication.network

import com.example.moviesapplication.data.model.NewsResponse
import com.example.moviesapplication.util.Constant
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("top-headlines")
    suspend fun getNews(
        @Query("country") country: String = "tr",
        @Query("apiKey") apiKey: String = Constant.API_KEY
    ): Response<NewsResponse>
}