package barrera.alejandro.rickandmortyapp.core.presentation.components

import androidx.compose.runtime.Composable
import androidx.navigation.NavDestination
import barrera.alejandro.rickandmortyapp.core.presentation.CoreEvent
import barrera.alejandro.rickandmortyapp.core.presentation.CoreViewModel

@Composable
fun UiController(
    viewModel: CoreViewModel,
    currentDestination: NavDestination?
) {
    when (currentDestination?.route) {
        "detail" + "/{name}/{status}/{species}/{origin}/{location}?imageUrl={imageUrl}" -> {
            viewModel.onEvent(CoreEvent.HideBottomBar)
            viewModel.onEvent(CoreEvent.ShowTopBar)
        }
        else -> {
            viewModel.onEvent(CoreEvent.ShowBottomBar)
            viewModel.onEvent(CoreEvent.HideTopBar)
        }
    }
}