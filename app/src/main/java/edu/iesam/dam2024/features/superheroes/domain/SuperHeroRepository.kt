package edu.iesam.dam2024.features.superheroes.domain

interface SuperHeroRepository {
    suspend fun getSuperHeroes(): Result<List<SuperHero>>
    suspend fun getSuperHeroById(id: String): Result<SuperHero?>
}