package com.jdp.countries.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.jdp.countries.R
import com.jdp.countries.databinding.FragmentMainMenuBinding

class MainMenuFragment : Fragment(R.layout.fragment_main_menu) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        FragmentMainMenuBinding.bind(view).apply {
            with(showList) {
                setOnClickListener {
                    findNavController().navigate(R.id.action_mainMenuButton_to_countriesList)
                }
            }
            with(worldImage) {
                setOnClickListener {
                    findNavController().navigate(R.id.action_mainMenuButton_to_countriesList)
                }
            }
        }
    }
}