package edu.iesam.dam2024.features.superheroes.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import coil.load
import edu.iesam.dam2024.R
import edu.iesam.dam2024.features.superheroes.domain.SuperHero
import kotlinx.coroutines.launch

class SuperHeroDetailActivity : AppCompatActivity() {

    private lateinit var superHeroFactory: SuperHeroFactory
    private lateinit var viewModel: SuperHeroDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_super_hero_detail)

        superHeroFactory = SuperHeroFactory(this)
        viewModel = superHeroFactory.buildDetailViewModel()

        getSuperHeroId()?.let {
            lifecycleScope.launch {
                val superHero = viewModel.fetchSuperHero(it)
                superHero?.let {
                    bindData(it)
                }
            }
        }
    }

    private fun getSuperHeroId(): String? {
        return intent.getStringExtra(KEY_SUPERHERO_ID)
    }

    private fun bindData(superHero: SuperHero) {
        val imageView = findViewById<ImageView>(R.id.superhero_image)

        imageView.load(superHero.images.lg)

    }

    companion object {
        const val KEY_SUPERHERO_ID = "key_superhero_id"

        fun getIntent(context: Context, superHeroId: String): Intent {
            return Intent(context, SuperHeroDetailActivity::class.java).apply {
                putExtra(KEY_SUPERHERO_ID, superHeroId)
            }
        }
    }
}

