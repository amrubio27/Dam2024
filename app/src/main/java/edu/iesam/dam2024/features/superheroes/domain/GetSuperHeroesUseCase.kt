package edu.iesam.dam2024.features.superheroes.domain

class GetSuperHeroesUseCase(private val repository: SuperHeroRepository) {
    suspend fun invoke(): List<SuperHero> {
        return repository.getSuperHeroes()
    }
}