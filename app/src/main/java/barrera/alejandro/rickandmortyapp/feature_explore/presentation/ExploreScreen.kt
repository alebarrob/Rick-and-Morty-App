package barrera.alejandro.rickandmortyapp.feature_explore.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import barrera.alejandro.rickandmortyapp.core.presentation.components.AdaptableColumn
import barrera.alejandro.rickandmortyapp.feature_explore.domain.model.Character

@Composable
fun ExploreScreen() {

    val testCharacters = listOf<Character>(
        Character(
            id = 0,
            name = "Alejandro",
            status = "Alive",
            species = "Human",
            origin = "Unknown",
            location = "Unknown"
        ),
        Character(
            id = 1,
            name = "Vlada",
            status = "Alive",
            species = "Human",
            origin = "Unknown",
            location = "Unknown"
        )
    )

    AdaptableColumn(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

    }
}