package barrera.alejandro.rickandmortyapp.feature_explore.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import barrera.alejandro.rickandmortyapp.feature_explore.data.local.dao.CharacterDao
import barrera.alejandro.rickandmortyapp.feature_explore.data.local.entity.CharacterEntity

@Database(entities = [CharacterEntity::class], version = 1, exportSchema = false)
abstract class RickAndMortyDatabase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao
}