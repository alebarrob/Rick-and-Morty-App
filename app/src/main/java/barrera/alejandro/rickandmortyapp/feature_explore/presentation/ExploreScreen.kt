package barrera.alejandro.rickandmortyapp.feature_explore.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import barrera.alejandro.rickandmortyapp.R
import barrera.alejandro.rickandmortyapp.feature_explore.domain.model.Character
import barrera.alejandro.rickandmortyapp.feature_explore.presentation.components.CharacterBasicInfo
import barrera.alejandro.rickandmortyapp.ui.theme.Black20
import barrera.alejandro.rickandmortyapp.ui.theme.Black80
import barrera.alejandro.rickandmortyapp.ui.theme.LocalSpacing
import barrera.alejandro.rickandmortyapp.ui.theme.Typography
import coil.compose.AsyncImage

@Composable
fun ExploreScreen(
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues,
    onNavigateToDetail: (
        name: String,
        status: String,
        species: String,
        origin: String,
        location: String,
        imageUrl: String?
    ) -> Unit
) {
    val spacing = LocalSpacing.current

    val testCharacters = listOf(
        Character(
            id = 0,
            name = "Alejandro Barrera Robles",
            status = "Unknown",
            species = "Human",
            origin = "Unknown",
            location = "Unknown",
            imageUrl = "https://rickandmortyapi.com/api/character/avatar/9.jpeg"
        ),
        Character(
            id = 1,
            name = "Vlada Gorshunova",
            status = "Alive",
            species = "Human",
            origin = "Unknown",
            location = "Unknown",
            imageUrl = "https://rickandmortyapi.com/api/character/avatar/80.jpeg"
        ),
        Character(
            id = 2,
            name = "Example",
            status = "Dead",
            species = "Alien",
            origin = "Unknown",
            location = "Unknown",
            imageUrl = null
        )
    )

    Column(
        modifier = modifier
            .padding(
                start = spacing.spaceMedium,
                top = spacing.spaceLarge,
                end = spacing.spaceMedium,
                bottom = paddingValues.calculateBottomPadding()
            )
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SearchCard()
        CharactersLazyColumn(
            characters = testCharacters,
            onItemClick = onNavigateToDetail
        )
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchCard(modifier: Modifier = Modifier) {
    val spacing = LocalSpacing.current
    val keyboardController = LocalSoftwareKeyboardController.current

    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondary)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(spacing.spaceSmall),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(all = spacing.spaceSmall)
        ) {
            Text(
                text = stringResource(id = R.string.welcome_text),
                style = Typography.displayMedium,
                textAlign = TextAlign.Center
            )
            SearchTextField(
                modifier = Modifier.fillMaxWidth(),
                text = "",
                onValueChange = {

                },
                onSearch = {
                    keyboardController?.hide()

                }
            )
        }
    }
}

@Composable
fun SearchTextField(
    modifier: Modifier = Modifier,
    text: String,
    onValueChange: (String) -> Unit,
    onSearch: () -> Unit,
    hint: String = stringResource(id = R.string.search_hint)
) {
    OutlinedTextField(
        modifier = modifier,
        value = text,
        onValueChange = onValueChange,
        singleLine = true,
        keyboardActions = KeyboardActions(
            onSearch = {
                defaultKeyboardAction(ImeAction.Search)
                onSearch()
            }
        ),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
        shape = RoundedCornerShape(5.dp),
        placeholder = {
            Text(
                text = hint,
                color = Color.LightGray
            )
        },
        trailingIcon = {
            IconButton(onClick = onSearch) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = stringResource(id = R.string.search_hint)
                )
            }
        },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = MaterialTheme.colorScheme.background,
            unfocusedContainerColor = MaterialTheme.colorScheme.background,
            focusedTextColor = Black20,
            unfocusedTextColor = Black20,
            cursorColor = Black80,
            focusedIndicatorColor = Black20,
            unfocusedIndicatorColor = Black80
        )
    )
}

@Composable
fun CharactersLazyColumn(
    modifier: Modifier = Modifier,
    characters: List<Character>,
    onItemClick: (
        name: String,
        status: String,
        species: String,
        origin: String,
        location: String,
        imageUrl: String?
    ) -> Unit
) {
    val spacing = LocalSpacing.current

    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(space = spacing.spaceSmall),
        contentPadding = PaddingValues(vertical = spacing.spaceMedium)
    ) {
        items(characters) { character ->
            CharacterCard(
                character = character,
                onClick = onItemClick
            )
        }
    }
}

@Composable
fun CharacterCard(
    modifier: Modifier = Modifier,
    character: Character,
    onClick: (
        name: String,
        status: String,
        species: String,
        origin: String,
        location: String,
        imageUrl: String?
    ) -> Unit
) {
    val spacing = LocalSpacing.current

    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable {
                onClick(
                    character.name,
                    character.status,
                    character.species,
                    character.origin,
                    character.location,
                    character.imageUrl
                )
            },
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.background),
        border = BorderStroke(2.dp, MaterialTheme.colorScheme.secondary),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
    ) {
        Row {
            AsyncImage(
                model = character.imageUrl,
                contentDescription = stringResource(id = R.string.character_image_description),
                modifier = Modifier.size(120.dp),
                placeholder = painterResource(id = R.drawable.image_placeholder),
                error = painterResource(id = R.drawable.image_placeholder),
                contentScale = ContentScale.FillBounds
            )
            CharacterBasicInfo(
                modifier = modifier.padding(all = spacing.spaceSmall),
                name = character.name,
                status = character.status,
                species = character.species
            )
        }
    }
}

