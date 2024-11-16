package edu.iesam.dam2024.features.superheroes.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import edu.iesam.dam2024.app.domain.ErrorApp
import edu.iesam.dam2024.databinding.FragmentSuperheroesListBinding
import edu.iesam.dam2024.features.superheroes.presentation.adapter.SuperHeroAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class SuperHeroesListFragment : Fragment() {

    val viewModel: SuperHeroesViewModel by viewModel()

    private var _binding: FragmentSuperheroesListBinding? = null
    private val binding get() = _binding!!
    private val superHeroesAdapter = SuperHeroAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSuperheroesListBinding.inflate(inflater, container, false)

        setupView()

        return binding.root
    }

    private fun setupView() {
        binding.apply {
            listSuperHeroes.apply {
                layoutManager = GridLayoutManager(
                    context,
                    1,
                    GridLayoutManager.VERTICAL,
                    false
                )
                superHeroesAdapter.setEvent { superHero ->
                    navigateToDetail(superHero)
                }
                adapter = superHeroesAdapter
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupObservers()
        viewModel.fetchSuperHeroes()
    }

    private fun setupObservers() {
        val superHeroesObserver = Observer<SuperHeroesViewModel.UiState> { uiState ->
            uiState.superHeroes?.let { superHeroes ->
                superHeroesAdapter.submitList(superHeroes)
            }
            uiState.errorApp?.let {
                //Pintar el error
            } ?: run {
                //Ocultar el error
            }

            if (uiState.isLoading) {
                //Pintar Skeleton
                Log.d("@dev", "Cargando...")
            } else {
                Log.d("@dev", "Cargando...")
            }
        }
        viewModel.uiState.observe(viewLifecycleOwner, superHeroesObserver)
    }

    private fun navigateToDetail(superHeroId: String) {
        findNavController().navigate(
            SuperHeroesListFragmentDirections.actionSuperheroesFragmentToSuperheroesDetailFragment(
                superHeroId
            )
        )
    }

    fun showError(error: ErrorApp) {
        when (error) {
            ErrorApp.InternetErrorApp -> TODO()
            ErrorApp.ServerErrorApp -> TODO()
            ErrorApp.DataErrorApp -> TODO()
            ErrorApp.UnknownErrorApp -> TODO()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}