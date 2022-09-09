package com.example.mvvm_architecture_app.data.repository

import android.content.Context
import android.widget.Toast
import com.example.mvvm_architecture_app.data.api.ApiHandler
import com.example.mvvm_architecture_app.data.db.UserDao
import com.example.mvvm_architecture_app.data.model.User
import com.example.mvvm_architecture_app.utils.ResultListener


class UserRepository(val apiHandler: ApiHandler,val userDao: UserDao) {

////  Returned Data
  fun getData():MutableList<User>{

     apiHandler.get(resultListener = object : ResultListener {

          override fun onSuccess(successModel: MutableList<User>) {

              successModel.forEach {
                  userDao.insertAll(it)
              }

          }

          override fun onFail(any: String?) {}

          override fun onError(e: Throwable?) {}
      })
   return userDao.getdata()
  }

}