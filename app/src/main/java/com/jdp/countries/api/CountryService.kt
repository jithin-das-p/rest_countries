package com.jdp.countries.api

import com.jdp.countries.data.CountryItem
import retrofit2.http.GET

interface CountryService {
    @GET("all")
    suspend fun getAllCountries(): List<CountryItem>
}