package edu.iesam.dam2024.features.movies.domain
/**
 * Verbo(accion) + Sustantivo(entidad) + UseCase
 */
class GetMoviesUseCase(private val movieRepository: MovieRepository) {
    /**
     * fun execute(){} haría lo mismo que invoke()
     */
    operator fun invoke(): List<Movie> {
        // Aquí se implementa la lógica de negocio
        // para poder obtener las películas de la fuente de datos hay que hacer uso de una interfaz
        return movieRepository.getMovies()
    }
}