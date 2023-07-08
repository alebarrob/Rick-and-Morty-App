package barrera.alejandro.rickandmortyapp.feature_explore.domain.use_case

import androidx.paging.PagingData
import barrera.alejandro.rickandmortyapp.feature_explore.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import barrera.alejandro.rickandmortyapp.feature_explore.domain.model.Character

class GetFilteredCharacters(private val repository: CharacterRepository) {
    operator fun invoke(query: String): Flow<PagingData<Character>> {
        return repository.getCharactersPagingData(characterName = query)
    }
}