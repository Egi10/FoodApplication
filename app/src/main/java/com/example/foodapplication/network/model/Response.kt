package com.example.foodapplication.network.model

import com.google.gson.annotations.SerializedName

data class Response(

	@field:SerializedName("categories")
	val categories: List<CategoriesItem>? = null
)