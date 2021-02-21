package com.example.moviesapplication.di

import com.example.moviesapplication.data.repository.HomePageRepository
import com.example.moviesapplication.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {
    @Provides
    @ViewModelScoped
    fun provideHomePageRepository(apiService: ApiService): HomePageRepository {
        return HomePageRepository(apiService)
    }
}