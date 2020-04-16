package com.example.foodapplication.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodapplication.network.handling.Resource
import com.example.foodapplication.network.model.Response
import com.example.foodapplication.repository.MainRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {
    private val _response = MutableLiveData<Resource<Response>>()
    val response: LiveData<Resource<Response>> get() = _response

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> get() = _loading

    init {
        getCategory()
    }

    private fun getCategory() {
        mainRepository.getCategories()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                _loading.value = true
            }
            .doFinally {
                _loading.value = false
            }
            .subscribeBy(
                onSuccess = {
                    _response.postValue(Resource.success(it))
                },

                onError = {
                    _response.postValue(Resource.error(it.message.toString(), null))
                }
            )
    }
}