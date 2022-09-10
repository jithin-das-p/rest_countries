package com.jdp.countries.viewModel

import android.content.Context
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.jdp.countries.R
import com.jdp.countries.data.CountryItem
import com.jdp.countries.data.DetailsString

class SelectedCountryViewModel : ViewModel() {
    val countryItem = ObservableField<CountryItem>()
    private val detailsText = ObservableField<DetailsString>()

    fun getDetailedInfo(): String {
        return detailsText.get()!!.text!!
    }

    fun setDetailedInfo(context: Context, country: CountryItem) {
        countryItem.set(country)
        val stringBuilder = StringBuilder()
        stringBuilder.apply {
            append(
                String.format(
                    context.resources.getString(R.string.country_name_info),
                    country.name?.official,
                    country.name?.common
                )
            )
            append(
                String.format(
                    context.resources.getString(R.string.country_region_info),
                    country.region
                )
            )
            append(
                String.format(
                    context.resources.getString(R.string.country_sub_region_info),
                    country.subregion
                )
            )
            append(
                String.format(
                    context.resources.getString(R.string.country_population_info),
                    country.name?.common,
                    "%,d".format(country.population)
                )
            )
            append(
                String.format(
                    context.resources.getString(R.string.country_capital_info),
                    country.capital?.get(0)
                )
            )
            append(
                String.format(
                    context.resources.getString(R.string.country_language_info),
                    country.languages.values.toString().replace("[", "")
                        .replace("]", "")
                        .trim()
                )
            )
            append(
                String.format(
                    context.resources.getString(R.string.country_timezone_info),
                    country.timezones.toString().replace("[", "")
                        .replace("]", "")
                        .trim()
                )
            )
            append(
                String.format(
                    context.resources.getString(R.string.country_start_day_info),
                    country.startOfWeek?.uppercase()
                )
            )
        }
        detailsText.set(DetailsString(stringBuilder.toString()))
    }
}