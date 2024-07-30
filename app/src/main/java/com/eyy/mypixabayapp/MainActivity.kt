package com.eyy.mypixabayapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.eyy.mypixabayapp.adapter.ImageAdapter
import com.eyy.mypixabayapp.model.PixabayResponse
import com.eyy.mypixabayapp.network.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        fetchImages()
    }

    private fun fetchImages() {
        val apiKey = "45190459-fb53a953b7d52452efdd1d63c"
        val call = RetrofitInstance.api.getImages(apiKey, "nature")

        call.enqueue(object : Callback<PixabayResponse> {
            override fun onResponse(call: Call<PixabayResponse>, response: Response<PixabayResponse>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        Log.d("PixabayResponse", it.toString())
                        recyclerView.adapter = ImageAdapter(it.hits)
                    }
                } else {
                    Log.e("PixabayResponse", "Response Code: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<PixabayResponse>, t: Throwable) {
                Log.e("PixabayResponse", "Error: ${t.message}")
            }
        })
    }
}