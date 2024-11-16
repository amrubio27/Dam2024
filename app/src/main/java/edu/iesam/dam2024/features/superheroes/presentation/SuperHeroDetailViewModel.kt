package edu.iesam.dam2024.features.superheroes.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.iesam.dam2024.app.domain.ErrorApp
import edu.iesam.dam2024.features.superheroes.domain.GetSuperHeroUseCase
import edu.iesam.dam2024.features.superheroes.domain.SuperHero
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class SuperHeroDetailViewModel(
    private val getSuperHeroUseCase: GetSuperHeroUseCase
) : ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _uiState

    fun fetchSuperHero(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val superHero = getSuperHeroUseCase.invoke(id)
            _uiState.postValue(
                UiState(
                    superHero = superHero.getOrNull(),
                    isLoading = false,
                    errorApp = superHero.exceptionOrNull() as ErrorApp
                )
            )
        }
    }

    data class UiState(
        val isLoading: Boolean = true,
        val errorApp: ErrorApp? = null,
        val superHero: SuperHero? = null
    )
}

