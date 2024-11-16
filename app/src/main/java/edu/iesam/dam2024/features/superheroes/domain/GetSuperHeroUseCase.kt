package edu.iesam.dam2024.features.superheroes.domain

import org.koin.core.annotation.Single

@Single
class GetSuperHeroUseCase(private val repository: SuperHeroRepository) {
    suspend fun invoke(id: String): Result<SuperHero> {
        return repository.getSuperHeroById(id)
    }
}