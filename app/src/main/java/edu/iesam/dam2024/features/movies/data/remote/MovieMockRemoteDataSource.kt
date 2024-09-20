package edu.iesam.dam2024.features.movies.data.remote

import edu.iesam.dam2024.features.movies.domain.Movie

class MovieMockRemoteDataSource {
    fun getMovies(): List<Movie> {
        return listOf(
            Movie("1", "title2", "poster1"),
            Movie("2", "title2", "poster1"),
            Movie("3", "title2", "poster1"),
            Movie("1","title2", "poster1")
        )
    }
}