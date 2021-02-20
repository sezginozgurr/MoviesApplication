package com.example.moviesapplication.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moviesapplication.data.model.NewsResponse
import com.example.moviesapplication.data.repository.HomePageRepository
import com.example.moviesapplication.util.Resource
import com.example.moviesapplication.util.Status
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class HomePageViewModel(private val repository: HomePageRepository) : ViewModel() {

    private val _news = MutableLiveData<Resource<NewsResponse>>()
    val news: LiveData<Resource<NewsResponse>>
        get() = _news

    private val compositeDisposable = CompositeDisposable()

    init {
        getNews()
    }

    private fun getNews() {
        _news.postValue(Resource(status = Status.LOADING, data = null, message = null))
        compositeDisposable.add(
            repository.getNews()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    it?.let {
                        _news.postValue(
                            Resource(
                                status = Status.SUCCESS,
                                data = it,
                                message = null
                            )
                        )
                    }
                }, {
                    _news.postValue(
                        Resource(
                            status = Status.ERROR,
                            data = null,
                            message = it.message
                        )
                    )
                })
        )
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}