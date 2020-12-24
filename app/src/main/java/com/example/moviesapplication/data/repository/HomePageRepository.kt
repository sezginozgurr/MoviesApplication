package com.example.moviesapplication.data.repository

import com.example.moviesapplication.data.model.NewsResponse
import com.example.moviesapplication.data.service.ApiService
import com.example.moviesapplication.data.service.RetrofitClient
import retrofit2.Call
import retrofit2.Callback

class HomePageRepository {

    private val service = RetrofitClient.getRetrofit().create(ApiService::class.java)
    val moviesResponse: Call<NewsResponse> = service.getNews()

    fun getNews(
        responseHandle: (NewsResponse) -> Unit,
        errorHandle: (String) -> Unit
    ) {
        moviesResponse.enqueue(object :
            Callback<NewsResponse> {
            override fun onResponse(
                call: Call<NewsResponse>,
                response: retrofit2.Response<NewsResponse>
            ) {
                response.body()?.let { responseHandle.invoke(it) }
            }

            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                t.message?.let { errorHandle.invoke(it) }
            }

        })
    }
}