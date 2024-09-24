package edu.iesam.dam2024.features.superheroes.data.remote

import edu.iesam.dam2024.app.api.ApiClient
import edu.iesam.dam2024.features.superheroes.domain.SuperHero

class SuperHeroRemoteDataSource {
    private val apiClient = ApiClient()

    suspend fun getSuperHeroes(): List<SuperHero> {
        val response = apiClient.apiService.getSuperHeroes()
        return response.body() ?: emptyList()
    }

    suspend fun getSuperHeroById(id: Int): SuperHero? {
        val response = apiClient.apiService.getHeroById(id)
        return response.body()
    }
}