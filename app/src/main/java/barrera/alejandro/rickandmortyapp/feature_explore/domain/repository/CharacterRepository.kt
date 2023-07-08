package barrera.alejandro.rickandmortyapp.feature_explore.domain.repository

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import barrera.alejandro.rickandmortyapp.feature_explore.domain.model.Character

interface CharacterRepository {

    fun getCharactersPagingData(characterName: String): Flow<PagingData<Character>>
}