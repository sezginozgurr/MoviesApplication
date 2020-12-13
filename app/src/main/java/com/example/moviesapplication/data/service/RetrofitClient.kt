package com.example.moviesapplication.data.service

import com.example.moviesapplication.Util.Constant
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

abstract class RetrofitClient { //TODO Retrofitin instance'sini olusturduk.. Sebebi her sayfada tekrar tekrar uretmek zorunda kalmamak..
    //TODO abstract yaptik çünkü aynı isimde bir nesnesi daha oluşturulmasın diye

    companion object {
        @Volatile //TODO Aynı anda birden çok threadin erişimini engellemek için..
        private var INSTANCE: Retrofit? = null

        fun getRetrofit():Retrofit {
            return INSTANCE ?: run {

                synchronized(this) { // Aynı anda birden çok threadin erişimini engellemek için..
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
