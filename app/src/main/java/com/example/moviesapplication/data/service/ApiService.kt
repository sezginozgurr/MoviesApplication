package com.example.moviesapplication.data.service

import com.example.moviesapplication.data.model.MoviesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService { //TODO Base urlden sonra yapılacak işlem ve gidilecek endpointleri topladığımız interface

    @GET("most-popular")
    fun getMovies(@Query("page") id: Int = 1): Call<MoviesResponse>
}