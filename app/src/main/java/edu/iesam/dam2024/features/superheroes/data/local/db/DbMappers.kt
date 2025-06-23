package edu.iesam.dam2024.features.superheroes.data.local.db

import edu.iesam.dam2024.features.superheroes.domain.SuperHero
import java.util.Date

/*
* Para convertir un objeto de dominio a un objeto de entidad y viceversa
 */
fun SuperHero.toEntity(): SuperHeroEntity =
    SuperHeroEntity(
        this.id.toString(),
        this.name,
        this.slug,
        this.powerstats,
        this.appearance,
        this.biography,
        this.work,
        this.connections,
        this.images,
        Date().time
    )//Se añade la fecha actual en milisegundos

fun SuperHeroEntity.toDomain(): SuperHero =
    SuperHero(
        this.id.toInt(),
        this.name,
        this.slug,
        this.powerstats,
        this.appearance,
        this.biography,
        this.work,
        this.connections,
        this.images
    )