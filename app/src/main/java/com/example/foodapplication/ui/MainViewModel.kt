package com.example.foodapplication.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodapplication.network.handling.Resource
import com.example.foodapplication.network.model.Response
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {
    fun getCategory(): LiveData<Resource<Response>> {
        val list = MutableLiveData<Resource<Response>>()

        mainRepository.getCategories()
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .doOnSubscribe {
                list.value = Resource.showLoading(null)
            }
            .doFinally {
//                list.value = Resource.hideLoading(null)
            }
            .subscribeBy(
                onSuccess = {
                    list.postValue(Resource.success(it))
                },

                onError = {
                    list.postValue(Resource.error(it.message.toString(), null))
                }
            )

        return list
    }
}