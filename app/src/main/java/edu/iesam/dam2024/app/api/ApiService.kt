package edu.iesam.dam2024.app.api

import edu.iesam.dam2024.features.superheroes.domain.SuperHero
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("all.json")
    suspend fun getSuperHeroes(): Response<List<SuperHero>>

    @GET("id/{id}.json")
    suspend fun getHeroById(id: Int): Response<SuperHero>
}