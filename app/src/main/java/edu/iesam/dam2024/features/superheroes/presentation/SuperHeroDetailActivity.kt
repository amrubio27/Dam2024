package edu.iesam.dam2024.features.superheroes.presentation

/*class SuperHeroDetailActivity : AppCompatActivity() {

    private lateinit var superHeroFactory: SuperHeroFactory
    private lateinit var viewModel: SuperHeroDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_super_hero_detail)

        superHeroFactory = SuperHeroFactory(this)
        viewModel = superHeroFactory.buildDetailViewModel()

        setupObserver()

        getSuperHeroId()?.let { superHeroId ->
            viewModel.fetchSuperHero(superHeroId)
        }
    }

    private fun setupObserver() {
        val superHeroObserver = Observer<SuperHeroDetailViewModel.UiState> { uiState ->
            uiState.superHero?.let { superHero ->
                bindData(superHero)
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
        viewModel.uiState.observe(this, superHeroObserver)
    }

    private fun getSuperHeroId(): String? {
        return intent.getStringExtra(KEY_SUPERHERO_ID)
    }

    private fun bindData(superHero: SuperHero) {
        val imageView = findViewById<ImageView>(R.id.superhero_image)
        imageView.load(superHero.images.lg)
        findViewById<TextView>(R.id.superhero_id).text = superHero.id.toString()
        findViewById<TextView>(R.id.superhero_name).text = superHero.name
        findViewById<TextView>(R.id.superhero_slug).text = superHero.slug
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
*/
