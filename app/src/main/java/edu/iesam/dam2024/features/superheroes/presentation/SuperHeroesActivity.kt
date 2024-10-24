package edu.iesam.dam2024.features.superheroes.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import edu.iesam.dam2024.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_super_heroes)

        setupView()
    }

    private fun setupView() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        findViewById<BottomNavigationView>(R.id.main_menu).setupWithNavController(navController)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.listSuperHeroes -> {
                }

                R.id.fragment_beta -> {
                }

                R.id.superhero_detail_fragment -> {
                    findViewById<BottomNavigationView>(R.id.main_menu).visibility =
                        BottomNavigationView.GONE
                }

                else -> {
                    findViewById<BottomNavigationView>(R.id.main_menu).visibility =
                        BottomNavigationView.VISIBLE
                }
            }
        }


    }
}