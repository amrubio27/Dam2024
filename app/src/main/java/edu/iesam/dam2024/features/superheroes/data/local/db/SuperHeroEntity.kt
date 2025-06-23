package edu.iesam.dam2024.features.superheroes.data.local.db

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import edu.iesam.dam2024.features.superheroes.domain.Appearance
import edu.iesam.dam2024.features.superheroes.domain.Biography
import edu.iesam.dam2024.features.superheroes.domain.Connections
import edu.iesam.dam2024.features.superheroes.domain.Images
import edu.iesam.dam2024.features.superheroes.domain.PowerStats
import edu.iesam.dam2024.features.superheroes.domain.Work

const val SUPERHERO_TABLE = "superhero"
const val SUPERHERO_ID = "superhero_id"

@Entity(tableName = SUPERHERO_TABLE)
class SuperHeroEntity(
    @PrimaryKey @ColumnInfo(name = SUPERHERO_ID) val id: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "slug") val slug: String,
    @Embedded(prefix = "powerstats") val powerstats: PowerStats,
    @Embedded(prefix = "appearance") val appearance: Appearance,
    @Embedded(prefix = "biography") val biography: Biography,
    @Embedded(prefix = "work") val work: Work,
    @Embedded(prefix = "connections") val connections: Connections,
    @Embedded(prefix = "images") val images: Images, //se ha usado para poder hacer la relación con la tabla de powers, porque es otra entidad. asi serializamos el objeto power
    @ColumnInfo(name = "date") val date: Long
)

/*
* Se ha añadido la anotación @Embedded para poder serializar el objeto Power y poder guardarlo en la base de datos.
* Osea el embedded se usa para guardar serializando el objeto Power en la base de datos.
* Hemos tenido que hacer un TypeConverter para poder serializar el objeto Power y guardarlo en la base de datos.
* Ejemplo de TypeConverter:
* @TypeConverter
* fun fromPower(power: Power): String {
*    return Gson().toJson(power)
* }
 */