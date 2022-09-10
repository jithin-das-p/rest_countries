package com.jdp.countries.repository

import com.jdp.countries.api.CountryService
import com.jdp.countries.data.CountryItem
import org.koin.dsl.module
import timber.log.Timber

val countriesModule = module {
    factory { CountriesRepo(get()) }
}

class CountriesRepo(private val countryService: CountryService) {
    suspend fun getAllCountries(): List<CountryItem> {
        var list: List<CountryItem> = arrayListOf()
        try {
            list = countryService.getAllCountries()
        } catch (throwable: Throwable) {
            throwable.printStackTrace()
        } finally {
            Timber.d("Something went wrong!!")
        }
        return list
    }
}