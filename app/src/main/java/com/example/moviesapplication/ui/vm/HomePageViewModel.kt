package com.example.moviesapplication.ui.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.moviesapplication.data.model.NewsResponse
import com.example.moviesapplication.data.service.ApiService
import com.example.moviesapplication.data.service.RetrofitClient
import retrofit2.Call
import retrofit2.Callback

class HomePageViewModel : ViewModel() {

    private val mutableMovies: MutableLiveData<NewsResponse> =
        MutableLiveData()
    val moviesResponses: LiveData<NewsResponse> =
        mutableMovies

    val api: ApiService = RetrofitClient.getRetrofit().create(ApiService::class.java)

    val moviesResponse: Call<NewsResponse> =
        api.getMovies()

    init {
        getMovies()
    }

    fun getMovies() {
        moviesResponse.enqueue(object :
            Callback<NewsResponse> {
            override fun onResponse(
                call: Call<NewsResponse>,
                response: retrofit2.Response<NewsResponse>
            ) {
                mutableMovies.value = response.body()
            }

            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    class Factory : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(HomePageViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return HomePageViewModel() as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel ")
        }
    }
}