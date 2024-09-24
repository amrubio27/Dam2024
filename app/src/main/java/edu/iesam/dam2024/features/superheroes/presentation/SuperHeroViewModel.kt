package edu.iesam.dam2024.features.superheroes.presentation

import androidx.lifecycle.ViewModel
import edu.iesam.dam2024.features.superheroes.domain.GetSuperHeroUseCase
import edu.iesam.dam2024.features.superheroes.domain.GetSuperHeroesUseCase
import edu.iesam.dam2024.features.superheroes.domain.SuperHero

class SuperHeroViewModel(
    private val getSuperHeroesUseCase: GetSuperHeroesUseCase,
    private val getSuperHeroUseCase: GetSuperHeroUseCase
    ) : ViewModel() {

    fun fetchSuperHeroes(): List<SuperHero> {
        return getSuperHeroesUseCase.invoke()

    }

    fun fetchSuperHeroById(id: Int): SuperHero? {
        return getSuperHeroUseCase.invoke(id)
    }
}