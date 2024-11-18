package edu.iesam.dam2024.features.superheroes.data.local.db

import edu.iesam.dam2024.features.superheroes.domain.SuperHero

/*
* Para convertir un objeto de dominio a un objeto de entidad y viceversa
 */
fun SuperHero.toEntity(): SuperHeroEntity =
    SuperHeroEntity(this.id, this.name, this.urlImage, this.power)

fun SuperHeroEntity.toDomain(): SuperHero =
    SuperHero(this.id, this.name, this.urlImage, this.power)