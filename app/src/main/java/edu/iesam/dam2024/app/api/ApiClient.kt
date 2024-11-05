package edu.iesam.dam2024.app.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://akabab.github.io/superhero-api/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val superHeroApiService: SuperHeroApiService = retrofit.create(SuperHeroApiService::class.java)

}
