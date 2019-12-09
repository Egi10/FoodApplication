package com.example.foodapplication.di

import com.example.foodapplication.ui.MainRepository
import com.example.foodapplication.ui.MainRepositoryImpl
import org.koin.dsl.module.module

val repositoryModule = module {
    single<MainRepository> { MainRepositoryImpl(get()) }
}