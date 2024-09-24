package edu.iesam.dam2024.features.superheroes.presentation

import edu.iesam.dam2024.features.superheroes.data.SuperHeroDataRepository
import edu.iesam.dam2024.features.superheroes.data.remote.SuperHeroRemoteDataSource
import edu.iesam.dam2024.features.superheroes.domain.GetSuperHeroUseCase
import edu.iesam.dam2024.features.superheroes.domain.GetSuperHeroesUseCase

class SuperHeroFactory {
    private val superHeroDataRepository = SuperHeroDataRepository(SuperHeroRemoteDataSource())
    fun buildViewModel(): SuperHeroViewModel {
        return SuperHeroViewModel(
            GetSuperHeroesUseCase(
                superHeroDataRepository
            ),
            GetSuperHeroUseCase(
                superHeroDataRepository
            )
        )
    }
}