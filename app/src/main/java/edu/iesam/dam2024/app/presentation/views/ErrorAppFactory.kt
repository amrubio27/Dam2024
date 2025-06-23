package edu.iesam.dam2024.app.presentation.views

import android.content.Context
import edu.iesam.dam2024.app.domain.ErrorApp

class ErrorAppFactory(
    private val context: Context
) {
    fun build(errorApp: ErrorApp): ErrorAppUi {
        return when (errorApp) {
            ErrorApp.DataErrorApp -> ServerErrorAppUi(context)
            ErrorApp.InternetErrorApp -> ConnectionErrorAppUi(context)
            ErrorApp.ServerErrorApp -> ServerErrorAppUi(context)
            ErrorApp.UnknownErrorApp -> UnknownErrorAppUi(context)
        }
    }
}