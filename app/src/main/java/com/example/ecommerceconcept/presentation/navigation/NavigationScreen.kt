package com.example.ecommerceconcept.presentation.navigation

sealed class NavigationScreen(val route : String) {
    object MainScreen : NavigationScreen(MAIN)
    object CartScreen : NavigationScreen(CART)
    object FavouritesScreen : NavigationScreen(FAVOURITES)
    object ProfileScreen : NavigationScreen(PROFILE)
    object DetailsScreen : NavigationScreen(DETAILS)


    companion object {
        const val MAIN = "main_screen"
        const val DETAILS = "details_screen"
        const val CART = "cart_screen"
        const val FAVOURITES = "favourites"
        const val PROFILE = "profile"
    }
}
