package com.example.moviesapplication.ui.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.moviesapplication.data.repository.HomePageRepository

class MyViewModelFactory(val repository: HomePageRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(HomePageRepository::class.java).newInstance()
    }
}