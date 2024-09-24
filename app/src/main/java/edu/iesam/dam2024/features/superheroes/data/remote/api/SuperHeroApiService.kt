package edu.iesam.dam2024.features.superheroes.data.remote.api

import edu.iesam.dam2024.features.superheroes.domain.Models
import retrofit2.http.GET

interface SuperHeroApiService {
    @GET("all.json")
    suspend fun getSuperHeroes(): List<Models.SuperHero>
}