package edu.iesam.dam2024.features.movies.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import coil.load
import edu.iesam.dam2024.databinding.FragmentMovieDetailBinding
import edu.iesam.dam2024.features.movies.domain.Movie

class MovieDetailFragment : Fragment() {

    private val moviesArgs: MovieDetailFragmentArgs by navArgs()

    private lateinit var movieFactory: MoviesFactory
    private lateinit var viewModel: MovieDetailViewModel

    private var _binding: FragmentMovieDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMovieDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movieFactory = MoviesFactory(requireContext())
        viewModel = movieFactory.buildMovieDetailViewModel()
        setupObserver()
        getMovieId()?.let {
            viewModel.viewCreated(it)
        }
    }

    private fun setupObserver() {
        val movieObserver = Observer<MovieDetailViewModel.UiState> { uiState ->
            uiState.movie?.let {
                bindData(it)
            }
            uiState.errorApp?.let {
                //pinto el error
            }
            if (uiState.isLoading) {
                //muestro el cargando...
                Log.d("@dev", "Cargando...")
            } else {
                //oculto el cargando...
                Log.d("@dev", " Cargado ...")
            }
        }
        viewModel.uiState.observe(viewLifecycleOwner, movieObserver)
    }

    private fun getMovieId(): String? {
        return moviesArgs.movieId
    }

    private fun bindData(movie: Movie) {
        binding.poster.load(movie.poster) {
            error(android.R.drawable.ic_menu_gallery)
        }
    }

    /*companion object {
        val KEY_MOVIE_ID = "key_movie_id"

        fun getIntent(context: Context, movieId: String): Intent {
            val intent = Intent(context, MovieDetailActivity::class.java)
            intent.putExtra(KEY_MOVIE_ID, movieId)
            return intent
        }
    }*/
}