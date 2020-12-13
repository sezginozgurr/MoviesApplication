package com.example.moviesapplication.ui.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moviesapplication.Util.Resource
import com.example.moviesapplication.data.model.MoviesResponse
import com.example.moviesapplication.data.model.TvShow
import com.example.moviesapplication.data.repository.HomePageRepository

class HomePageViewModel(repository: HomePageRepository) : ViewModel() {
    private val mutableMovies: MutableLiveData<Resource<TvShow>> =
        MutableLiveData(Resource.loading(null))
    val movies: LiveData<Resource<TvShow>>
        get() = mutableMovies

    //Todo Eger fragmentte cagirirsan ekran yan dönünce ölecektir.. Bu yüzden viewmodele yazıyoruz ki ekran da herhangi bir veri kaybı yaşanmasın
    init {
        mutableMovies.value = repository.getAllMovies(1)
    }

}