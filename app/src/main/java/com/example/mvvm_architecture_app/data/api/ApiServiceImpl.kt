package com.example.mvvm_architecture_app.data.api

import com.example.mvvm_architecture_app.data.model.User
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ApiServiceImpl {

    companion object {
        private  var retrofit: Retrofit? =null;
        private var BASE_URL:String="https://5e510330f2c0d300147c034c.mockapi.io";

        fun getRetrofitInstance(): Retrofit? {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit
        }
    }
}