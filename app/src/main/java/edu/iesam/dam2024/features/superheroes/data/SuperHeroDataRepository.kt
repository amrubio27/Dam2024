package edu.iesam.dam2024.features.superheroes.data

import edu.iesam.dam2024.features.superheroes.data.local.SuperHeroXmlLocalDataSource
import edu.iesam.dam2024.features.superheroes.data.remote.SuperHeroRemoteDataSource
import edu.iesam.dam2024.features.superheroes.domain.SuperHero
import edu.iesam.dam2024.features.superheroes.domain.SuperHeroRepository

class SuperHeroDataRepository(
    private val local: SuperHeroXmlLocalDataSource,
    private val remote: SuperHeroRemoteDataSource
) :
    SuperHeroRepository {
    override suspend fun getSuperHeroes(): List<SuperHero> {
        val superHeroesFromLocal = local.findAll()
        return if (superHeroesFromLocal.isEmpty()) {
            val superHeroesFromRemote = remote.getSuperHeroes()
            local.saveAll(superHeroesFromRemote)
            superHeroesFromRemote
        } else {
            superHeroesFromLocal
        }
    }

    override suspend fun getSuperHeroById(id: String): SuperHero? {
        val superHeroFromLocal = local.findById(id)
        return if (superHeroFromLocal == null) {
            val superHeroFromRemote = remote.getSuperHeroById(id)
            superHeroFromRemote?.let { local.save(it) }
            superHeroFromRemote
        } else {
            superHeroFromLocal
        }
    }
}

