package edu.iesam.dam2024.features.movies.data.local

import android.content.Context
import com.google.gson.Gson
import edu.iesam.dam2024.R
import edu.iesam.dam2024.features.movies.domain.Movie

class MovieXmlLocalDataSource(private val context: Context) {
    private val sharedPref = context.getSharedPreferences(
        context.getString(R.string.name_file_xml),
        Context.MODE_PRIVATE
    )

    private val gson = Gson()

    fun save(movie: Movie) {
        /*val editor = sharedPref.edit()
        editor.putString("id", movie.id)
        editor.putString("title", movie.title)
        editor.putString("poster", movie.poster)
        editor.apply()*/

        //with scopefunction
        sharedPref.edit().apply {
            putString("id", movie.id)
            putString("title", movie.title)
            putString("poster", movie.poster)
            apply()
        }

    }

    fun saveAll(movies: List<Movie>) {
        //lo instancio fuera para que no este creando todo el raoto el objeto editor
        val editor = sharedPref.edit()
        movies.forEach { movie ->
            editor.putString(movie.id, gson.toJson(movie))
        }
        editor.apply()
    }

    fun find(): Movie {
        val id = sharedPref.getString("id", "")
        val title = sharedPref.getString("title", "")
        val poster = sharedPref.getString("poster", "")
        return Movie(id!!, title!!, poster!!)
    }

    fun delete() {
        sharedPref.edit().clear().apply()
    }

    fun findAll(): List<Movie> {
        val movies = mutableListOf<Movie>()
        val mapMovies = sharedPref.all as Map<String, String>
        mapMovies.values.forEach { jsonMovie ->
            //en vez del gson.fromJson(jsonMovie as String, Movie::class.java) por el casting de antes con el as Map<String, String>
            val movie = gson.fromJson(jsonMovie, Movie::class.java)
            movies.add(movie)
        }
        return movies
    }


}