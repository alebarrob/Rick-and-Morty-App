package barrera.alejandro.rickandmortyapp.core.presentation

import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

class CoreViewModelTest {

    private lateinit var coreViewModel: CoreViewModel

    @Before
    fun setup() {
        coreViewModel = CoreViewModel()
    }

    @Test
    fun `showTopBar event sets isTopBarVisible state to true`() {
        coreViewModel.onEvent(CoreEvent.ShowTopBar)

        val expected = true
        val result = coreViewModel.state.isTopBarVisible

        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `hideTopBar event sets isTopBarVisible state to false`() {
        coreViewModel.onEvent(CoreEvent.HideTopBar)

        val expected = false
        val result = coreViewModel.state.isTopBarVisible

        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `showBottomBar event sets isBottomBarVisible state to true`() {
        coreViewModel.onEvent(CoreEvent.ShowBottomBar)

        val expected = true
        val result = coreViewModel.state.isBottomBarVisible

        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `hideBottomBar event sets isBottomBarVisible state to false`() {
        coreViewModel.onEvent(CoreEvent.HideBottomBar)

        val expected = false
        val result = coreViewModel.state.isBottomBarVisible

        assertThat(result).isEqualTo(expected)
    }
}