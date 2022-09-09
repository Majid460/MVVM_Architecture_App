package com.example.mvvm_architecture_app.ui.main

import com.example.mvvm_architecture_app.R

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvm_architecture_app.data.model.User
import org.w3c.dom.Text


class CustomAdapter(private val user: MutableList<User>, context: Context) :RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    private  var context=context
    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        var image=itemView.findViewById<ImageView>(R.id.imageViewAvatar)
        var title=itemView.findViewById<TextView>(R.id.textViewUserName)
        var email=itemView.findViewById<TextView>(R.id.textViewUserEmail)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text=user[position].name
        holder.email.text=user[position].email
        Glide.with(context).load(user[position].avatar).error(R.drawable.avatar).into(holder.image)

    }
    override fun getItemCount(): Int {
        return user.size
    }
}

