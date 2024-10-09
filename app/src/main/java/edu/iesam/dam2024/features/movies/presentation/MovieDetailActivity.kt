package edu.iesam.dam2024.features.movies.presentation

import androidx.appcompat.app.AppCompatActivity

class MovieDetailActivity : AppCompatActivity() {
    /*
        private lateinit var movieFactory: MoviesFactory
        private lateinit var viewModel: MovieDetailViewModel

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_movie_detail)

            movieFactory = MoviesFactory(this)
            viewModel = movieFactory.buildMovieDetailViewModel()

            setupObserver()

            getMovieId()?.let { movieId ->
                viewModel.viewCreated(movieId)
            }
        }

        private fun setupObserver() {
            val movieObserver = Observer<MovieDetailViewModel.UiState> { uiState ->
                uiState.movie?.let { movies ->
                    bindData(movies)
                }

                uiState.errorApp?.let {
                    TODO()
                }

                if (uiState.isLoading) {
                    Log.d("@dev", "Loading")
                } else {

                    Log.d("@dev", "Loading")
                }

            }
            viewModel.uiState.observe(this, movieObserver)
        }

        private fun bindData(movie: Movie) {
            val imageView = findViewById<ImageView>(R.id.poster)
            *//*imageView.loadUrl(movie.poster)*//*

        // Load image from URL with Coil
        imageView.load(movie.poster)

        *//*Glide
            .with(this)
            .load(movie.poster)
            .into(imageView)*//*
    }

    private fun getMovieId(): String? {
        return intent.getStringExtra(KEY_MOVIE_ID)
    }


    companion object {
        const val KEY_MOVIE_ID = "key_movie_id"

        fun getIntent(context: Context, movieId: String): Intent {
            val intent = Intent(context, MovieDetailActivity::class.java)
            intent.putExtra(KEY_MOVIE_ID, movieId)

            return intent
        }
    }*/
}