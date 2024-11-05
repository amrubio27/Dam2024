package edu.iesam.dam2024.app

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class SuperHeroApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@SuperHeroApp)
            //modules(AppModule().appModule)
        }
    }
}