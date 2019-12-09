package com.example.foodapplication.network

import com.example.foodapplication.network.model.Response
import io.reactivex.Single
import retrofit2.http.GET

interface ApiInterface {
    @GET("categories.php")
    fun categories(): Single<Response>
}