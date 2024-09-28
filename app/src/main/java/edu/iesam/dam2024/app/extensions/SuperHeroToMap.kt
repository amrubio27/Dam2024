package edu.iesam.dam2024.app.extensions

import edu.iesam.dam2024.features.superheroes.domain.SuperHero

fun SuperHero.toMap2(): Map<String, String> {
    return mapOf(
        "id" to id.toString(),
        "name" to name,
        "slug" to slug,
        "intelligence" to powerstats.intelligence.toString(),
        "strength" to powerstats.strength.toString(),
        "speed" to powerstats.speed.toString(),
        "durability" to powerstats.durability.toString(),
        "power" to powerstats.power.toString(),
        "combat" to powerstats.combat.toString(),
        "gender" to appearance.gender,
        "race" to (appearance.race ?: ""),
        "height" to (appearance.height?.joinToString(",") ?: ""),
        "weight" to appearance.weight.joinToString(","),
        "eyeColor" to appearance.eyeColor,
        "hairColor" to appearance.hairColor,
        "fullName" to biography.fullName,
        "alterEgos" to biography.alterEgos,
        "aliases" to biography.aliases.joinToString(","),
        "placeOfBirth" to biography.placeOfBirth,
        "firstAppearance" to biography.firstAppearance,
        "publisher" to (biography.publisher ?: ""),
        "alignment" to biography.alignment,
        "occupation" to work.occupation,
        "base" to work.base,
        "groupAffiliation" to connections.groupAffiliation,
        "relatives" to connections.relatives,
        "imageXs" to images.xs,
        "imageSm" to images.sm,
        "imageMd" to images.md,
        "imageLg" to images.lg
    )
}