package barrera.alejandro.rickandmortyapp.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import barrera.alejandro.rickandmortyapp.R

sealed class NavigationScreen(
    val route: String,
    @StringRes val iconLabelId: Int? = null,
    @DrawableRes val iconImageId: Int? = null,
    @StringRes val iconImageDescription: Int? = null
) {
    object ExploreScreen : NavigationScreen(
        route = "explore",
        iconLabelId = R.string.explore_label_text,
        iconImageId = R.drawable.ic_explore,
        iconImageDescription = R.string.explore_icon_description
    )

    object AboutMeScreen : NavigationScreen(
        route = "aboutMe",
        iconLabelId = R.string.about_me_label_text,
        iconImageId = R.drawable.ic_about_me,
        iconImageDescription = R.string.about_me_icon_description
    )

    object DetailScreen : NavigationScreen(route = "detail")
}
