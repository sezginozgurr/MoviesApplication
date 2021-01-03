package com.example.moviesapplication.data.service

import com.example.moviesapplication.BuildConfig
import com.example.moviesapplication.Util.Constant
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

//    init {
//        val logging = HttpLoggingInterceptor()
//        logging.level = HttpLoggingInterceptor.Level.BODY
//        okhttp3client.addInterceptor(logging)
//    }

    companion object {

        //   private val okhttp3client = OkHttpClient.Builder()

        @Volatile
        private var INSTANCE: Retrofit? = null
        fun getRetrofit(): Retrofit {
            synchronized(this) {
                INSTANCE?.let {
                    return it
                }

                INSTANCE = Retrofit.Builder()
                    .baseUrl(Constant.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(
                        OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().apply {
                            level =
                                when {
                                    BuildConfig.DEBUG -> {
                                        HttpLoggingInterceptor.Level.BODY
                                    }
                                    else -> {
                                        HttpLoggingInterceptor.Level.NONE
                                    }
                                }
                        }
                        )
                            .build()
                    )
                    .build()

                return INSTANCE as Retrofit
            }
        }
    }
}
