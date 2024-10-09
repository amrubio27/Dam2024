package edu.iesam.dam2024.features.movies.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.iesam.dam2024.app.domain.ErrorApp
import edu.iesam.dam2024.features.movies.domain.GetMoviesUseCase
import edu.iesam.dam2024.features.movies.domain.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MoviesViewModel(
    private val getMoviesUseCase: GetMoviesUseCase
) : ViewModel() {
    /**
     * Gestionar la lògica de la pantalla y los casos de uso
     * recibe por parametro el caso de uso
     * desciende de ViewModel porqué es una clase que se encarga de gestionar la lógica de la pantalla y asi no se pierde la información
     */

    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _uiState


    fun viewCreated() {
        _uiState.value = UiState(isLoading = true)
        // Lanzar la corrutina en el hilo IO
        viewModelScope.launch(Dispatchers.IO) {
            // Obtener las películas
            val movies = getMoviesUseCase.invoke()
            // Actualizar el LiveData con postValue. Origen: IO,default,Main destino: Main
            _uiState.postValue(UiState(movies = movies))

            /*Otro ejemplo es el .value: Origen: Main destino: Main
            _uiState.value(UiState(movies = movies))
             */
        }
    }

    data class UiState(
        val isLoading: Boolean = true,
        val errorApp: ErrorApp? = null,
        val movies: List<Movie>? = null
    )
}