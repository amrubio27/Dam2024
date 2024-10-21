package edu.iesam.dam2024.features.superheroes.presentation.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import edu.iesam.dam2024.databinding.ItemSuperheroBinding
import edu.iesam.dam2024.features.superheroes.domain.SuperHero

class SuperHeroesViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    private val itemSuperhero = ItemSuperheroBinding.bind(view)

    fun bind(result: SuperHero, onClickListener: (String) -> Unit) {
        itemSuperhero.apply {
            superheroId.text = result.id.toString()
            superheroName.text = result.name
            view.setOnClickListener {
                onClickListener(result.id.toString())
            }
        }
    }
}