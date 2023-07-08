package barrera.alejandro.rickandmortyapp.feature_explore.data.di

import android.content.Context
import androidx.room.Room
import barrera.alejandro.rickandmortyapp.feature_explore.data.local.database.RickAndMortyDatabase
import barrera.alejandro.rickandmortyapp.feature_explore.data.remote.api.RickAndMortyApi
import barrera.alejandro.rickandmortyapp.feature_explore.data.repository.CharacterRepositoryImpl
import barrera.alejandro.rickandmortyapp.feature_explore.domain.repository.CharacterRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ExploreDataModule {
    @Provides
    @Singleton
    fun provideRickAndMortyApi(): RickAndMortyApi {
        return Retrofit.Builder()
            .baseUrl(RickAndMortyApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(RickAndMortyApi::class.java)
    }

    @Singleton
    @Provides
    fun provideRickAndMortyDataBase(@ApplicationContext context: Context): RickAndMortyDatabase {
        return Room.databaseBuilder(
            context,
            RickAndMortyDatabase::class.java,
            "rickandmorty_database"
        ).build()
    }

    @Singleton
    @Provides
    fun provideCharacterRepository(
        rickAndMortyDatabase: RickAndMortyDatabase,
        rickAndMortyApi: RickAndMortyApi
    ): CharacterRepository {
        return CharacterRepositoryImpl(
            rickAndMortyDatabase = rickAndMortyDatabase,
            rickAndMortyApi = rickAndMortyApi
        )
    }
}