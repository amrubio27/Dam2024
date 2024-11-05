package edu.iesam.dam2024.features.superheroes.data.remote

import edu.iesam.dam2024.app.api.ApiClient
import edu.iesam.dam2024.features.superheroes.domain.SuperHero
import org.koin.core.annotation.Single

@Single
class SuperHeroRemoteDataSource {
    private val apiClient = ApiClient()

    suspend fun getSuperHeroes(): List<SuperHero> {
        val response = apiClient.superHeroApiService.getSuperHeroes()
        return response.body() ?: emptyList()
    }

    suspend fun getSuperHeroById(id: String): SuperHero? {
        val response = apiClient.superHeroApiService.getHeroById(id)
        return response?.body()
    }
}