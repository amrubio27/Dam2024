package edu.iesam.dam2024.features.superheroes.presentation

import androidx.lifecycle.ViewModel
import edu.iesam.dam2024.features.superheroes.domain.GetSuperHeroUseCase
import edu.iesam.dam2024.features.superheroes.domain.SuperHero

class SuperHeroDetailViewModel(
    private val getSuperHeroUseCase: GetSuperHeroUseCase
) : ViewModel() {

    suspend fun fetchSuperHero(id: String): SuperHero? {
        return getSuperHeroUseCase.invoke(id)
    }
}

