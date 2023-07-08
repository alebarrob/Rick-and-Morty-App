package barrera.alejandro.rickandmortyapp.feature_explore.presentation.detail

data class DetailState(
    val name: String,
    val status: String,
    val species: String,
    val origin: String,
    val location: String,
    val imageUrl: String?
)
