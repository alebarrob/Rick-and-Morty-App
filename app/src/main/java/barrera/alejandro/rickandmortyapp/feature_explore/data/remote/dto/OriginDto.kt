package barrera.alejandro.rickandmortyapp.feature_explore.data.remote.dto

import com.squareup.moshi.Json

data class OriginDto(
    @field:Json(name = "name")
    val name: String
)
