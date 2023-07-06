package barrera.alejandro.rickandmortyapp.core.presentation.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import barrera.alejandro.rickandmortyapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    onBackClick: () -> Unit,
    topBarState: Boolean
) {
    AnimatedVisibility(
        visible = topBarState,
        enter = slideInVertically(initialOffsetY = { -it }),
        exit = slideOutVertically(targetOffsetY = { -it })
    ) {
        TopAppBar(
            title = {  },
            navigationIcon = {
                IconButton(onClick = onBackClick) {
                    Icon(
                        Icons.Filled.ArrowBack,
                        stringResource(id = R.string.back_icon_description)
                    )
                }
            },
            colors = TopAppBarDefaults.smallTopAppBarColors(
                containerColor = colorScheme.secondary,
                navigationIconContentColor = colorScheme.onSecondary
            )
        )
    }
}