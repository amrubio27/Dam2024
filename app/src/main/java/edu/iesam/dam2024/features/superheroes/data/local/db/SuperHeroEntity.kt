package edu.iesam.dam2024.features.superheroes.data.local.db

import android.health.connect.datatypes.units.Power
import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

const val SUPERHERO_TABLE = "superhero"
const val SUPERHERO_ID = "superhero_id"

@Entity(tableName = SUPERHERO_TABLE)
class SuperHeroEntity(
    @PrimaryKey @ColumnInfo(name = SUPERHERO_ID) val id: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "url_image") val urlImage: String,
    @Embedded(prefix = "power") val power: Power,//se ha usado para poder hacer la relación con la tabla de powers, porque es otra entidad. asi serializamos el objeto power
)

/*
* Se ha añadido la anotación @Embedded para poder serializar el objeto Power y poder guardarlo en la base de datos.
* Hemos tenido que hacer un TypeConverter para poder serializar el objeto Power y guardarlo en la base de datos.
* Ejemplo de TypeConverter:
* @TypeConverter
* fun fromPower(power: Power): String {
*    return Gson().toJson(power)
* }
 */