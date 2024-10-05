package edu.iesam.dam2024.features.superheroes.presentation

import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import edu.iesam.dam2024.R
import edu.iesam.dam2024.app.domain.ErrorApp
import edu.iesam.dam2024.features.superheroes.data.local.SuperHeroXmlLocalDataSource
import edu.iesam.dam2024.features.superheroes.domain.SuperHero
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var superHeroFactory: SuperHeroFactory
    private lateinit var viewModel: SuperHeroesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_super_heroes)

        superHeroFactory = SuperHeroFactory(this)
        viewModel = superHeroFactory.buildViewModel()

        setupObserver()

        viewModel.fetchSuperHeroes()

    }

    private fun setupObserver() {
        val superHeroesObserver = Observer<SuperHeroesViewModel.UiState> { uiState ->
            uiState.superHeroes?.let { superHeroes ->
                bindData(superHeroes)
            }
            uiState.errorApp?.let {
                TODO()
            }

            if (uiState.isLoading) {

                Log.d("@dev", "Cargando...")
            } else {
                Log.d("@dev", "Cargando...")
            }
        }
        viewModel.uiState.observe(this, superHeroesObserver)
    }

    private fun navigateToDetail(superHeroId: String) {
        startActivity(SuperHeroDetailActivity.getIntent(this, superHeroId))
    }

    private fun bindData(superHeroes: List<SuperHero>) {
        findViewById<TextView>(R.id.superhero_id_1).text = superHeroes[0].id.toString()
        findViewById<TextView>(R.id.superhero_name_1).text = superHeroes[0].name
        findViewById<LinearLayout>(R.id.layout_1).setOnClickListener {
            lifecycleScope.launch {
                navigateToDetail(superHeroes[0].id.toString())
            }
        }

        findViewById<TextView>(R.id.superhero_id_2).text = superHeroes[1].id.toString()
        findViewById<TextView>(R.id.superhero_name_2).text = superHeroes[1].name
        findViewById<LinearLayout>(R.id.layout_2).setOnClickListener {
            lifecycleScope.launch {
                navigateToDetail(superHeroes[1].id.toString())
            }
        }

        findViewById<TextView>(R.id.superhero_id_3).text = superHeroes[2].id.toString()
        findViewById<TextView>(R.id.superhero_name_3).text = superHeroes[2].name
        findViewById<LinearLayout>(R.id.layout_3).setOnClickListener {
            lifecycleScope.launch {
                navigateToDetail(superHeroes[2].id.toString())
            }
        }

        findViewById<TextView>(R.id.superhero_id_4).text = superHeroes[3].id.toString()
        findViewById<TextView>(R.id.superhero_name_4).text = superHeroes[3].name
        findViewById<LinearLayout>(R.id.layout_4).setOnClickListener {
            lifecycleScope.launch {
                navigateToDetail(superHeroes[3].id.toString())
            }
        }
    }

    private suspend fun testXml() {
        val xmlDataSource = SuperHeroXmlLocalDataSource(this)
        /*val superHero = viewModel.fetchSuperHeroById("1")
        superHero?.let {
            xmlDataSource.save(it)
        }*/

        val superHeroes = viewModel.fetchSuperHeroes()
        //xmlDataSource.saveAll(superHeroes)

        /*val superHeroSaved = xmlDataSource.find()
        Log.d("@Dev", superHeroSaved.toString())

        val superHeroDelete = xmlDataSource.delete()*/
    }

    fun showError(error: ErrorApp) {
        when (error) {
            ErrorApp.InternetErrorApp -> TODO()
            ErrorApp.ServerErrorApp -> TODO()
            ErrorApp.DataErrorApp -> TODO()
            ErrorApp.UnknownErrorApp -> TODO()
        }
    }

}