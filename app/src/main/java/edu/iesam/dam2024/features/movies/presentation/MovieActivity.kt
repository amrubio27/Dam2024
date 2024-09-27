package edu.iesam.dam2024.features.movies.presentation

import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import edu.iesam.dam2024.R
import edu.iesam.dam2024.features.movies.data.local.MovieXmlLocalDataSource
import edu.iesam.dam2024.features.movies.domain.Movie

class MovieActivity : AppCompatActivity() {
    /*
    private val viewModel: MovieViewModel =
        MovieViewModel(GetMoviesUseCase(MovieDataRepository(MovieMockRemoteDataSource())))
    */

    private val movieFactory: MovieFactory = MovieFactory()
    private val viewModel: MovieViewModel = movieFactory.buildViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val movies = viewModel.viewCreated()
        bindData(movies)

        testXml()

        Log.d("@dev", movies.toString())
    }

    private fun bindData(movies: List<Movie>) {
        findViewById<TextView>(R.id.movie_id_1).text = movies[0].id
        findViewById<TextView>(R.id.movie_title_1).text = movies[0].title
        findViewById<LinearLayout>(R.id.layout_1).setOnClickListener {
            val movie1: Movie? = viewModel.itemSelected(movies[0].id)
            movie1?.let {
                Log.d("@dev", "Movie selected: ${it.title}")
            }
        }

        findViewById<TextView>(R.id.movie_id_2).text = movies[1].id
        findViewById<TextView>(R.id.movie_title_2).text = movies[1].title

        findViewById<TextView>(R.id.movie_id_3).text = movies[2].id
        findViewById<TextView>(R.id.movie_title_3).text = movies[2].title

        findViewById<TextView>(R.id.movie_id_4).text = movies[3].id
        findViewById<TextView>(R.id.movie_title_4).text = movies[3].title

    }

    private fun testXml() {
        val xmlDataSource = MovieXmlLocalDataSource(this)
        val movie = viewModel.itemSelected("1")
        movie?.let {
            xmlDataSource.save(it)
        }

        /*val movieSaved = xmlDataSource.find()
        Log.d("@dev", movieSaved.toString())

        val movieDelete = xmlDataSource.delete()*/

        testListXml()



    }

    private fun testListXml() {
        val movies = viewModel.viewCreated()
        val xmlDataSource = MovieXmlLocalDataSource(this)
        xmlDataSource.saveAll(movies)

        val moviesFromXml = xmlDataSource.findAll()
        Log.d("@Dev", moviesFromXml.toString())
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }
}