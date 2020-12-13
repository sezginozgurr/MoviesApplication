package com.example.moviesapplication.data.repository

import com.example.moviesapplication.data.service.ApiService

class HomePageRepository(private val service: ApiService) {
    //TODO Genel de repository, data ve room olan projelerde genel de eğer apiden veri gelmez ise roomda kaydedilen son veriyi göstermek için kullanılır
    //TODO Yada roomdan göstermesekte arada bir katman olarak kullanabilirsin.. Viewmodelden buraya, burdan apiye ulaşabilrisin
    // Repository genel olarak verileri(bilgileri,dataları) ulaştığın dağıtıcı
    fun getAllMovies() = service.getMovies()
}