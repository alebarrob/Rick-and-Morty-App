package barrera.alejandro.rickandmortyapp.feature_explore.data.mappers

import barrera.alejandro.rickandmortyapp.feature_explore.data.local.entity.CharacterEntity
import barrera.alejandro.rickandmortyapp.feature_explore.data.remote.dto.ResultDto
import barrera.alejandro.rickandmortyapp.feature_explore.domain.model.Character

fun ResultDto.toCharacterEntity(): CharacterEntity {
    return CharacterEntity(
        id = id,
        name = name,
        status = status,
        species = species,
        origin = origin.name,
        location = location.name,
        imageUrl = imageUrl
    )
}

fun CharacterEntity.toCharacter(): Character {
    return Character(
        id = id,
        name = name,
        status = status,
        species = species,
        origin = origin,
        location = location,
        imageUrl = imageUrl
    )
}