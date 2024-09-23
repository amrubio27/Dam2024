package edu.iesam.dam2024.features.superheroes.data.remote

import edu.iesam.dam2024.features.superheroes.domain.Models

class SuperHeroMockDataSource {
    fun getSuperHeroes(): List<Models.SuperHero> {
        return listOf(
            Models.SuperHero(1, "Superman", "https://"),
            Models.SuperHero(2, "Batman", "https://"),
            Models.SuperHero(3, "Wonder", "https://")
        )

    }
}
