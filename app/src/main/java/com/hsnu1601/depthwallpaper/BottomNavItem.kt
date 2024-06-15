package com.hsnu1601.depthwallpaper

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(
    val title: String,
    val selIcon: ImageVector,
    val unselIcon: ImageVector,
    val route: String
){
    object Home: BottomNavItem(
        title = "Home",
        selIcon = Icons.Filled.Home,
        unselIcon = Icons.Outlined.Home,
        route = "home"
    )
//    object Editor: BottomNavItem(
//        title = "Editor",
//        selIcon = Icons.Filled.Edit,
//        unselIcon = Icons.Outlined.Edit,
//        route = "editor"
//    )
    object Settings: BottomNavItem(
        title = "Settings",
        selIcon = Icons.Filled.Settings,
        unselIcon = Icons.Outlined.Settings,
        route = "settings"
    )
    companion object {
        val NavItems = listOf(Home, Settings)
    }
}