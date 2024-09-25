package edu.iesam.dam2024.features.superheroes.presentation

import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import edu.iesam.dam2024.R
import edu.iesam.dam2024.features.superheroes.domain.SuperHero
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val superHeroFactory = SuperHeroFactory()
    private val viewModel = superHeroFactory.buildViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleScope.launch {
            val superHeroes = viewModel.fetchSuperHeroes()
            bindData(superHeroes)
            //Log.d("@Dev", "SuperHeroes: $superHeroes")
        }
    }

    private fun bindData(superHeroes: List<SuperHero>) {
        findViewById<TextView>(R.id.superhero_id_1).text = superHeroes[0].id.toString()
        findViewById<TextView>(R.id.superhero_name_1).text = superHeroes[0].name
        findViewById<LinearLayout>(R.id.layout_1).setOnClickListener {
            lifecycleScope.launch {
                viewModel.fetchSuperHeroById(superHeroes[0].id.toString())?.let {
                    Log.d("@Dev", "SuperHero: ${it.name}")
                }
            }
        }

        findViewById<TextView>(R.id.superhero_id_2).text = superHeroes[1].id.toString()
        findViewById<TextView>(R.id.superhero_name_2).text = superHeroes[1].name

        findViewById<TextView>(R.id.superhero_id_3).text = superHeroes[2].id.toString()
        findViewById<TextView>(R.id.superhero_name_3).text = superHeroes[2].name

        findViewById<TextView>(R.id.superhero_id_4).text = superHeroes[3].id.toString()
        findViewById<TextView>(R.id.superhero_name_4).text = superHeroes[3].name
    }

}