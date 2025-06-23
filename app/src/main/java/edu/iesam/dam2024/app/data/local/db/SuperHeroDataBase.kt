package edu.iesam.dam2024.app.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import edu.iesam.dam2024.app.data.local.db.coverters.ListConverter
import edu.iesam.dam2024.app.data.local.db.coverters.PowerConverter
import edu.iesam.dam2024.features.superheroes.data.local.db.SuperHeroDao
import edu.iesam.dam2024.features.superheroes.data.local.db.SuperHeroEntity

//Se declara la base de datos
//Se declaran las todas entidades del proyecto que se usen y la versión de la base de datos se incrementa al cambiar la estructura de la base de datos (añaadir tablas, columnas, etc)
//La version se puede ligar a la de la aplicación para que al subirla a la play store, si se cambia la estructura de la base de datos, se actualice la base de datos del usuario
@Database(entities = [SuperHeroEntity::class], version = 1, exportSchema = false)
@TypeConverters(
    PowerConverter::class,
    ListConverter::class
)//Se añade el TypeConverter para poder serializar el objeto Power y guardarlo en la base de datos, si hay más de un TypeConverter, se pueden añadir con comas
abstract class SuperHeroDataBase : RoomDatabase() {

    //Se declaran los DAO de las entidades que se van a usar en la base de datos
    abstract fun superHeroDao(): SuperHeroDao
}