package barrera.alejandro.rickandmortyapp.feature_explore.data.remote.dto

import com.squareup.moshi.Json

data class LocationDto(
    @field:Json(name = "name")
    val name: String
)
