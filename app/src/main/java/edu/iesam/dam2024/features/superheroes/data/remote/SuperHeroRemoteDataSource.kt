package edu.iesam.dam2024.features.superheroes.data.remote

import edu.iesam.dam2024.features.superheroes.di.SuperHeroModule
import edu.iesam.dam2024.features.superheroes.domain.SuperHero
import org.koin.core.annotation.Single
import retrofit2.Retrofit

@Single
class SuperHeroRemoteDataSource(retrofit: Retrofit) {

    /*
    class SuperHeroRemoteDataSource {
    private val apiClient = SuperHeroModule().provideSuperHeroService(retrofit = ApiClient.provideRetrofit())
    */

    private val apiClient =
        SuperHeroModule().provideSuperHeroService(retrofit)

    suspend fun getSuperHeroes(): List<SuperHero> {
        val response = apiClient.getSuperHeroes()
        /**
         * IF I WANT TO USE THE API MODEL AND CONVERT IT TO DOMAIN MODEL:
         * val response: Response<List<SuperHeroApiModel>> = apiClient.getSuperHeroes()
         * ... make changes in response client ...
         * return response.body()?.map { it.toModel() } ?: emptyList()
         */
        return response.body() ?: emptyList()
    }

    suspend fun getSuperHeroById(id: String): SuperHero? {
        val response = apiClient.getHeroById(id)
        return response?.body()
    }
}