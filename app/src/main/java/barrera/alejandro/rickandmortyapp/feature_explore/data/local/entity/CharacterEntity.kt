package barrera.alejandro.rickandmortyapp.feature_explore.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CharacterEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val origin: String,
    val location: String,
    val imageUrl: String?
)
