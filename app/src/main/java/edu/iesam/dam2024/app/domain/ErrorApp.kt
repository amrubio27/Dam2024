package edu.iesam.dam2024.app.domain

sealed class ErrorApp : Throwable() {
    //or be a class...
    object InternetErrorApp : ErrorApp()
    object ServerErrorApp : ErrorApp()
    object DataErrorApp : ErrorApp()
    object UnknownErrorApp : ErrorApp()
}