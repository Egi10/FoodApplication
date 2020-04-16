package com.example.foodapplication.repository

import com.example.foodapplication.network.ApiInterface
import com.example.foodapplication.network.model.Response
import com.example.foodapplication.repository.MainRepository
import io.reactivex.Single

class MainRepositoryImpl(private val apiInterface: ApiInterface) :
    MainRepository {
    override fun getCategories(): Single<Response> {
        return apiInterface.categories()
    }
}