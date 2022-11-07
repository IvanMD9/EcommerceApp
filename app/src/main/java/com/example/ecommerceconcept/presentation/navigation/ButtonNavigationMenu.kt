package com.example.ecommerceconcept.presentation.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.ecommerceconcept.presentation.ui.theme.NavigationMenuColor

@Composable
fun NavigationMenu(
    items: List<NavigationMenuItem>,
    navController: NavController,
    modifier: Modifier = Modifier,
    onClickItem: (NavigationMenuItem) -> Unit,
    bottomBarState: MutableState<Boolean>
) {
    AnimatedVisibility(
        visible = bottomBarState.value,
        exit = slideOutVertically(targetOffsetY = { it }),
        enter = slideInVertically(initialOffsetY = { it }),
        content = {
            val backStackEntry = navController.currentBackStackEntryAsState()
            BottomNavigation(
                modifier = modifier,
                backgroundColor = NavigationMenuColor,
                elevation = 5.dp
            ) {
                for (el in items) {
                    val selected = el.route == backStackEntry.value?.destination?.route
                    BottomNavigationItem(
                        selected = selected,
                        onClick = { onClickItem(el) },
                        selectedContentColor = Color.White,
                        unselectedContentColor = Color.Gray,
                        icon = {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                if (el.count > 0) {
                                    BadgedBox(badge = {
                                        Badge(content = {
                                            Text(text = el.count.toString())
                                        })
                                    }) {
                                        Icon(
                                            painter = painterResource(id = el.image),
                                            contentDescription = null
                                        )
                                    }
                                } else {
                                    Icon(
                                        painter = painterResource(id = el.image),
                                        contentDescription = null
                                    )
                                }
                            }
                        }
                    )
                }
            }
        }
    )
}