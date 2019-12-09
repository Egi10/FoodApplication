package com.example.foodapplication.network.handling

data class Resource<out T>(val status: Status?, val data: T?, val message: String?) {
    companion object {
        fun <T> success(data: T?): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }

        fun <T> error(msg: String, data: T?): Resource<T> {
            return Resource(Status.ERROR, data, msg)
        }

        fun <T> showLoading(data: T?): Resource<T> {
            return Resource(Status.SHOWLOADING, data, null)
        }

        fun <T> hideLoading(data: T?): Resource<T> {
            return Resource(Status.HIDELOADING, data, null)
        }

        fun <T> empty(msg: String, data: T?): Resource<T> {
            return Resource(Status.EMPTY, data, msg)
        }
    }
}