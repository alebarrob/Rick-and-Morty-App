package barrera.alejandro.rickandmortyapp.feature_explore.presentation.detail

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import barrera.alejandro.rickandmortyapp.R
import barrera.alejandro.rickandmortyapp.core.presentation.components.AdaptableColumn
import barrera.alejandro.rickandmortyapp.feature_explore.presentation.components.CharacterBasicInfo
import barrera.alejandro.rickandmortyapp.ui.theme.Black20
import barrera.alejandro.rickandmortyapp.ui.theme.LocalSpacing
import barrera.alejandro.rickandmortyapp.ui.theme.TransparentYellow80
import barrera.alejandro.rickandmortyapp.ui.theme.Typography
import coil.compose.AsyncImage

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues,
    viewModel: DetailViewModel = viewModel()
) {
    val spacing = LocalSpacing.current
    val state = viewModel.state

    AdaptableColumn(
        modifier = modifier.background(TransparentYellow80),
        verticalArrangement = Arrangement.spacedBy(
            space = spacing.spaceMedium,
            alignment = Alignment.Top
        ),
        horizontalAlignment = Alignment.CenterHorizontally,
        topBarPadding = paddingValues.calculateTopPadding()
    ) {
        Spacer(modifier = Modifier.height(spacing.spaceMedium))
        CharacterImageCard(
            modifier = Modifier
                .padding(horizontal = spacing.spaceMedium)
                .fillMaxWidth(),
            imageUrl = state.imageUrl
        )
        CharacterBasicInfo(
            modifier = Modifier
                .padding(horizontal = spacing.spaceLarge)
                .fillMaxWidth(),
            name = state.name,
            statusAndSpeciesStyle = Typography.bodyMedium,
            status = state.status,
            species = state.species
        )
        CharacterAdditionalInfo(
            modifier = Modifier
                .padding(horizontal = spacing.spaceLarge)
                .fillMaxWidth(),
            title = stringResource(id = R.string.last_known_location_text),
            subtitle = state.location
        )
        CharacterAdditionalInfo(
            modifier = Modifier
                .padding(horizontal = spacing.spaceLarge)
                .fillMaxWidth(),
            title = stringResource(id = R.string.origin_text),
            subtitle = state.origin
        )
        Spacer(modifier = Modifier.height(spacing.spaceSmall))
    }
}

@Composable
fun CharacterImageCard(
    modifier: Modifier = Modifier,
    imageUrl: String?
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.background),
        border = BorderStroke(2.dp, MaterialTheme.colorScheme.secondary),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Black20),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = imageUrl,
                contentDescription = stringResource(id = R.string.character_image_description),
                modifier = Modifier
                    .size(225.dp),
                placeholder = painterResource(id = R.drawable.placeholder),
                error = painterResource(id = R.drawable.placeholder),
                contentScale = ContentScale.FillBounds
            )
        }
    }
}

@Composable
fun CharacterAdditionalInfo(
    modifier: Modifier = Modifier,
    title: String,
    subtitle: String
) {
    val spacing = LocalSpacing.current

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(spacing.spaceExtraSmall)
    ) {
        Text(
            text = title,
            style = Typography.bodyLarge
        )
        Text(
            text = subtitle,
            style = Typography.bodyMedium
        )
    }
}