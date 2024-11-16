package edu.iesam.dam2024.features.superheroes.domain

import org.koin.core.annotation.Single

@Single
class GetSuperHeroesUseCase(private val repository: SuperHeroRepository) {
    suspend fun invoke(): Result<List<SuperHero>> {
        return repository.getSuperHeroes()
    }
}