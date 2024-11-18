package edu.iesam.dam2024.features.superheroes.data.local.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface SuperHeroDao {
    /*
    * Se han añadido las anotaciones @Query, @Insert, @Update y @Delete para poder realizar las operaciones CRUD en la base de datos
    * Recordad que las operaciones de la base de datos se tienen que hacer en un hilo secundario, por lo que se tiene que hacer con corutinas
    * y que todas las operaciones de la base de datos se tienen que hacer con Entitys, por lo que se tendrá que hacer un mapper para convertir de un tipo a otro.
     */

    @Query("SELECT * FROM $SUPERHERO_TABLE")
    suspend fun findAll(): List<SuperHeroEntity>


    @Query("SELECT * FROM $SUPERHERO_TABLE where $SUPERHERO_ID = :superheroId LIMIT 1")
    suspend fun findById(superheroId: String): SuperHeroEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveAll(vararg superheroes: SuperHeroEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(superHero: SuperHeroEntity)

    @Update
    suspend fun updateUsers(vararg superheroes: SuperHeroEntity)

    @Update
    suspend fun updateUser(superHero: SuperHeroEntity)

    @Query("DELETE FROM $SUPERHERO_TABLE where $SUPERHERO_ID = :superheroId")
    suspend fun deleteById(superheroId: String)

    @Delete
    suspend fun delete(superHero: SuperHeroEntity)

}