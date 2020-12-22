package com.example.moviesapplication.data.service

import com.example.moviesapplication.Util.Constant
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

abstract class RetrofitClient {

    companion object {
        @Volatile
        private var INSTANCE: Retrofit? = null

        fun getRetrofit():Retrofit {
            return INSTANCE ?: run {
                synchronized(this) {
                    Retrofit.Builder()
                        .addConverterFactory(GsonConverterFactory.create())
                        .baseUrl(Constant.BASE_URL)
                        .client(OkHttpClient.Builder().addInterceptor { chain ->
                            val request = chain.request()
                            val newRequest = request.newBuilder()
                                .addHeader("", "")
                                .build()
                            chain.proceed(newRequest)
                        }.build())
                        .build()
                }
            }
        }
    }
}
