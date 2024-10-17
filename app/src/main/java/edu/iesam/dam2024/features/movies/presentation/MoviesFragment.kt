package edu.iesam.dam2024.features.movies.presentation

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
import edu.iesam.dam2024.databinding.FragmentMoviesBinding
import edu.iesam.dam2024.features.movies.presentation.adapter.MoviesAdapter

class MoviesFragment : Fragment() {

    private lateinit var moviesFactory: MoviesFactory
    private lateinit var viewModel: MoviesViewModel

    private var _binding: FragmentMoviesBinding? = null
    private val binding get() = _binding!!
    private val moviesAdapter = MoviesAdapter()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMoviesBinding.inflate(inflater, container, false)

        setupView()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        moviesFactory = MoviesFactory(requireContext())
        viewModel = moviesFactory.buildViewModel()
        setupObserver()

        viewModel.viewCreated()
    }

    private fun setupView() {
        binding.apply {
            listMovies.apply {
                layoutManager = GridLayoutManager(
                    context,
                    1,
                    GridLayoutManager.VERTICAL,
                    false
                )
                moviesAdapter.setEvent { movieId ->
                    navigateToMovieDetail(movieId)
                }
                adapter = moviesAdapter
            }
        }
    }

    private fun setupObserver() {
        val movieObserver = Observer<MoviesViewModel.UiState> { uiState ->
            uiState.movies?.let { movies ->
                moviesAdapter.submitList(movies)
            }

            uiState.errorApp?.let {
                //Pinto el error
            } ?: run {
                //Ocultar el error
            }

            if (uiState.isLoading) {
                Log.d("@dev", "Loading")
            } else {
                Log.d("@dev", "Loading")
            }
        }
        viewModel.uiState.observe(viewLifecycleOwner, movieObserver)
    }

    private fun navigateToMovieDetail(movieId: String) {
        /*
        val intent = Intent(this, MovieDetailActivity::class.java)
        startActivity(intent)
         */
        //startActivity(MovieDetailActivity.getIntent(requireContext(), movieId))

        findNavController().navigate(
            MoviesFragmentDirections.actionMoviesFragmentToMovieDetailFragment(
                movieId
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