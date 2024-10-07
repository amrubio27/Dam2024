package edu.iesam.dam2024.app.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/*
class ApiClient {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://akabab.github.io/superhero-api/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService: ApiService = retrofit.create(ApiService::class.java)

}*/

class ApiClient {
    private val client = OkHttpClient.Builder()
        .addInterceptor(
            BasicAuthInterceptor(
                "chema",
                "769c36fd04d4af42665ec8f3d2271daccca629a14e8d8d94"
            )
        )
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://meceiot.usal.es/g/login/")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService: ApiService = retrofit.create(ApiService::class.java)
}
