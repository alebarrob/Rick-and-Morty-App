package barrera.alejandro.rickandmortyapp.feature_explore.data.repository

import androidx.paging.PagingData
import barrera.alejandro.rickandmortyapp.feature_explore.domain.model.Character
import barrera.alejandro.rickandmortyapp.feature_explore.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FakeCharacterRepositoryImpl : CharacterRepository {
    private val filteredCharacters = flowOf(
        PagingData.from(
            listOf(
                Character(
                    id = 1,
                    name = "Rick Sanchez",
                    status = "Alive",
                    species = "Human",
                    origin = "Earth (C-137)",
                    location = "Citadel of Ricks",
                    imageUrl = "https://rickandmortyapi.com/api/character/avatar/1.jpeg"
                ),
                Character(
                    id = 2,
                    name = "Morty Smith",
                    status = "Alive",
                    species = "Human",
                    origin = "unknown",
                    location = "Citadel of Ricks",
                    imageUrl = "https://rickandmortyapi.com/api/character/avatar/2.jpeg"
                )
            )
        )
    )

    override fun getCharactersPagingData(characterName: String): Flow<PagingData<Character>> {
        return filteredCharacters
    }
}