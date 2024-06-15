package com.hsnu1601.depthwallpaper.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController


@Composable
fun HomeScreen(navController : NavHostController){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ){
        Text(text = "Home",
             color = MaterialTheme.colorScheme.onBackground
        )
        FloatingActionButton(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(bottom = 100.dp, end = 16.dp),
            onClick = {
                navController.navigate("editor")
            }
        ) {
            Icon(Icons.Filled.Add, "Floating action button.")
        }
    }
}
@Composable
@Preview
fun HomeScreenPreview(){
    val nav = rememberNavController()
    HomeScreen(nav)
}
