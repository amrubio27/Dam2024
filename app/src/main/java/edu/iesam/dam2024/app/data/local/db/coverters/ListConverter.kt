package edu.iesam.dam2024.app.data.local.db.coverters

import androidx.room.TypeConverter

class ListConverter {
    @TypeConverter
    fun fromString(value: String): List<String> {
        return value.split(",").map { it }
    }

    @TypeConverter
    fun fromList(list: List<String>): String {
        return list.joinToString(",")
    }
}