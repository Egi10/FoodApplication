package com.example.foodapplication.ui

import com.example.foodapplication.network.model.Response
import io.reactivex.Single

interface MainRepository {
    fun getCategories(): Single<Response>
}