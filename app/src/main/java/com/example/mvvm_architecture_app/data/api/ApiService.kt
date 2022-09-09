package com.example.mvvm_architecture_app.data.api

import com.example.mvvm_architecture_app.data.model.User
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("/users")
    fun getUsers(): Call<MutableList<User>>
}