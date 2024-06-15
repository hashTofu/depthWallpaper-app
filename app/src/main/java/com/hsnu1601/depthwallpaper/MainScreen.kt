package com.hsnu1601.depthwallpaper

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastAny
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.hsnu1601.depthwallpaper.BottomNavItem.Companion.NavItems

@Composable
@Preview
fun MainScreen(navController : NavHostController = rememberNavController()) {
    Scaffold(
        bottomBar = {
            if (navController.currentBackStackEntry?.destination?.route != "editor") {
                BottomBar(navController = navController)
            }
        },
//        floatingActionButton = {
//            if (navController.currentBackStackEntry?.destination?.route == BottomNavItem.Editor.route) {
//                FloatingActionButton(onClick = { /* FAB action */ }) {
//                    Icon(Icons.Filled.Add, contentDescription = "Add")
//                }
//            }
//        }
    ) {
        innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
        ){

        }
        BottomNavGraph(navController = navController)
    }
}


@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomNavItem.Home,
//        BottomNavItem.Editor,
        BottomNavItem.Settings
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val shouldShowNavigationBar = remember(navBackStackEntry) {
        navBackStackEntry?.destination?.route == null ||
                screens.any { it.route == navBackStackEntry?.destination?.route }
    }
    val navigationBarHeight by animateDpAsState(
        targetValue = if (shouldShowNavigationBar) 80.dp else 0.dp,
        animationSpec = spring<Dp>(stiffness = Spring.StiffnessMediumLow),
        label = ""
    )
    val alphaValue by animateFloatAsState(
        targetValue = if (shouldShowNavigationBar) 1f else 0f,
        animationSpec = tween(durationMillis = 100), label = ""
    )


    NavigationBar(modifier = Modifier.height(navigationBarHeight)) {
        screens.forEach { screen ->
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = if (currentDestination?.hierarchy?.any { it.route == screen.route } == true) screen.selIcon else screen.unselIcon,
                        contentDescription = screen.title
                    )
                },
                label = { Text(screen.title,
                    modifier = Modifier
                        .alpha(alphaValue)
                        .height(navigationBarHeight-60.dp)
                    )
                },
                selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }

    }
}