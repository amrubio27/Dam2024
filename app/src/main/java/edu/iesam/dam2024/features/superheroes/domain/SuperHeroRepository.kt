package edu.iesam.dam2024.features.superheroes.domain

interface SuperHeroRepository {
    fun getSuperHeroes(): List<SuperHero>
    fun getSuperHeroById(id: Int): SuperHero?
}