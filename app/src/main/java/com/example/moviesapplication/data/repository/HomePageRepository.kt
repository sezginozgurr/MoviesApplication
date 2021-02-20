package com.example.moviesapplication.data.repository

import com.example.moviesapplication.data.service.ApiService

class HomePageRepository(private val apiService: ApiService) {

    /* private val service = RetrofitClient.getRetrofit().create(ApiService::class.java)
     val newsResponse: Call<NewsResponse> = service.getNews()*/

    /* fun getNews(
         responseHandle: (NewsResponse) -> Unit,
         errorHandle: (String) -> Unit
     ) {
         newsResponse.enqueue(object :
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
     }*/

    fun getNews() = apiService.getNews()
}