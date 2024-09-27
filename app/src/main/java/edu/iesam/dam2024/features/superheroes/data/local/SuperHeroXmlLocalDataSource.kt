package edu.iesam.dam2024.features.superheroes.data.local

import android.content.Context
import edu.iesam.dam2024.R
import edu.iesam.dam2024.features.superheroes.domain.Appearance
import edu.iesam.dam2024.features.superheroes.domain.Biography
import edu.iesam.dam2024.features.superheroes.domain.Connections
import edu.iesam.dam2024.features.superheroes.domain.Images
import edu.iesam.dam2024.features.superheroes.domain.PowerStats
import edu.iesam.dam2024.features.superheroes.domain.SuperHero
import edu.iesam.dam2024.features.superheroes.domain.Work

class SuperHeroXmlLocalDataSource(context: Context) {
    private val sharedPref = context.getSharedPreferences(
        context.getString(R.string.app_name), Context.MODE_PRIVATE
    )

    fun save(superHero: SuperHero) {
        sharedPref.edit().apply {
            putString("id", superHero.id.toString())
            putString("name", superHero.name)
            apply()
        }
    }

    fun find(): SuperHero {
        val id = sharedPref.getString("id", "")
        val name = sharedPref.getString("name", "")
        val superHero = SuperHero(
            id = 1,
            name = "A-Bomb",
            slug = "1-a-bomb",
            powerstats = PowerStats(
                intelligence = 38,
                strength = 100,
                speed = 17,
                durability = 80,
                power = 24,
                combat = 64
            ),
            appearance = Appearance(
                gender = "Male",
                race = "Human",
                height = listOf("6'8", "203 cm"),
                weight = listOf("980 lb", "441 kg"),
                eyeColor = "Yellow",
                hairColor = "No Hair"
            ),
            biography = Biography(
                fullName = "Richard Milhouse Jones",
                alterEgos = "No alter egos found.",
                aliases = listOf("Rick Jones"),
                placeOfBirth = "Scarsdale, Arizona",
                firstAppearance = "Hulk Vol 2 #2 (April, 2008) (as A-Bomb)",
                publisher = "Marvel Comics",
                alignment = "good"
            ),
            work = Work(
                occupation = "Musician, adventurer, author; formerly talk show host",
                base = "-"
            ),
            connections = Connections(
                groupAffiliation = "Hulk Family; Excelsior (sponsor), Avengers (honorary member); formerly partner of the Hulk, Captain America and Captain Marvel; Teen Brigade; ally of Rom",
                relatives = "Marlo Chandler-Jones (wife); Polly (aunt); Mrs. Chandler (mother-in-law); Keith Chandler, Ray Chandler, three unidentified others (brothers-in-law); unidentified father (deceased); Jackie Shorr (alleged mother; unconfirmed)"
            ),
            images = Images(
                xs = "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/xs/1-a-bomb.jpg",
                sm = "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/sm/1-a-bomb.jpg",
                md = "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/md/1-a-bomb.jpg",
                lg = "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/lg/1-a-bomb.jpg"
            )
        )
        return superHero
    }

    fun delete() {
        sharedPref.edit().clear().apply()
    }


}