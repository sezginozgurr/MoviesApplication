package com.example.moviesapplication.data.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object {

        val baseURL = "https://jsonplaceholder.typicode.com/"

        @Volatile
        private var INSTANCE: Retrofit? = null
        fun getRetrofit(): Retrofit {
            synchronized(this) {
                INSTANCE?.let {
                    return it
                }

                INSTANCE = Retrofit.Builder()
                    .baseUrl(baseURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                return INSTANCE as Retrofit
            }
        }
    }
}

//.client(OkHttpClient.Builder().addInterceptor { chain ->
//    val request = chain.request()
//    val newRequest = request.newBuilder()
//        .addHeader("", "")
//        .build()
//    chain.proceed(newRequest)
//}.build())