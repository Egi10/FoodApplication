package com.example.foodapplication.repository

import com.example.foodapplication.network.model.Response
import io.reactivex.Single

interface MainRepository {
    fun getCategories(): Single<Response>
}