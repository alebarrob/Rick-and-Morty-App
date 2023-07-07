package barrera.alejandro.rickandmortyapp.feature_about_me.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import barrera.alejandro.rickandmortyapp.R
import barrera.alejandro.rickandmortyapp.core.presentation.components.AdaptableColumn
import barrera.alejandro.rickandmortyapp.ui.theme.LocalSpacing
import barrera.alejandro.rickandmortyapp.ui.theme.Typography

@Composable
fun AboutMeScreen(
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues
) {
    val spacing = LocalSpacing.current

    AdaptableColumn(
        modifier = modifier.padding(all = spacing.spaceSmall),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        bottomBarPadding = paddingValues.calculateBottomPadding()
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_ufo),
            contentDescription = stringResource(id = R.string.ufo_icon_description)
        )
        Spacer(modifier = Modifier.height(spacing.spaceExtraSmall))
        AboutMeCard()
    }
}

@Composable
fun AboutMeCard(modifier: Modifier = Modifier) {
    val spacing = LocalSpacing.current

    Card(
        modifier = modifier.padding(horizontal = spacing.spaceSmall),
        colors = CardDefaults.cardColors(containerColor = colorScheme.background),
        border = BorderStroke(2.dp, colorScheme.secondary),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
    ) {
        Text(
            modifier = Modifier.padding(all = spacing.spaceLarge),
            text = stringResource(id = R.string.about_me_message),
            style = Typography.bodyMedium,
            textAlign = TextAlign.Center
        )
    }
}