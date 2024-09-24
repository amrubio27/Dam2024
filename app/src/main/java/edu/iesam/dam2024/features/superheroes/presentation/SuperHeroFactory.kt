package edu.iesam.dam2024.features.superheroes.presentation

import edu.iesam.dam2024.features.superheroes.data.SuperHeroDataRepository
import edu.iesam.dam2024.features.superheroes.data.remote.SuperHeroMockDataSource
import edu.iesam.dam2024.features.superheroes.domain.GetSuperHeroUseCase
import edu.iesam.dam2024.features.superheroes.domain.GetSuperHeroesUseCase

class SuperHeroFactory {
    fun buildViewModel(): SuperHeroViewModel {
        return SuperHeroViewModel(
            GetSuperHeroesUseCase(
                SuperHeroDataRepository(
                    SuperHeroMockDataSource()
                )
            ),
            GetSuperHeroUseCase(
                SuperHeroDataRepository(
                    SuperHeroMockDataSource()
                )
            )
        )
    }
}