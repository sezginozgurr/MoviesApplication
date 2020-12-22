package com.example.moviesapplication.data.modelNew

import com.google.gson.annotations.SerializedName


//
//class A : ArrayList<AItem>()

data class Response(
    @SerializedName("completed")
    val completed: Boolean,
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("userId")
    val userId: Int
)