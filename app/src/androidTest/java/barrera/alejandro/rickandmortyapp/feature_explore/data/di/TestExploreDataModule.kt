package barrera.alejandro.rickandmortyapp.feature_explore.data.di

import android.content.Context
import androidx.room.Room
import barrera.alejandro.rickandmortyapp.feature_explore.data.local.database.RickAndMortyDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TestExploreDataModule {

    @Provides
    @Singleton
    @Named("test_database")
    fun provideInMemoryDb(@ApplicationContext context: Context): RickAndMortyDatabase {
        return Room.inMemoryDatabaseBuilder(
            context,
            RickAndMortyDatabase::class.java
        ).allowMainThreadQueries()
            .build()
    }

}