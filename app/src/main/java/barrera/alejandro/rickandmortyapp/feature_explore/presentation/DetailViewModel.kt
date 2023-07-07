package barrera.alejandro.rickandmortyapp.feature_explore.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class DetailViewModel(
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    var state by mutableStateOf(
        DetailState(
            name = savedStateHandle.get<String>("name")!!,
            status = savedStateHandle.get<String>("status")!!,
            species = savedStateHandle.get<String>("species")!!,
            origin = savedStateHandle.get<String>("origin")!!,
            location = savedStateHandle.get<String>("location")!!,
            imageUrl = savedStateHandle.get<String?>("imageUrl"),
        )
    )
        private set
}