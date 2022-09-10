package com.jdp.countries.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.jdp.countries.R
import com.jdp.countries.databinding.FragmentCountriesListBinding
import com.jdp.countries.viewModel.CountriesListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.jdp.countries.adapter.CountryListAdapter

class CountriesListFragment : Fragment(R.layout.fragment_countries_list) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel: CountriesListViewModel by viewModel()
        CountryListAdapter { binding, countryItem ->
            val action =
                CountriesListFragmentDirections.actionCountriesListToDetailView(countryItem)
            findNavController()
                .navigate(action, FragmentNavigatorExtras(binding.flag to "transition"))
        }.let { listAdapter ->
            viewModel.allCountries.observe(viewLifecycleOwner) { list ->
                listAdapter.setItems(list)
            }
            FragmentCountriesListBinding.bind(view).apply {
                listRecyclerView.apply {
                    adapter = listAdapter
                }
            }
        }
    }
}
