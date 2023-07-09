package barrera.alejandro.rickandmortyapp.feature_explore.data.mappers

import barrera.alejandro.rickandmortyapp.feature_explore.data.local.entity.CharacterEntity
import barrera.alejandro.rickandmortyapp.feature_explore.domain.model.Character
import barrera.alejandro.rickandmortyapp.feature_explore.data.remote.dto.LocationDto
import barrera.alejandro.rickandmortyapp.feature_explore.data.remote.dto.OriginDto
import barrera.alejandro.rickandmortyapp.feature_explore.data.remote.dto.ResultDto
import com.google.common.truth.Truth
import org.junit.Test

class CharacterMappersTest {

    @Test
    fun `resultDto toCharacterEntity returns characterEntity`() {
        val expectedCharacterEntity = CharacterEntity(
            id = 1,
            name = "Rick Sanchez",
            status = "Alive",
            species = "Human",
            origin = "Earth (C-137)",
            location = "Citadel of Ricks",
            imageUrl = "https://rickandmortyapi.com/api/character/avatar/1.jpeg"
        )
        val resultDto = ResultDto(
            id = 1,
            name = "Rick Sanchez",
            status = "Alive",
            species = "Human",
            origin = OriginDto(name = "Earth (C-137)"),
            location = LocationDto(name = "Citadel of Ricks"),
            imageUrl = "https://rickandmortyapi.com/api/character/avatar/1.jpeg"
        )
        val result = resultDto.toCharacterEntity()

        Truth.assertThat(result).isEqualTo(expectedCharacterEntity)
    }

    @Test
    fun `characterEntity toCharacter returns character`() {
        val expectedCharacter = Character(
            id = 1,
            name = "Rick Sanchez",
            status = "Alive",
            species = "Human",
            origin = "Earth (C-137)",
            location = "Citadel of Ricks",
            imageUrl = "https://rickandmortyapi.com/api/character/avatar/1.jpeg"
        )
        val characterEntity = CharacterEntity(
            id = 1,
            name = "Rick Sanchez",
            status = "Alive",
            species = "Human",
            origin = "Earth (C-137)",
            location = "Citadel of Ricks",
            imageUrl = "https://rickandmortyapi.com/api/character/avatar/1.jpeg"
        )
        val result = characterEntity.toCharacter()

        Truth.assertThat(result).isEqualTo(expectedCharacter)
    }
}