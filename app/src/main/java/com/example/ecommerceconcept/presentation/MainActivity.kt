package com.example.ecommerceconcept.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.ecommerceconcept.R
import com.example.ecommerceconcept.presentation.navigation.NavigationButtonView
import com.example.ecommerceconcept.presentation.navigation.NavigationMenu
import com.example.ecommerceconcept.presentation.navigation.NavigationMenuItem
import com.example.ecommerceconcept.presentation.navigation.NavigationScreen
import com.example.ecommerceconcept.presentation.ui.theme.EcommerceConceptTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalPagerApi
@ExperimentalFoundationApi
@AndroidEntryPoint
@ExperimentalMaterialApi
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EcommerceConceptTheme {
                val systemUiController: SystemUiController = rememberSystemUiController()
                systemUiController.isNavigationBarVisible = false

                val navController = rememberNavController()
                val showBottomBar = rememberSaveable {
                    mutableStateOf(true)
                }
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Scaffold(
                        bottomBar = {
                            NavigationMenu(
                                items = listOf(
                                    NavigationMenuItem(
                                        R.drawable.ic_home_menu,
                                        NavigationScreen.MAIN
                                    ),
                                    NavigationMenuItem(
                                        R.drawable.ic_shop_menu,
                                        NavigationScreen.CART,
                                        2
                                    ),
                                    NavigationMenuItem(
                                        R.drawable.ic_favourites_menu,
                                        NavigationScreen.FAVOURITES
                                    ),
                                    NavigationMenuItem(
                                        R.drawable.ic_profile_menu,
                                        NavigationScreen.PROFILE
                                    ),
                                ),
                                modifier = Modifier
                                    .background(Color.White)
                                    .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)),
                                navController = navController,
                                onClickItem = {
                                    navController.navigate(it.route)
                                },
                                bottomBarState = showBottomBar
                            )
                        },
                        content = {
                            NavigationButtonView(
                                navController = navController,
                                bottomBarState = showBottomBar
                            )
                        }
                    )
                }
            }
        }
    }
}