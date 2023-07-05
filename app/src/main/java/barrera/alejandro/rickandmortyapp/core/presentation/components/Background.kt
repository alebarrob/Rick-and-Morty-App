package barrera.alejandro.rickandmortyapp.core.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import barrera.alejandro.rickandmortyapp.R

@Composable
fun Background() {
    Image(
        painter = painterResource(id = R.drawable.background),
        contentDescription = "Background image",
        contentScale = ContentScale.FillBounds
    )
}