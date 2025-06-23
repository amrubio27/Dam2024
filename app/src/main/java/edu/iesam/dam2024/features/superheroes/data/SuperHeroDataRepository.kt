package edu.iesam.dam2024.features.superheroes.data

import edu.iesam.dam2024.features.superheroes.data.local.SuperHeroXmlLocalDataSource
import edu.iesam.dam2024.features.superheroes.data.remote.SuperHeroRemoteDataSource
import edu.iesam.dam2024.features.superheroes.domain.SuperHero
import edu.iesam.dam2024.features.superheroes.domain.SuperHeroRepository
import org.koin.core.annotation.Single

@Single
class SuperHeroDataRepository(
    private val local: SuperHeroXmlLocalDataSource,
    private val remote: SuperHeroRemoteDataSource
) :
    SuperHeroRepository {

    private val TTL: Long = 600000

    override suspend fun getSuperHeroes(): Result<List<SuperHero>> {
        val superHeroesFromLocal = local.findAll()
        return if (superHeroesFromLocal.isEmpty()) {
            remote.getSuperHeroes().onSuccess { remote ->
                local.saveAll(remote)
            }
        } else {
            Result.success(superHeroesFromLocal)
        }
    }

    override suspend fun getSuperHeroById(id: String): Result<SuperHero> {
        val superHeroFromLocal = local.findById(id)
        return if (superHeroFromLocal == null) {
            remote.getSuperHeroById(id)
        } else {
            Result.success(superHeroFromLocal)
        }
    }
}

