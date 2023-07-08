package barrera.alejandro.rickandmortyapp.core.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Scaffold
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import barrera.alejandro.rickandmortyapp.core.presentation.components.Background
import barrera.alejandro.rickandmortyapp.core.presentation.components.BottomBar
import barrera.alejandro.rickandmortyapp.core.presentation.components.TopBar
import barrera.alejandro.rickandmortyapp.core.presentation.components.UiController
import barrera.alejandro.rickandmortyapp.navigation.NavGraph
import barrera.alejandro.rickandmortyapp.navigation.NavigationScreen.ExploreScreen
import barrera.alejandro.rickandmortyapp.ui.theme.RickAndMortyAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RickAndMortyAppTheme {

                val viewModel: CoreViewModel by viewModels()
                val state = viewModel.state

                val navController = rememberNavController()
                val currentDestination =
                    navController.currentBackStackEntryAsState().value?.destination

                UiController(
                    viewModel = viewModel,
                    currentDestination = currentDestination
                )

                Box {
                    Background()
                    Scaffold(
                        containerColor = Color.Transparent,
                        topBar = {
                            TopBar(
                                onBackClick = {
                                    navController.navigateUp()
                                },
                                topBarState = state.isTopBarVisible
                            )
                        },
                        bottomBar = {
                            BottomBar(
                                onItemClick = { screen ->
                                    navController.navigate(screen.route) {
                                        popUpTo(ExploreScreen.route) { inclusive = false }
                                        launchSingleTop = true
                                    }
                                },
                                bottomBarState = state.isBottomBarVisible,
                                currentDestination = currentDestination
                            )
                        }
                    ) { paddingValues ->
                        NavGraph(
                            navController = navController,
                            paddingValues = paddingValues
                        )
                    }
                }
            }
        }
    }
}