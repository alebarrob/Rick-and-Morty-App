package barrera.alejandro.rickandmortyapp.feature_explore.presentation.explore

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import barrera.alejandro.rickandmortyapp.feature_explore.domain.use_case.GetFilteredCharacters
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExploreViewModel @Inject constructor(
    private val getFilteredCharacters: GetFilteredCharacters
) : ViewModel() {

    var state by mutableStateOf(
        ExploreState(
            characters = getFilteredCharacters("").cachedIn(viewModelScope)
        )
    )
        private set

    fun onEvent(event: ExploreEvent) {
        when (event) {
            is ExploreEvent.OnQueryChange -> {
                state = state.copy(query = event.query)
            }
            is ExploreEvent.OnSearch -> {
                viewModelScope.launch {
                    state = state.copy(
                        characters = getFilteredCharacters(
                            state.query
                        ).cachedIn(viewModelScope)
                    )
                }
            }
        }
    }
}