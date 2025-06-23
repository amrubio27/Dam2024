package edu.iesam.dam2024.features.superheroes.data.local.db

import android.util.Log
import edu.iesam.dam2024.features.superheroes.domain.SuperHero
import org.koin.core.annotation.Single

@Single
class SuperHeroDbLocalDataSource(private val superHeroDao: SuperHeroDao) {

    //Es @Single (módulo de Koin) para que no se cree una nueva instancia cada vez que se necesite.

    /*Todos los mappers que hay aqui es porque ROOM necesita que los objetos que se guarden en la base de datos sean de tipo Entity con sus anotaciones,
    por lo que se necesita un mapper para convertir de un tipo a otro. En este caso, se convierte de SuperHero a SuperHeroEntity y viceversa.
     */

    suspend fun findAll(): List<SuperHero> {
        return superHeroDao.findAll().map {
            //Se convierte de SuperHeroEntity a SuperHero Domain
            it.toDomain()
        }
    }

    //Se ha añadido la función isInCacheTime para comprobar si el objeto está en cache o no
    //findAll() pero usando la función isInCacheTime
    suspend fun findAllwithCacheTime(): List<SuperHero> {
        return superHeroDao.findAll().map { superHeroEntity ->
            if (isInCacheTime(superHeroEntity.date)) {
                superHeroEntity.toDomain()
            } else {
                //Si no está en cache, se pasaria un error
                Log.d("@dev", "Superheroes not in cache")
                throw Exception("Superheroes not in cache")
            }
        }
    }

    private val TIME_CACHE = 60 * 1000L // 1 minute

    private fun isInCacheTime(date: Long): Boolean {
        return System.currentTimeMillis() - date < TIME_CACHE
    }

    suspend fun findById(superheroId: String): SuperHero {
        return superHeroDao.findById(superheroId).toDomain()
    }

    suspend fun saveAll(superheroes: List<SuperHero>) {
        val superHeroesList = superheroes.map {
            it.toEntity()
        }
        /*
        * Se utiliza el operador spread (*) para convertir la lista de SuperHeroEntity a un array de SuperHeroEntity y poder pasarlo como argumento a la función saveAll de SuperHeroDao
        * Porque la función saveAll de SuperHeroDao recibe un array de SuperHeroEntity
         */
        superHeroDao.saveAll(*superHeroesList.toTypedArray())
    }

    suspend fun save(superHero: SuperHero) {
        superHeroDao.save(superHero.toEntity())
    }

    suspend fun delete(superheroId: String) {
        superHeroDao.deleteById(superheroId)
    }
}