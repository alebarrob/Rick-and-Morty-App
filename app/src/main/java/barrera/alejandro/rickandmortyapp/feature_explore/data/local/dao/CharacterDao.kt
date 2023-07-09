package barrera.alejandro.rickandmortyapp.feature_explore.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import barrera.alejandro.rickandmortyapp.feature_explore.data.local.entity.CharacterEntity

@Dao
interface CharacterDao {
    @Upsert
    suspend fun upsertAll(characters: List<CharacterEntity>)

    @Query("SELECT * FROM characterentity")
    fun pagingSource(): PagingSource<Int, CharacterEntity>

    @Query("SELECT * FROM characterentity")
    suspend fun getAllCharacters(): List<CharacterEntity>

    @Query("DELETE FROM characterentity")
    suspend fun clearAllCharacters()
}