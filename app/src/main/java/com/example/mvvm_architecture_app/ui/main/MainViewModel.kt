package com.example.mvvm_architecture_app.ui.main

import androidx.lifecycle.ViewModel
import com.example.mvvm_architecture_app.data.model.User
import com.example.mvvm_architecture_app.data.repository.UserRepository

class MainViewModel(val userRepo:UserRepository) : ViewModel(){
fun getData():MutableList<User> {
    return userRepo.getData()
}
}