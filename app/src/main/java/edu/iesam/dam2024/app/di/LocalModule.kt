package edu.iesam.dam2024.app.di

import android.content.Context
import androidx.room.Room
import edu.iesam.dam2024.app.data.local.db.SuperHeroDataBase
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
@ComponentScan
class LocalModule {

    @Single
    fun provideDatabase(context: Context): SuperHeroDataBase {
        val db = Room.databaseBuilder(
            context,
            SuperHeroDataBase::class.java,
            "superhero-db",
        )
        db.fallbackToDestructiveMigration() //Se indica que si se cambia la estructura de la base de datos, se elimine la base de datos y se cree una nueva
        return db.build()
    }
}