package com.example.moviesapplication.data.repository

import androidx.fragment.app.viewModels
import com.example.moviesapplication.data.service.ApiService
import com.example.moviesapplication.data.service.RetrofitClient

class HomePageRepository() {

    private val service = RetrofitClient.getRetrofit().create(ApiService::class.java)

    fun getAllMovies(id: Int) {
        service.getMovies(id)
    }
}