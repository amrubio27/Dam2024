package edu.iesam.dam2024.app.data.local.db.coverters

import android.health.connect.datatypes.units.Power
import androidx.room.TypeConverter
import com.google.gson.Gson

class PowerConverter {

    /*
    * Se ha añadido la anotación @TypeConverter para poder serializar el objeto Power y poder guardarlo en la base de datos y poder recuperarlo.
     */

    @TypeConverter
    fun from(power: String): Power {
        return Gson().fromJson(power, Power::class.java)
    }

    @TypeConverter
    fun to(power: Power): String {
        return Gson().toJson(power, Power::class.java)
    }
}