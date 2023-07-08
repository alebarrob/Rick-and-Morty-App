package barrera.alejandro.rickandmortyapp.feature_explore.presentation.explore

sealed class ExploreEvent {
    data class OnQueryChange(val query: String) : ExploreEvent()
    object OnSearch : ExploreEvent()
}