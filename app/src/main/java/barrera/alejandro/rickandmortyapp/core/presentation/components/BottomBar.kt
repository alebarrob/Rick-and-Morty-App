package barrera.alejandro.rickandmortyapp.core.presentation.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import barrera.alejandro.rickandmortyapp.navigation.NavigationScreen
import barrera.alejandro.rickandmortyapp.navigation.NavigationScreen.AboutMeScreen
import barrera.alejandro.rickandmortyapp.navigation.NavigationScreen.ExploreScreen
import barrera.alejandro.rickandmortyapp.ui.theme.Black20

@Composable
fun BottomBar(
    modifier: Modifier = Modifier,
    onItemClick: (NavigationScreen) -> Unit,
    bottomBarState: Boolean,
    currentDestination: NavDestination?
) {
    val screens = listOf(ExploreScreen, AboutMeScreen)

    AnimatedVisibility(
        visible = bottomBarState,
        enter = slideInVertically(initialOffsetY = { it }),
        exit = slideOutVertically(targetOffsetY = { it }),
    ) {
        NavigationBar(
            modifier = modifier.clip(RoundedCornerShape(15.dp, 15.dp, 0.dp, 0.dp)),
            containerColor = MaterialTheme.colorScheme.secondary
        ) {
            screens.forEach { screen ->
                val screenIsActive = currentDestination?.hierarchy?.any {
                    it.route == screen.route
                }

                NavigationBarItem(
                    label = {
                        Text(
                            text = stringResource(screen.iconLabelId!!),
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = if (screenIsActive == true) {
                                FontWeight.Bold
                            } else FontWeight.Medium
                        )
                    },
                    icon = {
                        if (screenIsActive == true) {
                            Image(
                                painter = painterResource(id = screen.iconImageId!!),
                                contentDescription = stringResource(id = screen.iconImageDescription!!)
                            )
                        } else {
                            Icon(
                                painter = painterResource(id = screen.iconImageId!!),
                                contentDescription = stringResource(id = screen.iconImageDescription!!)
                            )
                        }
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedTextColor = MaterialTheme.colorScheme.onSecondary,
                        indicatorColor = MaterialTheme.colorScheme.background,
                        unselectedIconColor = Black20,
                        unselectedTextColor = MaterialTheme.colorScheme.onSecondary
                    ),
                    selected = screenIsActive ?: false,
                    onClick = {
                        onItemClick(screen)
                    }
                )
            }
        }
    }
}