package barrera.alejandro.rickandmortyapp.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
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
            ExploreScreen(
                paddingValues = paddingValues,
                onNavigateToDetail = { name, status, species, origin, location, imageUrl ->
                    navController.navigate(
                        DetailScreen.route + "/$name" +
                                "/$status" +
                                "/$species" +
                                "/$origin" +
                                "/$location" +
                                "?imageUrl=$imageUrl"
                    )
                }
            )
        }
        composable(
            route = DetailScreen.route + "/{name}/{status}/{species}/{origin}/{location}?imageUrl={imageUrl}",
            arguments = listOf(
                navArgument("name") { type = NavType.StringType },
                navArgument("status") { type = NavType.StringType },
                navArgument("species") { type = NavType.StringType },
                navArgument("origin") { type = NavType.StringType },
                navArgument("location") { type = NavType.StringType },
                navArgument("imageUrl") {
                    nullable = true
                    type = NavType.StringType
                }
            )
        ) {
            DetailScreen(paddingValues = paddingValues)
        }
        composable(route = AboutMeScreen.route) {
            AboutMeScreen(paddingValues = paddingValues)
        }
    }
}