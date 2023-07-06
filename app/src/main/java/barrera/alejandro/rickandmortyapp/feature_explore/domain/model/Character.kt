package barrera.alejandro.rickandmortyapp.feature_explore.domain.model

data class Character(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val origin: String,
    val location: String
)
