package com.example.foodapplication.di

import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module

/**
 * Created By Julsapargi Nursam 4/16/20
 */

class Modules {
    private val modules: List<Module> = listOf(
        networkModule(),
        repositoryModule(),
        viewModelModule()
    )

    init {
        loadKoinModules(
            modules
        )
    }
}