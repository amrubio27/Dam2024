package edu.iesam.dam2024.features.superheroes.domain

interface SuperHeroRepository {
    suspend fun getSuperHeroes(): List<SuperHero>
    suspend fun getSuperHeroById(id: String): SuperHero?
}