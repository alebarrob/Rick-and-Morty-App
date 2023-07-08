package barrera.alejandro.rickandmortyapp.feature_explore.data.remote.dto

import com.squareup.moshi.Json

data class ResultDto(
    @field:Json(name = "id")
    val id: Int,

    @field:Json(name = "name")
    val name: String,

    @field:Json(name = "status")
    val status: String,

    @field:Json(name = "species")
    val species: String,

    @field:Json(name = "origin")
    val origin: OriginDto,

    @field:Json(name = "location")
    val location: LocationDto,

    @field:Json(name = "image")
    val imageUrl: String
)
