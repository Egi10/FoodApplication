package com.example.foodapplication.di

import com.example.foodapplication.repository.MainRepository
import com.example.foodapplication.repository.MainRepositoryImpl
import org.koin.dsl.module

fun repositoryModule() = module {
    single<MainRepository> {
        MainRepositoryImpl(
            get()
        )
    }
}