package com.example.foodapplication.di

import com.example.foodapplication.ui.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun viewModelModule() = module {
    viewModel { MainViewModel(get(), get()) }
}