package barrera.alejandro.rickandmortyapp.feature_explore.presentation.explore

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import barrera.alejandro.rickandmortyapp.feature_explore.domain.model.Character

data class ExploreState(
    val query: String = "",
    val characters: Flow<PagingData<Character>>
)
