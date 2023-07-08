package barrera.alejandro.rickandmortyapp.feature_explore.domain.di

import barrera.alejandro.rickandmortyapp.feature_explore.domain.repository.CharacterRepository
import barrera.alejandro.rickandmortyapp.feature_explore.domain.use_case.GetFilteredCharacters
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object ExploreDomainModule {

    @ViewModelScoped
    @Provides
    fun provideGetFilteredCharacters(
        characterRepository: CharacterRepository
    ): GetFilteredCharacters {
        return GetFilteredCharacters(repository = characterRepository)
    }
}