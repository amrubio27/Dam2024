package edu.iesam.dam2024.features.superheroes.data

import edu.iesam.dam2024.features.superheroes.data.remote.SuperHeroRemoteDataSource
import edu.iesam.dam2024.features.superheroes.domain.SuperHero
import edu.iesam.dam2024.features.superheroes.domain.SuperHeroRepository

class SuperHeroDataRepository(private val remoteDataSource: SuperHeroRemoteDataSource) :
    SuperHeroRepository {
    override suspend fun getSuperHeroes(): List<SuperHero> {
        return remoteDataSource.getSuperHeroes()
    }

    override suspend fun getSuperHeroById(id: Int): SuperHero? {
        return remoteDataSource.getSuperHeroById(id)
    }
}

