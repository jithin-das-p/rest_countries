package com.jdp.countries

import android.app.Application
import com.jdp.countries.remote.networkModule
import com.jdp.countries.repository.countriesModule
import com.jdp.countries.viewModel.CountriesListViewModel
import com.jdp.countries.viewModel.SelectedCountryViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class CountriesApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(
                module {
                    factory { CountriesListViewModel(get()) }
                    factory { SelectedCountryViewModel() }
                },
                networkModule,
                countriesModule
            )
        }
    }
}