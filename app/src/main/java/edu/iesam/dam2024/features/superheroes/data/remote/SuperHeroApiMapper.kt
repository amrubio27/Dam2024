package edu.iesam.dam2024.features.superheroes.data.remote

import edu.iesam.dam2024.features.superheroes.domain.Appearance
import edu.iesam.dam2024.features.superheroes.domain.Biography
import edu.iesam.dam2024.features.superheroes.domain.Connections
import edu.iesam.dam2024.features.superheroes.domain.Images
import edu.iesam.dam2024.features.superheroes.domain.PowerStats
import edu.iesam.dam2024.features.superheroes.domain.SuperHero
import edu.iesam.dam2024.features.superheroes.domain.Work


fun SuperHeroApiModel.toModel(): SuperHero {
    return SuperHero(
        id = id,
        name = name,
        slug = slug,
        powerstats = powerstats.toModel(),
        appearance = appearance.toModel(),
        biography = biography.toModel(),
        work = work.toModel(),
        connections = connections.toModel(),
        images = images.toModel()
    )
}

fun PowerStatsApiModel.toModel(): PowerStats {
    return PowerStats(
        intelligence = intelligence,
        strength = strength,
        speed = speed,
        durability = durability,
        power = power,
        combat = combat
    )
}

fun AppearanceApiModel.toModel(): Appearance {
    return Appearance(
        gender = gender,
        race = race,
        height = height,
        weight = weight,
        eyeColor = eyeColor,
        hairColor = hairColor
    )
}

fun BiographyApimodel.toModel(): Biography {
    return Biography(
        fullName = fullName,
        alterEgos = alterEgos,
        aliases = aliases,
        placeOfBirth = placeOfBirth,
        firstAppearance = firstAppearance,
        publisher = publisher,
        alignment = alignment
    )
}

fun WorkApiModel.toModel(): Work {
    return Work(
        occupation = occupation,
        base = base
    )
}

fun ConnectionsApiModel.toModel(): Connections {
    return Connections(
        groupAffiliation = groupAffiliation,
        relatives = relatives
    )
}

fun ImagesApiModel.toModel(): Images {
    return Images(
        xs = xs,
        sm = sm,
        md = md,
        lg = lg
    )
}

