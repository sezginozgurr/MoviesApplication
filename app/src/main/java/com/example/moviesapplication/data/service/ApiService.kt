package com.example.moviesapplication.data.service

import retrofit2.Call
import retrofit2.http.GET

interface ApiService { //TODO Base urlden sonra yapılacak işlem ve gidilecek endpointleri topladığımız interface

    @GET("todos")
    fun getMovies(): Call<List<com.example.moviesapplication.data.modelNew.Response>>
}