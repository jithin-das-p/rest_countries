package com.jdp.countries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.jdp.countries.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(root)
        }
        (supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment).apply {
            binding.toolbar.setupWithNavController(
                navController,
                AppBarConfiguration.Builder(hashSetOf(R.id.mainMenuFragment)).build()
            )
        }
    }
}