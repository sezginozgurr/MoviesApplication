package com.example.moviesapplication.di

import com.example.moviesapplication.BuildConfig
import com.example.moviesapplication.data.service.ApiService
import com.example.moviesapplication.util.Constant
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single { retrofitClient<ApiService>(get()) }
    single { getRetrofit(get()) }
    single { httpClient() }

}

inline fun <reified T> retrofitClient(retrofit: Retrofit): T = retrofit.create(T::class.java)

fun httpClient(): OkHttpClient {
    return OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().apply {
        level = when {
            BuildConfig.DEBUG -> {
                HttpLoggingInterceptor.Level.BODY
            }
            else -> {
                HttpLoggingInterceptor.Level.NONE
            }
        }
    }
    ).build()
}

fun getRetrofit(httpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(Constant.BASE_URL)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .client(httpClient)
        .build()
}

