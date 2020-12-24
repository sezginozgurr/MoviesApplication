package com.example.moviesapplication.ui.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.moviesapplication.data.model.NewsResponse
import com.example.moviesapplication.data.repository.HomePageRepository
import com.example.moviesapplication.data.service.ApiService
import com.example.moviesapplication.data.service.RetrofitClient
import retrofit2.Call
import retrofit2.Callback

class HomePageViewModel : ViewModel() {

    private lateinit var repository: HomePageRepository

    private val mutableMovies: MutableLiveData<NewsResponse> = MutableLiveData()
    val moviesResponse: LiveData<NewsResponse> = mutableMovies
    val errorBody: MutableLiveData<String>? = null

    fun getNews(){
        repository.getNews({
            mutableMovies.value = it
        }, {
            errorBody?.value = it
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