package edu.iesam.dam2024.app.presentation.views

import android.content.Context
import edu.iesam.dam2024.R

interface ErrorAppUi {
    fun getImageError(): Int
    fun getErrorTitle(): String
    fun getErrorDescription(): String
    fun getActionRetry(): Unit
}

class ServerErrorAppUi(val context: Context) : ErrorAppUi {
    override fun getImageError(): Int {
        return R.drawable.ic_launcher_background
    }

    override fun getErrorTitle(): String {
        return context.getString(R.string.error_server_title)
    }

    override fun getErrorDescription(): String {
        return context.getString(R.string.error_server_description)
    }

    override fun getActionRetry() {
        TODO("Not yet implemented")
    }

}

class ConnectionErrorAppUi(val context: Context) : ErrorAppUi {
    override fun getImageError(): Int {
        return R.drawable.ic_launcher_background
    }

    override fun getErrorTitle(): String {
        return context.getString(R.string.error_network_title)
    }

    override fun getErrorDescription(): String {
        return context.getString(R.string.error_network_description)
    }

    override fun getActionRetry() {
        TODO("Not yet implemented")
    }

}

class UnknownErrorAppUi(val context: Context) : ErrorAppUi {
    override fun getImageError(): Int {
        return R.drawable.ic_launcher_background
    }

    override fun getErrorTitle(): String {
        return context.getString(R.string.error_unknown_title)
    }

    override fun getErrorDescription(): String {
        return context.getString(R.string.error_unknown_description)
    }

    override fun getActionRetry() {
        TODO("Not yet implemented")
    }

}