package com.jdp.countries.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.jdp.countries.R
import com.jdp.countries.databinding.FragmentDetailsViewBinding
import com.jdp.countries.viewModel.SelectedCountryViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailsViewFragment : Fragment(R.layout.fragment_details_view) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        FragmentDetailsViewBinding.bind(view).apply {
            val args: DetailsViewFragmentArgs by navArgs()
            val selectedCountryViewModel: SelectedCountryViewModel by viewModel()
            selectedCountryViewModel.setDetailedInfo(requireContext(), args.countryItem)
            viewModel = selectedCountryViewModel
            executePendingBindings()
        }
    }
}
