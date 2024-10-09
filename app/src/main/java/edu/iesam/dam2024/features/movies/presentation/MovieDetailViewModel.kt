package edu.iesam.dam2024.features.movies.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.iesam.dam2024.app.domain.ErrorApp
import edu.iesam.dam2024.features.movies.domain.GetMovieUseCase
import edu.iesam.dam2024.features.movies.domain.Movie
import kotlinx.coroutines.launch

class MovieDetailViewModel(
    private val getMovieUseCase: GetMovieUseCase
) : ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _uiState

    /**
     * Gestionar la lògica de la pantalla y los casos de uso
     * recibe por parametro el caso de uso
     * desciende de ViewModel porqué es una clase que se encarga de gestionar la lógica de la pantalla y asi no se pierde la información
     */

    fun viewCreated(id: String) {
        viewModelScope.launch {
            // Obtener las películas
            val movie = getMovieUseCase.invoke(id)

            _uiState.postValue(UiState(movie = movie))

        }

    }

    data class UiState(
        val isLoading: Boolean = true,
        val errorApp: ErrorApp? = null,
        val movie: Movie? = null
    )
}