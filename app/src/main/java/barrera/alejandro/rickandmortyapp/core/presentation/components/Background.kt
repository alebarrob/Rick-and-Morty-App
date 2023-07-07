package barrera.alejandro.rickandmortyapp.core.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import barrera.alejandro.rickandmortyapp.R

@Composable
fun Background(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier.fillMaxSize(),
        painter = painterResource(id = R.drawable.background),
        contentDescription = stringResource(id = R.string.background_description),
        contentScale = ContentScale.FillBounds
    )
}