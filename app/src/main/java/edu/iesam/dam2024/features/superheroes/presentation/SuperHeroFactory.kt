package edu.iesam.dam2024.features.superheroes.presentation

import android.content.Context
import edu.iesam.dam2024.features.superheroes.data.SuperHeroDataRepository
import edu.iesam.dam2024.features.superheroes.data.local.SuperHeroXmlLocalDataSource
import edu.iesam.dam2024.features.superheroes.data.remote.SuperHeroRemoteDataSource
import edu.iesam.dam2024.features.superheroes.domain.GetSuperHeroUseCase
import edu.iesam.dam2024.features.superheroes.domain.GetSuperHeroesUseCase

class SuperHeroFactory(context: Context) {
    private val superHeroesRemote = SuperHeroRemoteDataSource()
    private val superHeroesLocal = SuperHeroXmlLocalDataSource(context)
    private val superHeroDataRepository =
        SuperHeroDataRepository(superHeroesLocal, superHeroesRemote)
    private val getSuperHeroUseCase = GetSuperHeroUseCase(superHeroDataRepository)
    private val getSuperHeroesUseCase = GetSuperHeroesUseCase(superHeroDataRepository)

    fun buildViewModel(): SuperHeroesViewModel {
        return SuperHeroesViewModel(
            getSuperHeroesUseCase
        )
    }

    fun buildDetailViewModel(): SuperHeroDetailViewModel {
        return SuperHeroDetailViewModel(
            getSuperHeroUseCase
        )
    }
}