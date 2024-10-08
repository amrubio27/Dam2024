package edu.iesam.dam2024.features.movies.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import edu.iesam.dam2024.R
import edu.iesam.dam2024.app.domain.ErrorApp

class MoviesActivity : AppCompatActivity() {
    /*
    private val viewModel: MovieViewModel =
        MovieViewModel(GetMoviesUseCase(MovieDataRepository(MovieMockRemoteDataSource())))
    */

    /*private val movieFactory: MovieFactory = MovieFactory()
    private val viewModel: MovieViewModel = movieFactory.buildViewModel()*/

    private lateinit var moviesFactory: MoviesFactory
    private lateinit var viewModel: MoviesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_movies)

        moviesFactory = MoviesFactory(this)
        viewModel = moviesFactory.buildViewModel()

        //setupObserver()

        viewModel.viewCreated()
    }


    /*private fun setupObserver() {
        val movieObserver = Observer<MoviesViewModel.UiState> { uiState ->
            uiState.movies?.let { movies ->
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
    }*/

    /*private fun bindData(movies: List<Movie>) {
        findViewById<TextView>(R.id.movie_id_1).text = movies[0].id
        findViewById<TextView>(R.id.movie_title_1).text = movies[0].title
        findViewById<LinearLayout>(R.id.layout_1).setOnClickListener {
            navigateToMovieDetail(movies[0].id)
        }

        findViewById<TextView>(R.id.movie_id_2).text = movies[1].id
        findViewById<TextView>(R.id.movie_title_2).text = movies[1].title
        findViewById<LinearLayout>(R.id.layout_2).setOnClickListener {
            navigateToMovieDetail(movies[1].id)
        }

        findViewById<TextView>(R.id.movie_id_3).text = movies[2].id
        findViewById<TextView>(R.id.movie_title_3).text = movies[2].title
        findViewById<LinearLayout>(R.id.layout_3).setOnClickListener {
            navigateToMovieDetail(movies[2].id)
        }

        findViewById<TextView>(R.id.movie_id_4).text = movies[3].id
        findViewById<TextView>(R.id.movie_title_4).text = movies[3].title
        findViewById<LinearLayout>(R.id.layout_4).setOnClickListener {
            navigateToMovieDetail(movies[3].id)
        }

    }*/

    /*private fun testXml() {
        val xmlDataSource = MovieXmlLocalDataSource(this)
        val movie = viewModel.itemSelected("1")
        movie?.let {
            xmlDataSource.save(it)
        }

        val movieSaved = xmlDataSource.find()
        Log.d("@dev", movieSaved.toString())

        xmlDataSource.delete()
    }*/

    /*  private fun testListXml() {
        val movies = viewModel.viewCreated()
        val xmlDataSource = MovieXmlLocalDataSource(this)
        xmlDataSource.saveAll(movies)

        val moviesFromXml = xmlDataSource.findAll()
        Log.d("@Dev", moviesFromXml.toString())
    }*/

    fun showError(error: ErrorApp) {
        when (error) {
            ErrorApp.InternetErrorApp -> TODO()
            ErrorApp.ServerErrorApp -> TODO()
            ErrorApp.DataErrorApp -> TODO()
            ErrorApp.UnknownErrorApp -> TODO()
        }
    }

    private fun navigateToMovieDetail(movieId: String) {
        /*
        val intent = Intent(this, MovieDetailActivity::class.java)
        startActivity(intent)
         */
        startActivity(MovieDetailActivity.getIntent(this, movieId))
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }
}