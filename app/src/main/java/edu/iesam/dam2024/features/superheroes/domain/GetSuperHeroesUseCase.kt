package edu.iesam.dam2024.features.superheroes.domain

class GetSuperHeroesUseCase(private val repository: SuperHeroRepository) {
    operator fun invoke(): List<Models.SuperHero> {
        return repository.getSuperHeroes()
    }
    fun getSuperHeroById(id: Int): Models.SuperHero? {
        return repository.getSuperHeroById(id)
    }
}