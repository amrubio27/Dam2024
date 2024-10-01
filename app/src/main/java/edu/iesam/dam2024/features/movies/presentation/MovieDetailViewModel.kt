package edu.iesam.dam2024.features.movies.presentation

import androidx.lifecycle.ViewModel
import edu.iesam.dam2024.features.movies.domain.GetMovieUseCase
import edu.iesam.dam2024.features.movies.domain.Movie

class MovieDetailViewModel(
    private val getMovieUseCase: GetMovieUseCase
) : ViewModel() {
    /**
     * Gestionar la lògica de la pantalla y los casos de uso
     * recibe por parametro el caso de uso
     * desciende de ViewModel porqué es una clase que se encarga de gestionar la lógica de la pantalla y asi no se pierde la información
     */

    fun viewCreated(id: String): Movie? {
        return getMovieUseCase.invoke(id)
    }
}