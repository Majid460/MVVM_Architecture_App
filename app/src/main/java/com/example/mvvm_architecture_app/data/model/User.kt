package com.example.mvvm_architecture_app.data.model

import androidx.room.Entity
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
@Entity(tableName = "user")
data class User (
    @PrimaryKey
     @SerializedName("id")
     val id:Int=0,
     @SerializedName("name")
     val name:String="",
     @SerializedName("email")
     val email:String="",
     @SerializedName("avatar")
     val avatar:String=""
)