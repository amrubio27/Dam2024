package edu.iesam.dam2024.features.superheroes.presentation

import androidx.lifecycle.ViewModel
import edu.iesam.dam2024.features.superheroes.domain.GetSuperHeroesUseCase
import edu.iesam.dam2024.features.superheroes.domain.Models

class SuperHeroViewModel(private val getSuperHeroesUseCase: GetSuperHeroesUseCase) : ViewModel() {

    fun fetchSuperHeroes(): List<Models.SuperHero> {
        return getSuperHeroesUseCase.invoke()

    }
}