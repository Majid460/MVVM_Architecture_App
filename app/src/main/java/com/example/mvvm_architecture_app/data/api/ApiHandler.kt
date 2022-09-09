package com.example.mvvm_architecture_app.data.api

import com.example.mvvm_architecture_app.data.model.User
import com.example.mvvm_architecture_app.utils.ResultListener
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiHandler() {
    private val service= ApiServiceImpl.getRetrofitInstance()?.create(ApiService::class.java) as ApiService
    var call: Call<MutableList<User>> = service.getUsers()

    fun get( resultListener: ResultListener){
        call.enqueue(object: Callback<MutableList<User>> {

            override fun onResponse(call: Call<MutableList<User>>, response: Response<MutableList<User>>) {

                val Users: MutableList<User>? = response.body()
                if(response.isSuccessful){

                    response.body()?.let {
                        resultListener.onSuccess(it)

                    }
                }
            }
            override fun onFailure(call: Call<MutableList<User>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

    }

    fun show(list: User): User {
        println(list)
        return list
    }
}