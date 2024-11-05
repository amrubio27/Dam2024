package edu.iesam.dam2024.features.superheroes.data.remote

import edu.iesam.dam2024.app.api.ApiClient
import edu.iesam.dam2024.features.superheroes.di.SuperHeroModule
import edu.iesam.dam2024.features.superheroes.domain.SuperHero
import org.koin.core.annotation.Single

@Single
class SuperHeroRemoteDataSource {

    private val apiClient =
        SuperHeroModule().provideSuperHeroService(retrofit = ApiClient.provideRetrofit())

    suspend fun getSuperHeroes(): List<SuperHero> {
        val response = apiClient.getSuperHeroes()
        return response.body() ?: emptyList()
    }

    suspend fun getSuperHeroById(id: String): SuperHero? {
        val response = apiClient.getHeroById(id)
        return response?.body()
    }
}