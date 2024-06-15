package com.hsnu1601.depthwallpaper

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.hsnu1601.depthwallpaper.screens.EditorScreen
import com.hsnu1601.depthwallpaper.screens.HomeScreen
import com.hsnu1601.depthwallpaper.screens.SettingsScreen


@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItem.Home.route
    ){
        composable(BottomNavItem.Home.route){
            HomeScreen(navController)
        }
//        composable(BottomNavItem.Editor.route){
//            EditScreen(navController)
//        }
        composable(BottomNavItem.Settings.route){
            SettingsScreen()
        }
        composable("editor"){
            EditorScreen()
        }
    }
}