package barrera.alejandro.rickandmortyapp.feature_explore.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import barrera.alejandro.rickandmortyapp.R
import barrera.alejandro.rickandmortyapp.ui.theme.LocalSpacing
import barrera.alejandro.rickandmortyapp.ui.theme.Typography

@Composable
fun CharacterBasicInfo(
    modifier: Modifier = Modifier,
    nameStyle: TextStyle = Typography.bodyLarge,
    name: String,
    statusAndSpeciesStyle: TextStyle = Typography.bodySmall,
    status: String,
    species: String
) {
    val spacing = LocalSpacing.current

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(spacing.spaceExtraSmall)
    ) {
        Text(
            text = name,
            style = nameStyle
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(spacing.spaceExtraSmall),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(
                    id = when (status) {
                        "Alive" -> R.drawable.ic_green_light_indicator
                        "Dead" -> R.drawable.ic_red_light_indicator
                        else -> R.drawable.ic_grey_light_indicator
                    }
                ),
                contentDescription = stringResource(id = R.string.light_indicator_image_description)
            )
            Text(
                text = "$status - $species",
                style = statusAndSpeciesStyle,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}