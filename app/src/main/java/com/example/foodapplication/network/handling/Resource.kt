package com.example.foodapplication.network.handling

data class Resource<out T>(val status: Status?, val data: T?, val message: String?) {
    companion object {
        fun <T> success(data: T?): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }

        fun <T> error(msg: String, data: T?): Resource<T> {
            return Resource(Status.ERROR, data, msg)
        }

        fun <T> empty(msg: String, data: T?): Resource<T> {
            return Resource(Status.EMPTY, data, msg)
        }
    }
}