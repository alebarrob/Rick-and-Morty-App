package barrera.alejandro.rickandmortyapp.feature_explore.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import barrera.alejandro.rickandmortyapp.feature_explore.data.local.database.RickAndMortyDatabase
import barrera.alejandro.rickandmortyapp.feature_explore.data.mappers.toCharacter
import barrera.alejandro.rickandmortyapp.feature_explore.data.remote.api.RickAndMortyApi
import barrera.alejandro.rickandmortyapp.feature_explore.data.remote.mediator.CharacterRemoteMediator
import barrera.alejandro.rickandmortyapp.feature_explore.domain.model.Character
import barrera.alejandro.rickandmortyapp.feature_explore.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CharacterRepositoryImpl(
    private val rickAndMortyDatabase: RickAndMortyDatabase,
    private val rickAndMortyApi: RickAndMortyApi
) : CharacterRepository {

    @OptIn(ExperimentalPagingApi::class)
    override fun getCharactersPagingData(characterName: String): Flow<PagingData<Character>> {
        return Pager(
            config = PagingConfig(pageSize = 20),
            remoteMediator = CharacterRemoteMediator(
                rickAndMortyDatabase = rickAndMortyDatabase,
                rickAndMortyApi = rickAndMortyApi,
                characterName = characterName
            ),
            pagingSourceFactory = {
                rickAndMortyDatabase.characterDao().pagingSource()
            }
        )
            .flow
            .map { pagingData ->
                pagingData.map { it.toCharacter() }
            }
    }
}