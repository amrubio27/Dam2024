package edu.iesam.dam2024.features.superheroes.domain

class GetSuperHeroUseCase(private val repository: SuperHeroRepository) {
    suspend fun invoke(id: String): SuperHero? {
        return repository.getSuperHeroById(id)
    }
}