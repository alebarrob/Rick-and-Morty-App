package barrera.alejandro.rickandmortyapp.core.presentation

sealed class CoreEvent {
    object ShowTopBar : CoreEvent()
    object HideTopBar : CoreEvent()
    object ShowBottomBar : CoreEvent()
    object HideBottomBar : CoreEvent()
}