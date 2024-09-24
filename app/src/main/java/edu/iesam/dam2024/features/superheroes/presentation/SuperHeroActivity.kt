package edu.iesam.dam2024.features.superheroes.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import edu.iesam.dam2024.R
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val superHeroFactory = SuperHeroFactory()
    private val viewModel = superHeroFactory.buildViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleScope.launch {
            val superHeroes = viewModel.fetchSuperHeroes()
            Log.d("@Dev", superHeroes.toString())
            Log.d("@Dev", viewModel.fetchSuperHeroById(2).toString())
        }
    }

}