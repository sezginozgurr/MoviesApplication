package com.example.moviesapplication.data

import com.example.moviesapplication.data.Status.*

data class Resource<T>(var status: Status, val data: T?, val message: String?) {
    companion object {
        fun <T> success(data: T): Resource<T> = Resource(SUCCESS, data, null)
        fun <T> error(message: String): Resource<T> = Resource(ERROR, null, message)
        fun <T> loading(): Resource<T> = Resource(LOADING, null, null)
    }
}
