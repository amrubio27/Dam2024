package edu.iesam.dam2024.features.superheroes.data.local

import android.content.Context
import com.google.gson.Gson
import edu.iesam.dam2024.R
import edu.iesam.dam2024.features.superheroes.domain.SuperHero
import org.koin.core.annotation.Single

@Single
class SuperHeroXmlLocalDataSource(context: Context) {
    private val sharedPref = context.getSharedPreferences(
        context.getString(R.string.app_name), Context.MODE_PRIVATE
    )

    private val gson = Gson()

    fun save(superHero: SuperHero) {
        sharedPref.edit().putString(superHero.id.toString(), gson.toJson(superHero)).apply()
    }

    fun saveAll(superHeroes: List<SuperHero>) {
        val editor = sharedPref.edit()
        superHeroes.forEach { superHero ->
            editor.putString(superHero.id.toString(), gson.toJson(superHero))
        }
        editor.apply()
    }

    fun findById(superHeroId: String): SuperHero? {
        return sharedPref.getString(superHeroId, null)?.let { jsonSuperHero ->
            gson.fromJson(jsonSuperHero, SuperHero::class.java)
        }
    }

    fun findAll(): List<SuperHero> {
        return sharedPref.all.toMap().values.mapNotNull { jsonSuperHero ->
            gson.fromJson(jsonSuperHero as String, SuperHero::class.java)
        }
    }

    fun delete() {
        sharedPref.edit().clear().apply()
    }


}