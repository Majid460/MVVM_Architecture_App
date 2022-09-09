package com.example.mvvm_architecture_app.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mvvm_architecture_app.data.model.User

@Database(
    entities = [User::class],
    version=1,
    exportSchema = true
)
abstract class UserDatabase: RoomDatabase() {
    abstract val userdao: UserDao

}