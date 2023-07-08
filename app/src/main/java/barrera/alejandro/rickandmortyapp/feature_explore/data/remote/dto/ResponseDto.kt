package barrera.alejandro.rickandmortyapp.feature_explore.data.remote.dto

import com.squareup.moshi.Json

data class ResponseDto(
    @field:Json(name = "results")
    val results: List<ResultDto>
)
