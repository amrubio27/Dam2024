package edu.iesam.dam2024.features.superheroes.data.local

import android.content.Context
import com.google.gson.Gson
import edu.iesam.dam2024.R
import edu.iesam.dam2024.features.superheroes.domain.SuperHero

class SuperHeroXmlLocalDataSource(context: Context) {
    private val sharedPref = context.getSharedPreferences(
        context.getString(R.string.app_name), Context.MODE_PRIVATE
    )

    private val gson = Gson()

    fun save(superHero: SuperHero) {
        sharedPref.edit().putString(superHero.id.toString(), gson.toJson(superHero)).apply()
    }

    fun saveAll(superHeroes: List<SuperHero>) {
        superHeroes.forEach { superHero ->
            save(superHero)
        }
    }

    fun findById(id: String): SuperHero? {
        val json = sharedPref.getString(id, null)
        return json?.let {
            gson.fromJson(json, SuperHero::class.java)
        }
    }

    fun findAll(): List<SuperHero> {
        val superHeroesList = mutableListOf<SuperHero>()
        val mapSuperHeroes = sharedPref.all.toMap()
        mapSuperHeroes.values.forEach { jsonSuperHero ->
            val superHero = gson.fromJson(jsonSuperHero as String, SuperHero::class.java)
            superHeroesList.add(superHero)
        }
        return superHeroesList

        /*return sharedPref.all.toMap().values.mapNotNull { jsonSuperHero ->
            gson.fromJson(jsonSuperHero as String, SuperHero::class.java)
        }*/
    }

    fun delete() {
        sharedPref.edit().clear().apply()
    }


}