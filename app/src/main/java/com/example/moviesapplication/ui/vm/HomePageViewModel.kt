package com.example.moviesapplication.ui.vm

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.moviesapplication.data.model.NewsResponse
import com.example.moviesapplication.data.repository.HomePageRepository

class HomePageViewModel : ViewModel() {

    private var repository = HomePageRepository()
    private val mutableNews: MutableLiveData<NewsResponse> = MutableLiveData()
    val newsResponse: LiveData<NewsResponse> = mutableNews
    val errorBody: MutableLiveData<String>? = null

    init {
        getNews()
    }

    private fun getNews() {
        repository.getNews({
            mutableNews.value = it
        }, {
            errorBody?.value = it
        })
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("viewModel cleared", "cleared")
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