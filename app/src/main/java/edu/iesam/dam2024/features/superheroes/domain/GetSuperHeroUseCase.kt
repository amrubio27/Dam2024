package edu.iesam.dam2024.features.superheroes.domain

class GetSuperHeroUseCase(private val repository: SuperHeroRepository) {
    operator fun invoke(id: Int): SuperHero? {
        return repository.getSuperHeroById(id)
    }
}