package edu.iesam.dam2024.features.movies.data

import edu.iesam.dam2024.features.movies.data.local.MovieXmlLocalDataSource
import edu.iesam.dam2024.features.movies.data.remote.MovieMockRemoteDataSource
import edu.iesam.dam2024.features.movies.domain.Movie
import edu.iesam.dam2024.features.movies.domain.MovieRepository

/*
class MovieDataRepository(private val mockRemoteDataSource: MovieMockRemoteDataSource) :
    MovieRepository {
    override fun getMovies(): List<Movie> {
        return mockRemoteDataSource.getMovies()
    }

    override fun getMovieById(id: String): Movie? {
        return mockRemoteDataSource.getMovieById(id)
    }
}*/

class MovieDataRepository(
    private val local: MovieXmlLocalDataSource,
    private val mockRemoteDataSource: MovieMockRemoteDataSource
) :
    MovieRepository {
    override fun getMovies(): List<Movie> {
        val moviesFromLocal = local.findAll()
        return if (moviesFromLocal.isEmpty()) {
            val moviesFromRemote = mockRemoteDataSource.getMovies()
            local.saveAll(moviesFromRemote)
            moviesFromRemote
        } else {
            moviesFromLocal
        }

    }

    override fun getMovieById(id: String): Movie? {
        return mockRemoteDataSource.getMovieById(id)
    }
}