package edu.iesam.dam2024.features.superheroes.data.remote

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

    /*suspend fun getSuperHeroes(): Result<List<SuperHero>> {
        val response = apiClient.getSuperHeroes()
        return if (response.isSuccessful) {
            Result.success(response.body()!!)
        } else {
            //TODO: Handle error
            Result.failure(ErrorApp.ServerErrorApp)
        }
    }*/

    /*suspend fun getSuperHeroById(id: String): Result<SuperHero> {
        val response = apiClient.getHeroById(id)
        return if (response.isSuccessful ?: ) {
            Result.success(response.body()!!)
        } else {
            //TODO: Handle error
            Result.failure(ErrorApp.ServerErrorApp)
        }
    }*/
}