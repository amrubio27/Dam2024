package edu.iesam.dam2024.features.superheroes.data.remote

import edu.iesam.dam2024.features.superheroes.domain.SuperHero
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface SuperHeroService {

    @GET("all.json")
    suspend fun getSuperHeroes(): Response<List<SuperHero>>

    @GET("id/{id}.json")
    suspend fun getHeroById(@Path("id") id: String): Response<SuperHero>

}