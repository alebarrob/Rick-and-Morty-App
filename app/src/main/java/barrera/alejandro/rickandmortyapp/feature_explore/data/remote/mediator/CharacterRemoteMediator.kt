package barrera.alejandro.rickandmortyapp.feature_explore.data.remote.mediator

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import barrera.alejandro.rickandmortyapp.feature_explore.data.local.database.RickAndMortyDatabase
import barrera.alejandro.rickandmortyapp.feature_explore.data.local.entity.CharacterEntity
import barrera.alejandro.rickandmortyapp.feature_explore.data.mappers.toCharacterEntity
import barrera.alejandro.rickandmortyapp.feature_explore.data.remote.api.RickAndMortyApi

@OptIn(ExperimentalPagingApi::class)
class CharacterRemoteMediator(
    private val rickAndMortyDatabase: RickAndMortyDatabase,
    private val rickAndMortyApi: RickAndMortyApi,
    private val characterName: String
): RemoteMediator<Int, CharacterEntity>() {

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, CharacterEntity>
    ): MediatorResult {
        return try {
            val loadKey = when (loadType) {
                LoadType.REFRESH -> 1
                LoadType.PREPEND -> return MediatorResult.Success(endOfPaginationReached = true)
                LoadType.APPEND -> {
                    val lastItem = state.lastItemOrNull()

                    if (lastItem == null) {
                        1
                    } else {
                        (lastItem.id / state.config.pageSize) + 1
                    }
                }
            }
            val response = rickAndMortyApi.getAllCharacters(
                page = loadKey,
                name = characterName
            )

            rickAndMortyDatabase.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    rickAndMortyDatabase.characterDao().clearAll()
                }
                val characterEntities = response.results.map { it.toCharacterEntity() }

                rickAndMortyDatabase.characterDao().upsertAll(characterEntities)
            }

            MediatorResult.Success(endOfPaginationReached = response.results.isEmpty())
        } catch (e: Exception) {
            MediatorResult.Error(e)
        }
    }
}