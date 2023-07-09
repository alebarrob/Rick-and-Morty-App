package barrera.alejandro.rickandmortyapp.feature_explore.presentation.explore

import barrera.alejandro.rickandmortyapp.feature_explore.data.repository.FakeCharacterRepositoryImpl
import barrera.alejandro.rickandmortyapp.feature_explore.domain.use_case.GetFilteredCharacters
import com.google.common.truth.Truth
import org.junit.Before
import org.junit.Test

class ExploreViewModelTest {

    private lateinit var exploreViewModel: ExploreViewModel

    @Before
    fun setup() {
        exploreViewModel = ExploreViewModel(GetFilteredCharacters(FakeCharacterRepositoryImpl()))
    }

    @Test
    fun `onQueryChange event sets new query`() {
        exploreViewModel.onEvent(ExploreEvent.OnQueryChange("newQuery"))

        val expectedQuery = "newQuery"
        val result = exploreViewModel.state.query

        Truth.assertThat(result).isEqualTo(expectedQuery)
    }
}
