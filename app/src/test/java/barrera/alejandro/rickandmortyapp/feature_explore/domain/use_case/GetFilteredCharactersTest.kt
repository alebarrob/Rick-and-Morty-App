package barrera.alejandro.rickandmortyapp.feature_explore.domain.use_case

import barrera.alejandro.rickandmortyapp.feature_explore.data.repository.FakeCharacterRepositoryImpl
import barrera.alejandro.rickandmortyapp.feature_explore.data.mappers.collectData
import barrera.alejandro.rickandmortyapp.feature_explore.domain.model.Character
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class GetFilteredCharactersTest {
    private lateinit var getFilteredCharacters: GetFilteredCharacters

    @Before
    fun setup() {
        getFilteredCharacters = GetFilteredCharacters(FakeCharacterRepositoryImpl())
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `getFilteredCharacters returns paging filtered characters data`() = runTest {
        val expectedFilteredCharacters = listOf(
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
        val result = getFilteredCharacters("")
            .single()
            .collectData(StandardTestDispatcher(testScheduler))

        assertThat(result).isEqualTo(expectedFilteredCharacters)
    }
}