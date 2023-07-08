package barrera.alejandro.rickandmortyapp.feature_explore.data.remote.api

import barrera.alejandro.rickandmortyapp.feature_explore.data.remote.dto.ResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface RickAndMortyApi {
    @GET("character")
    suspend fun getAllCharacters(
        @Query("name") name: String,
        @Query("page") page: Int
    ): ResponseDto

    companion object {
        const val BASE_URL = "https://rickandmortyapi.com/api/"
    }
}