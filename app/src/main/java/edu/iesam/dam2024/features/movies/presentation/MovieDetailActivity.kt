package edu.iesam.dam2024.features.movies.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import coil.load
import edu.iesam.dam2024.R
import edu.iesam.dam2024.features.movies.domain.Movie

class MovieDetailActivity : AppCompatActivity() {

    private lateinit var movieFactory: MoviesFactory
    private lateinit var viewModel: MovieDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        movieFactory = MoviesFactory(this)
        viewModel = movieFactory.buildMovieDetailViewModel()

        getMovieId()?.let { movieId ->
            viewModel.viewCreated(movieId)?.let { movie ->
                bindData(movie)
            }
        }
    }

    private fun getMovieId(): String? {
        return intent.getStringExtra(KEY_MOVIE_ID)
    }

    private fun bindData(movie: Movie) {
        val imageView = findViewById<ImageView>(R.id.poster)
        /*imageView.loadUrl(movie.poster)*/

        imageView.load(movie.poster)

        /*Glide
            .with(this)
            .load(movie.poster)
            .into(imageView)*/
    }

    companion object {
        const val KEY_MOVIE_ID = "key_movie_id"

        fun getIntent(context: Context, movieId: String): Intent {
            val intent = Intent(context, MovieDetailActivity::class.java)
            intent.putExtra(KEY_MOVIE_ID, movieId)

            return intent
        }
    }
}