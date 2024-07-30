package com.eyy.mypixabayapp.network

import com.eyy.mypixabayapp.model.PixabayResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PixabayApiService {
    @GET("/api/")
    fun getImages(
        @Query("key") apiKey: String,
        @Query("q") query: String,
        @Query("image_type") imageType: String = "photo"
    ): Call<PixabayResponse>
}