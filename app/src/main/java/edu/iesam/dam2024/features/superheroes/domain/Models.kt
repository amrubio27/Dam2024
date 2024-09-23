package edu.iesam.dam2024.features.superheroes.domain

class Models {
    data class SuperHero(
        val id: Int,
        val name: String,
        val images: String
    )

    data class Biography(
        val fullName: String,
    )

    data class Work(
        val occupation: String,
    )
}
