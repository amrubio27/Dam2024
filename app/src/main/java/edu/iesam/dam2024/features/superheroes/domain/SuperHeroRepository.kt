package edu.iesam.dam2024.features.superheroes.domain

interface SuperHeroRepository {
    fun getSuperHeroes(): List<Models.SuperHero>
}