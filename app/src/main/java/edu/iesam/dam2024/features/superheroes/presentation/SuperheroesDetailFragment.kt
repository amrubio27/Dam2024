package edu.iesam.dam2024.features.superheroes.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import coil.load
import edu.iesam.dam2024.databinding.FragmentSuperheroDetailBinding
import edu.iesam.dam2024.features.superheroes.domain.SuperHero
import org.koin.androidx.viewmodel.ext.android.viewModel

class SuperheroesDetailFragment : Fragment() {
    private val superheroArgs: SuperheroesDetailFragmentArgs by navArgs()

    val viewModel: SuperHeroDetailViewModel by viewModel()

    private var _binding: FragmentSuperheroDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSuperheroDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupObserver()
        getSuperHeroId()?.let { superHeroId ->
            viewModel.fetchSuperHero(superHeroId)
        }
    }

    private fun setupObserver() {
        val superHeroObserver = Observer<SuperHeroDetailViewModel.UiState> { uiState ->
            uiState.superHero?.let { superHero ->
                bindData(superHero)
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
        viewModel.uiState.observe(viewLifecycleOwner, superHeroObserver)
    }

    private fun bindData(superHero: SuperHero) {
        binding.superheroImage.load(superHero.images.lg)
        binding.superheroId.text = superHero.id.toString()
        binding.superheroName.text = superHero.name
        binding.superheroSlug.text = superHero.slug
    }

    private fun getSuperHeroId(): String? {
        return superheroArgs.superheroId
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}