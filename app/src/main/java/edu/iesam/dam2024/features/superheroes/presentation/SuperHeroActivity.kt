package edu.iesam.dam2024.features.superheroes.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import edu.iesam.dam2024.R

class MainActivity : AppCompatActivity() {

    private val superHeroFactory = SuperHeroFactory()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = superHeroFactory.buildViewModel()
        val superHeroesList = viewModel.fetchSuperHeroes()
        val superHero = viewModel.fetchSuperHeroById(1)


        Log.d("@Dev", superHeroesList.toString())
    }
}