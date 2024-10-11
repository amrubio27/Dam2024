package edu.iesam.dam2024.features.superheroes.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import edu.iesam.dam2024.app.domain.ErrorApp
import edu.iesam.dam2024.databinding.FragmentSuperheroesListBinding
import edu.iesam.dam2024.features.superheroes.domain.SuperHero

class SuperHeroesListFragment : Fragment() {

    private lateinit var superHeroesFactory: SuperHeroFactory
    private lateinit var viewModel: SuperHeroesViewModel


    private var _binding: FragmentSuperheroesListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSuperheroesListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        superHeroesFactory = SuperHeroFactory(requireContext())
        viewModel = superHeroesFactory.buildViewModel()
        setupObservers()

        viewModel.fetchSuperHeroes()
    }

    private fun setupObservers() {
        val superHeroesObserver = Observer<SuperHeroesViewModel.UiState> { uiState ->
            uiState.superHeroes?.let { superHeroes ->
                bindData(superHeroes)
            }
            uiState.errorApp?.let {
                //Pintar el error
            } ?: run {
                //Ocultar el error
            }

            if (uiState.isLoading) {
                Log.d("@dev", "Cargando...")
            } else {
                Log.d("@dev", "Cargando...")
            }
        }
        viewModel.uiState.observe(viewLifecycleOwner, superHeroesObserver)
    }

    private fun bindData(superHeroes: List<SuperHero>) {
        binding.apply {
            layout1.apply {
                superheroId1.text = superHeroes[0].id.toString()
                superheroName1.text = superHeroes[0].name
                setOnClickListener {
                    navigateToDetail(superHeroes[0].id.toString())
                }
            }
            layout2.apply {
                superheroId2.text = superHeroes[1].id.toString()
                superheroName2.text = superHeroes[1].name
                setOnClickListener {
                    navigateToDetail(superHeroes[1].id.toString())
                }
            }
            layout3.apply {
                superheroId3.text = superHeroes[2].id.toString()
                superheroName3.text = superHeroes[2].name
                setOnClickListener {
                    navigateToDetail(superHeroes[2].id.toString())
                }
            }
            layout4.apply {
                superheroId4.text = superHeroes[3].id.toString()
                superheroName4.text = superHeroes[3].name
                setOnClickListener {
                    navigateToDetail(superHeroes[3].id.toString())
                }
            }
        }
    }

    private fun navigateToDetail(superHeroId: String) {
        findNavController().navigate(
            SuperHeroesListFragmentDirections.actionMoviesFragmentToMovieDetailFragment(
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