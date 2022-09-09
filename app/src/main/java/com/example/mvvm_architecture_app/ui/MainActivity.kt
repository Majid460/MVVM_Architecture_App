package com.example.mvvm_architecture_app.ui


import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_architecture_app.R
import com.example.mvvm_architecture_app.data.model.User
import com.example.mvvm_architecture_app.databinding.ActivityMainBinding
import com.example.mvvm_architecture_app.ui.main.CustomAdapter
import com.example.mvvm_architecture_app.ui.main.MainViewModel
import com.example.mvvm_architecture_app.utils.ResultListener
import org.koin.android.ext.android.get

class MainActivity : AppCompatActivity(),ResultListener {
    private lateinit var customAdapter: CustomAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var binding: ActivityMainBinding
    private lateinit var progressBar: ProgressBar
    val mainViewModel:MainViewModel=get()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        progressBar=findViewById(R.id.progressBar)
        progressBar.progress = 10
        mainViewModel.getData().let {
        Handler().postDelayed({
            onSuccess(it)
          },2000)
      }
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onSuccess(successModel: MutableList<User>) {
        progressBar.visibility= View.GONE
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.visibility=View.VISIBLE
        customAdapter = CustomAdapter( successModel,this)
        recyclerView.layoutManager= LinearLayoutManager(this, RecyclerView.VERTICAL,false)
        recyclerView.adapter=customAdapter
        customAdapter.notifyDataSetChanged()
    }

    override fun onFail(any: String?) {
        Toast.makeText(this,"Failed to Fetch Data From Server",Toast.LENGTH_SHORT).show()
    }

    override fun onError(e: Throwable?) {
       Toast.makeText(this,"Error while Loading",Toast.LENGTH_SHORT).show()
    }
}