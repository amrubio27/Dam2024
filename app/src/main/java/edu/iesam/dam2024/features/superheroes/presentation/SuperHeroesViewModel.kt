package edu.iesam.dam2024.features.superheroes.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.iesam.dam2024.app.domain.ErrorApp
import edu.iesam.dam2024.features.superheroes.domain.GetSuperHeroesUseCase
import edu.iesam.dam2024.features.superheroes.domain.SuperHero
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class SuperHeroesViewModel(
    private val getSuperHeroesUseCase: GetSuperHeroesUseCase
) : ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _uiState

    fun fetchSuperHeroes() {
        viewModelScope.launch(Dispatchers.IO) {
            val superHeroes = getSuperHeroesUseCase.invoke()
            _uiState.postValue(UiState(superHeroes = superHeroes))
        }
    }

    data class UiState(
        val isLoading: Boolean = true,
        val errorApp: ErrorApp? = null,
        val superHeroes: List<SuperHero>? = null
    )

}