package barrera.alejandro.rickandmortyapp.feature_explore.data.local.dao

import barrera.alejandro.rickandmortyapp.feature_explore.data.local.database.RickAndMortyDatabase
import barrera.alejandro.rickandmortyapp.feature_explore.data.local.entity.CharacterEntity
import barrera.alejandro.rickandmortyapp.feature_explore.data.remote.api.RickAndMortyApi
import com.google.common.truth.Truth.assertThat
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject
import javax.inject.Named

@HiltAndroidTest
class CharacterDaoTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    @Named("test_database")
    lateinit var database: RickAndMortyDatabase
    @Inject
    lateinit var api: RickAndMortyApi
    private lateinit var dao: CharacterDao

    @Before
    fun setup() {
        hiltRule.inject()
        dao = database.characterDao()
    }

    @After
    fun teardown() {
        database.close()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun insertCharacters() = runTest {
        val expectedCharacters = listOf(
            CharacterEntity(
                id = 1000,
                name = "Test 1",
                status = "Alive",
                species = "Human",
                origin = "Earth (C-137)",
                location = "Citadel of Ricks",
                imageUrl = "https://rickandmortyapi.com/api/character/avatar/1.jpeg"
            ),
            CharacterEntity(
                id = 1001,
                name = "Test 2",
                status = "Alive",
                species = "Human",
                origin = "unknown",
                location = "Citadel of Ricks",
                imageUrl = "https://rickandmortyapi.com/api/character/avatar/2.jpeg"
            )
        )

        dao.upsertAll(expectedCharacters)

        val charactersInDatabase = dao.getAllCharacters()

        assertThat(charactersInDatabase).isEqualTo(expectedCharacters)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun deleteCharacters() = runTest {
        val expectedCharacters = emptyList<CharacterEntity>()
        val characters = listOf(
            CharacterEntity(
                id = 1000,
                name = "Test 1",
                status = "Alive",
                species = "Human",
                origin = "Earth (C-137)",
                location = "Citadel of Ricks",
                imageUrl = "https://rickandmortyapi.com/api/character/avatar/1.jpeg"
            ),
            CharacterEntity(
                id = 1001,
                name = "Test 2",
                status = "Alive",
                species = "Human",
                origin = "unknown",
                location = "Citadel of Ricks",
                imageUrl = "https://rickandmortyapi.com/api/character/avatar/2.jpeg"
            )
        )

        dao.upsertAll(characters)
        dao.clearAllCharacters()

        val charactersInDatabase = dao.getAllCharacters()

        assertThat(charactersInDatabase).isEqualTo(expectedCharacters)
    }

}