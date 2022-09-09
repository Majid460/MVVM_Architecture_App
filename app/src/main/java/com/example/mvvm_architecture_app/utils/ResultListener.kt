package com.example.mvvm_architecture_app.utils

import com.example.mvvm_architecture_app.data.model.User

interface ResultListener {
    fun onSuccess(successModel: MutableList<User>)
    fun onFail(any: String?)
    fun onError(e: Throwable?)
}