package com.calyrsoft.ucbapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.calyrsoft.ucbapp.features.github.presentation.GithubScreen
import com.calyrsoft.ucbapp.features.profile.application.ProfileScreen

@Composable
fun AppNavigation() {
    val navController: NavHostController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Github.route
    ) {
        composable(Screen.Github.route){
            GithubScreen(modifier = Modifier)
        }
        composable(Screen.Home.route){

        }
        composable(Screen.Profile.route){
            ProfileScreen()
        }
    }
}