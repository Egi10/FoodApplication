package com.example.foodapplication.di

import com.example.foodapplication.repository.MainRepository
import com.example.foodapplication.repository.MainRepositoryImpl
import io.reactivex.disposables.CompositeDisposable
import org.koin.dsl.module

fun repositoryModule() = module {
    single<MainRepository> {
        MainRepositoryImpl(
            get()
        )
    }

    factory {
        CompositeDisposable()
    }
}