package com.example.ecommerceconcept.presentation.main_screen

sealed class EventMainScreen {
    data class EnteredText(val text : String) : EventMainScreen()
    object ClickFilter : EventMainScreen()
    object ClickFilterExit : EventMainScreen()
    object ClickFilterDone : EventMainScreen()
}
