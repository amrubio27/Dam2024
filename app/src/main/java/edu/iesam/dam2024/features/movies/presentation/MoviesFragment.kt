package edu.iesam.dam2024.features.movies.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import edu.iesam.dam2024.app.domain.ErrorApp
import edu.iesam.dam2024.databinding.FragmentMoviesBinding
import edu.iesam.dam2024.features.movies.domain.Movie

class MoviesFragment : Fragment() {

    private lateinit var moviesFactory: MoviesFactory
    private lateinit var viewModel: MoviesViewModel

    private var _binding: FragmentMoviesBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMoviesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        moviesFactory = MoviesFactory(requireContext())
        viewModel = moviesFactory.buildViewModel()
        setupObserver()

        viewModel.viewCreated()
    }

    private fun setupObserver() {
        val movieObserver = Observer<MoviesViewModel.UiState> { uiState ->
            uiState.movies?.let { movies ->
                bindData(movies)
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

    private fun bindData(movies: List<Movie>) {
        binding.apply {
            movieId1.apply {
                text = movies[0].id
                movieTitle1.text = movies[0].title
                layout1.setOnClickListener {
                    navigateToMovieDetail(movies[0].id)
                }
            }
        }

        binding.movieId2.text = movies[1].id
        binding.movieTitle2.text = movies[1].title
        binding.layout2.setOnClickListener {
            navigateToMovieDetail(movies[1].id)
        }

        binding.movieId3.text = movies[2].id
        binding.movieTitle3.text = movies[2].title
        binding.layout3.setOnClickListener {
            navigateToMovieDetail(movies[2].id)
        }

        binding.movieId4.text = movies[3].id
        binding.movieTitle4.text = movies[3].title
        binding.layout4.setOnClickListener {
            navigateToMovieDetail(movies[3].id)
        }

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