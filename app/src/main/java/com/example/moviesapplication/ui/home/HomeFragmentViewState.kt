package com.example.moviesapplication.ui.home

import android.view.View
import com.example.moviesapplication.data.Status

data class HomeFragmentViewState(val status: Status) {
    fun getProgressBarVisibility() = if (status == Status.LOADING) View.VISIBLE else View.GONE
    fun getRecyclerViewVisibility() = if (status != Status.LOADING) View.VISIBLE else View.GONE
}