package com.example.foodapplication

import android.app.Application
import com.example.foodapplication.di.networkModule
import com.example.foodapplication.di.repositoryModule
import com.example.foodapplication.di.viewModelModule
import org.koin.android.ext.android.startKoin

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        // Start Koin
        startKoin(this, listOf(
            networkModule,
            repositoryModule,
            viewModelModule
        ))
    }
}