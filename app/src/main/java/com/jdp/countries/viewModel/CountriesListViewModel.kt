package com.jdp.countries.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.jdp.countries.data.CountryItem
import com.jdp.countries.repository.CountriesRepo

class CountriesListViewModel(
    private val repo: CountriesRepo
) : ViewModel() {

    val allCountries: LiveData<List<CountryItem>> = liveData {
        emit(repo.getAllCountries())
    }
}