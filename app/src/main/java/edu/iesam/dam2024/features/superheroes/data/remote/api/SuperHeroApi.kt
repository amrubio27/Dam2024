package edu.iesam.dam2024.features.superheroes.data.remote.api

object SuperHeroApi {
    val service: SuperHeroApiService by lazy {
        retrofit.create(SuperHeroApiService::class.java)
    }
}