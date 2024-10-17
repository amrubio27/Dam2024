package edu.iesam.dam2024.features.movies.presentation.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import edu.iesam.dam2024.databinding.ItemMoviesBinding
import edu.iesam.dam2024.features.movies.domain.Movie

class MoviesViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    private val itemMovies = ItemMoviesBinding.bind(view)

    fun bind(result: Movie, onClickListener: (String) -> Unit) {
        itemMovies.apply {
            movieId.text = result.id
            movieTitle.text = result.title
            view.setOnClickListener {
                onClickListener(result.id)
            }
        }
    }
}