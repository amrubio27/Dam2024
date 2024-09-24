package edu.iesam.dam2024.features.superheroes.data

import edu.iesam.dam2024.features.superheroes.data.remote.SuperHeroMockDataSource
import edu.iesam.dam2024.features.superheroes.domain.Models
import edu.iesam.dam2024.features.superheroes.domain.SuperHeroRepository

class SuperHeroDataRepository(private val mockRemoteDataSource: SuperHeroMockDataSource) :
    SuperHeroRepository {
    override fun getSuperHeroes(): List<Models.SuperHero> {
        return mockRemoteDataSource.getSuperHeroes()
    }

    override fun getSuperHeroById(id: Int): Models.SuperHero? {
        return mockRemoteDataSource.getSuperHeroById(id)
    }
}

