package edu.iesam.dam2024.app.domain

sealed class ErrorApp {
    object InternetErrorApp : ErrorApp()
    object ServerErrorApp : ErrorApp()
    object DataErrorApp : ErrorApp()
    object UnknownErrorApp : ErrorApp()

    /*companion object {
        @Volatile
        private var instance: ErrorApp? = null

        fun getInstance(): ErrorApp {
            return instance ?: synchronized(this) {
                instance ?: UnknownErrorApp.also { instance = it }
            }
        }
    }*/

}

//sincronizacion entre hilos para proteger frente a crear objetos a la vez en hilos diferentes