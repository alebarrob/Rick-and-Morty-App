package barrera.alejandro.rickandmortyapp.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import barrera.alejandro.rickandmortyapp.feature_about_me.presentation.AboutMeScreen
import barrera.alejandro.rickandmortyapp.feature_explore.presentation.DetailScreen
import barrera.alejandro.rickandmortyapp.feature_explore.presentation.ExploreScreen
import barrera.alejandro.rickandmortyapp.navigation.NavigationScreen.*

@Composable
fun NavGraph(
    navController: NavHostController,
    paddingValues: PaddingValues
) {
    NavHost(
        navController = navController,
        startDestination = ExploreScreen.route
    ) {
        composable(route = ExploreScreen.route) {
            ExploreScreen()
        }
        composable(route = DetailScreen.route) {
            DetailScreen()
        }
        composable(route = AboutMeScreen.route) {
            AboutMeScreen()
        }
    }
}