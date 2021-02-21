package com.example.moviesapplication.ui.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapplication.data.Resource
import com.example.moviesapplication.data.model.NewsResponse
import com.example.moviesapplication.data.repository.HomePageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomePageViewModel @Inject constructor(private val homePageRepository: HomePageRepository) :
    ViewModel() {
    private val _news = MutableLiveData<Resource<NewsResponse?>>()
    val news: LiveData<Resource<NewsResponse?>> get() = _news

    init {
        getNews()
    }

    private fun getNews() {
        viewModelScope.launch {
            homePageRepository.getNews()
                .onStart { emit(Resource.loading()) }
                .catch { emit(Resource.error(it.message ?: it.toString())) }
                .collect {
                    _news.postValue(it)
                }
        }
    }

}