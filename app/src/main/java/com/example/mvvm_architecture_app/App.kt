package com.example.mvvm_architecture_app

import android.app.Application
import com.example.mvvm_architecture_app.koin.mainViewModel
import com.example.mvvm_architecture_app.koin.userDB
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidLogger()
            androidContext(this@App)
            modules(userDB,
            mainViewModel)
        }
    }
}