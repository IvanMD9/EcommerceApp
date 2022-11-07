package com.example.ecommerceconcept.presentation.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.ecommerceconcept.presentation.favourites.FavouritesWindow
import com.example.ecommerceconcept.presentation.main_screen.MainWindow
import com.example.ecommerceconcept.presentation.my_cart.CartWindow
import com.example.ecommerceconcept.presentation.product_details.ProductDetailWindow
import com.example.ecommerceconcept.presentation.profile.ProfileWindow
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagerApi
@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Composable
fun NavigationButtonView(
    navController: NavHostController,
    bottomBarState: MutableState<Boolean>
) {
    NavHost(
        navController = navController,
        startDestination = NavigationScreen.MainScreen.route
    ) {
        composable(route = NavigationScreen.MainScreen.route) {
            bottomBarState.value = true
            MainWindow(navController = navController)
        }
        composable(route = NavigationScreen.CartScreen.route) {
            bottomBarState.value = false
            CartWindow(navController = navController)
        }
        composable(route = NavigationScreen.FavouritesScreen.route) {
            FavouritesWindow()
        }
        composable(route = NavigationScreen.ProfileScreen.route) {
            ProfileWindow()
        }
        composable(route = NavigationScreen.DetailsScreen.route) {
            bottomBarState.value = false
            ProductDetailWindow(navController = navController)
        }
    }
}