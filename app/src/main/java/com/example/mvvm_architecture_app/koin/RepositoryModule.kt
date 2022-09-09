package com.example.mvvm_architecture_app.koin

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import com.bumptech.glide.load.engine.Resource
import com.example.mvvm_architecture_app.data.api.ApiHandler
import com.example.mvvm_architecture_app.data.db.UserDao
import com.example.mvvm_architecture_app.data.db.UserDatabase
import com.example.mvvm_architecture_app.data.repository.UserRepository
import com.example.mvvm_architecture_app.ui.main.MainViewModel
import org.koin.android.compat.ScopeCompat.viewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module



    val userDB = module {
        fun provideDataBase(application: Application):UserDatabase {
            return Room.databaseBuilder(application, UserDatabase::class.java, "USERDB")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build()
        }

        fun provideDao(dataBase: UserDatabase): UserDao {
            return dataBase.userdao
        }
        single { ApiHandler() }

        single {
            UserRepository(get(), provideDao(get()))
        }
        single{provideDataBase(androidApplication())}
    }
val  mainViewModel= module{
    viewModel {
        MainViewModel(get())
    }
}
