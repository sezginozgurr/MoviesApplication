package com.example.moviesapplication.di

import com.example.moviesapplication.data.repository.HomePageRepository
import com.example.moviesapplication.vm.HomePageViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { HomePageViewModel(get()) }

    single { HomePageRepository(get()) }
}