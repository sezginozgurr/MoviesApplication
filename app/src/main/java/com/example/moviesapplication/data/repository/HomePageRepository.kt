package com.example.moviesapplication.data.repository

import com.example.moviesapplication.data.service.ApiService

class HomePageRepository(val service: ApiService) {
    fun getAllMovies() = service.getMovies()
}