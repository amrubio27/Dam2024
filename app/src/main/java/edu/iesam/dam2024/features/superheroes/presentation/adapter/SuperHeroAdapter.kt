package edu.iesam.dam2024.features.superheroes.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import edu.iesam.dam2024.R
import edu.iesam.dam2024.features.superheroes.domain.SuperHero
import edu.iesam.dam2024.features.superheroes.presentation.SuperHeroesDiffUtil

class SuperHeroAdapter : ListAdapter<SuperHero, SuperHeroesViewHolder>(SuperHeroesDiffUtil()) {

    private lateinit var onClick: (superHeroid: String) -> Unit

    fun setEvent(onClick: (superHeroid: String) -> Unit) {
        this.onClick = onClick
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroesViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_superhero, parent, false)
        return SuperHeroesViewHolder(view)
    }

    override fun onBindViewHolder(holder: SuperHeroesViewHolder, position: Int) {
        holder.bind(currentList[position], onClick)
    }


}