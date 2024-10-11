package edu.iesam.dam2024.features.movies.data.remote

import edu.iesam.dam2024.features.movies.domain.Movie

class MovieMockRemoteDataSource {
    private val movies = listOf(
        Movie(
            "1",
            "title1",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT2zQTmlkz9ws0LzWqw56yQRoCAsdW3U-XkJQ&s"
        ),
        Movie("2", "title2", "poster2"),
        Movie("3", "title3", "poster3"),
        Movie("4", "title4", "poster4")
    )

    fun getMovies(): List<Movie> {
        return movies
    }

    fun getMovieById(id: String): Movie? {
        return movies.find { it.id == id }
    }
}