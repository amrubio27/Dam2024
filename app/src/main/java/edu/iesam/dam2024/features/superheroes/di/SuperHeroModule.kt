package edu.iesam.dam2024.features.superheroes.di

import edu.iesam.dam2024.app.api.SuperHeroApiService
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single
import retrofit2.Retrofit

@Module
@ComponentScan
class SuperHeroModule {

    @Single
    fun provideSuperHeroService(retrofit: Retrofit) =
        retrofit.create(SuperHeroApiService::class.java)
}