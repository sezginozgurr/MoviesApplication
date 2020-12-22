package com.example.moviesapplication.data.service

import com.example.moviesapplication.Util.Resource
import com.example.moviesapplication.data.model.MoviesResponse
import com.example.moviesapplication.data.model.TvShow
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService { //TODO Base urlden sonra yapılacak işlem ve gidilecek endpointleri topladığımız interface

    @GET("most-popular")
    fun getMovies(@Query("page") id: Int): Call<MoviesResponse>
}