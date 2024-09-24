package edu.iesam.dam2024.features.superheroes.data.remote

import edu.iesam.dam2024.features.superheroes.domain.Models

class SuperHeroMockDataSource {

    private val superHeroes: List<Models.SuperHero> = listOf(
        Models.SuperHero(1, "Superman", "https://"),
        Models.SuperHero(2, "Batman", "https://"),
        Models.SuperHero(3, "Wonder", "https://")
    )

    fun getSuperHeroes(): List<Models.SuperHero> {
        return superHeroes
    }

    fun getSuperHeroById(id: Int): Models.SuperHero? {
        return superHeroes.find { it.id == id }
    }
}
