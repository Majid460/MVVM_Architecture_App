package com.example.mvvm_architecture_app.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mvvm_architecture_app.data.model.User
@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll( vararg users: User)

    @Query("SELECT * FROM user ")
    fun getdata():MutableList<User>
}