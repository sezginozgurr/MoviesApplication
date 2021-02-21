package com.example.moviesapplication.data.repository

import com.example.moviesapplication.data.Resource
import com.example.moviesapplication.data.model.NewsResponse
import com.example.moviesapplication.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class HomePageRepository @Inject constructor(private val apiService: ApiService) {
    fun getNews() = flow<Resource<NewsResponse?>> {
        val response = apiService.getNews()
        if (response.isSuccessful) {
            emit(Resource.success(response.body()))
        } else {
            emit(Resource.error(response.message()))
        }
    }.flowOn(Dispatchers.IO)
}