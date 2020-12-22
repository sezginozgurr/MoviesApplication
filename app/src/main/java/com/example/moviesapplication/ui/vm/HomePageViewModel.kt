package com.example.moviesapplication.ui.vm

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.moviesapplication.Util.Resource
import com.example.moviesapplication.data.model.MoviesResponse
import com.example.moviesapplication.data.model.TvShow
import com.example.moviesapplication.data.repository.HomePageRepository
import com.example.moviesapplication.data.service.ApiService
import com.example.moviesapplication.data.service.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.IllegalArgumentException

class HomePageViewModel() : ViewModel() {

    private val mutableMovies: MutableLiveData<MoviesResponse> = MutableLiveData()
    val moviesResponses: LiveData<MoviesResponse> = mutableMovies

    val api: ApiService = RetrofitClient.getRetrofit().create(ApiService::class.java)

    val moviesResponse: Call<MoviesResponse> = api.getMovies(1)

    fun getMovies() {
        moviesResponse.enqueue(object : Callback<MoviesResponse> {
            override fun onResponse(
                call: Call<MoviesResponse>,
                response: Response<MoviesResponse>
            ) {
                mutableMovies.value = response.body()
            }

            override fun onFailure(call: Call<MoviesResponse>, t: Throwable) {
                //
            }
        })
    }

    class Factory() : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(HomePageViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return HomePageViewModel() as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel ")
        }
    }
}