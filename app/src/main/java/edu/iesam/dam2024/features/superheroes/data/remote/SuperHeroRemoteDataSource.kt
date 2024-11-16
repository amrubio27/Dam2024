package edu.iesam.dam2024.features.superheroes.data.remote

import edu.iesam.dam2024.app.data.remote.apiCall
import edu.iesam.dam2024.features.superheroes.domain.SuperHero
import org.koin.core.annotation.Single

@Single
class SuperHeroRemoteDataSource(private val apiClient: SuperHeroService) {

    //private val apiClient = SuperHeroModule().provideSuperHeroService(retrofit = ApiClient.provideRetrofit())

    /*private val apiClient = SuperHeroModule().provideSuperHeroService(
        retrofit = RemoteModule().provideRetrofit(
            okHttpClient = RemoteModule().provideOkHttpClient(
                loggingInterceptor = RemoteModule().provideLogginInterceptor()
            )
        )
    )*/


    //Version sin apiCall
    /*suspend fun getSuperHeroes(): List<SuperHero> {
        val response = apiClient.getSuperHeroes()
        */
    /**
         * IF I WANT TO USE THE API MODEL AND CONVERT IT TO DOMAIN MODEL:
         * val response: Response<List<SuperHeroApiModel>> = apiClient.getSuperHeroes()
         * ... make changes in response client ...
         * return response.body()?.map { it.toModel() } ?: emptyList()
     *//*
        return response.body() ?: emptyList()
    }

    suspend fun getSuperHeroById(id: String): SuperHero? {
        val response = apiClient.getHeroById(id)
        return response?.body()
    }*/

    //Version con apiCall

    suspend fun getSuperHeroes(): Result<List<SuperHero>> {
        return apiCall(apiClient.getSuperHeroes())
    }

    suspend fun getSuperHeroById(id: String): Result<SuperHero> {
        return apiCall(apiClient.getHeroById(id))
    }

}